/*
 * (C) Copyright 2020, Jan Benz, http://seltrox.de.
 *
 * This software is released under the terms of the Unlicense.
 * See https://unlicense.org/
 * for more information.
 *
 */

package de.jan.universalcommands.client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import de.jan.universalcommands.UniversalCommands;
import de.jan.universallib.packet.Packet;
import de.jan.universallib.packet.PacketBungeeCommandSend;
import de.jan.universallib.packet.PacketSerialization;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class UniversalClient {

    private final String EXCHANGE_NAME = "universalcommands";

    private Connection connection;
    private Channel channel;

    public void start(final UniversalCommands plugin, final String host) throws IOException, TimeoutException {
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);

        this.connection = factory.newConnection();
        this.channel = this.connection.createChannel();
        this.channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        final String queueName = this.channel.queueDeclare().getQueue();
        this.channel.queueBind(queueName, EXCHANGE_NAME, "");
        final DeliverCallback callback = (consumerTag, delivery) -> {
            final Packet packet = PacketSerialization.deserialize(delivery.getBody());
            if (packet instanceof PacketBungeeCommandSend) {
                final String command = packet.getCommand();
                System.out.println("[CLIENT] Received request with command \"" + command + "\"");
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                    }
                }.runTask(plugin);
            }
        };
        this.channel.basicConsume(queueName, true, callback, consumerTag -> {
        });
    }

    public void sendPacket(final Packet packet) throws IOException {
        this.channel.basicPublish(EXCHANGE_NAME, "", null, PacketSerialization.serialize(packet));
    }

    public boolean isConnected() {
        return this.connection != null && this.connection.isOpen();
    }

    public void stop() throws IOException, TimeoutException {
        this.channel.close();
        this.connection.close();
    }
}