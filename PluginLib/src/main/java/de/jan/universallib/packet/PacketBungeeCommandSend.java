/*
 * (C) Copyright 2020, Jan Benz, http://seltrox.de.
 *
 * This software is released under the terms of the Unlicense.
 * See https://unlicense.org/
 * for more information.
 *
 */

package de.jan.universallib.packet;

/**
 * Bungee with command -> spigot servers
 */
public class PacketBungeeCommandSend extends Packet {

    public PacketBungeeCommandSend(final String command) {
        this.setCommand(command);
    }
}