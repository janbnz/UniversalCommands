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
 * Spigot with command -> BungeeCord
 */
public class PacketSpigotCommandSend extends Packet {

    public PacketSpigotCommandSend(final String command) {
        this.setCommand(command);
    }

}