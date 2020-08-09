/*
 * (C) Copyright 2020, Jan Benz, http://seltrox.de.
 *
 * This software is released under the terms of the Unlicense.
 * See https://unlicense.org/
 * for more information.
 *
 */

package de.jan.universalcommands.api;

import de.jan.universalcommands.UniversalCommands;
import de.jan.universallib.packet.PacketBungeeCommandSend;

import java.io.IOException;

public class UniversalCommandsAPI {

    public static void sendCommand(final String command) throws IOException {
        System.out.println("[SERVER] Received request and sending command \"" + command + "\" to servers...");
        UniversalCommands.getServer().sendPacket(new PacketBungeeCommandSend(command));
    }

}