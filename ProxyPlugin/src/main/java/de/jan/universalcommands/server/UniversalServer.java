/*
 * (C) Copyright 2020, Jan Benz, http://seltrox.de.
 *
 * This software is released under the terms of the Unlicense.
 * See https://unlicense.org/
 * for more information.
 *
 */

package de.jan.universalcommands.server;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import de.jan.universallib.packet.Packet;
import de.jan.universallib.packet.PacketBungeeCommandSend;
import de.jan.universallib.packet.PacketSerialization;
import de.jan.universallib.packet.PacketSpigotCommandSend;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class UniversalServer {

    private final String EXCHANGE_NAME = "universalcommands";

    private Connection connection;
    private Channel channel;

    public void start(final String host) throws IOException, TimeoutException {
        final ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);

        this.connection = factory.newConnection();
        this.channel = this.connection.createChannel();
        this.channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        final String queueName = this.channel.queueDeclare().getQueue();
        this.channel.queueBind(queueName, EXCHANGE_NAME, "");
        final DeliverCallback callback = (consumerTag, delivery) -> {
            final Packet packet = PacketSerialization.deserialize(delivery.getBody());
            if (packet instanceof PacketSpigotCommandSend) {
                final String command = packet.getCommand();
                System.out.println("[SERVER] Received request and sending command \"" + command + "\" to servers...");
                this.sendPacket(new PacketBungeeCommandSend(command));
            }
        };
        this.channel.basicConsume(queueName, true, callback, consumerTag -> {
        });
    }

    public void sendPacket(final Packet packet) throws IOException {
        this.channel.basicPublish(EXCHANGE_NAME, "", null, PacketSerialization.serialize(packet));
    }

    public void stop() throws IOException, TimeoutException {
        this.channel.close();
        this.connection.close();
    }
}