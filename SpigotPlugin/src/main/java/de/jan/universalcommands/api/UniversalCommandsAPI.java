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
import de.jan.universallib.packet.PacketSpigotCommandSend;

import java.io.IOException;

public class UniversalCommandsAPI {

    public void sendRequest(final String command) throws IOException {
        System.out.println("[CLIENT] Requesting command \"" + command + "\" to proxy..");
        UniversalCommands.getClient().sendPacket(new PacketSpigotCommandSend(command));
    }

}