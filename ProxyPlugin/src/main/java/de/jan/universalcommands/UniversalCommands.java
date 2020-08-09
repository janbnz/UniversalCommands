/*
 * (C) Copyright 2020, Jan Benz, http://seltrox.de.
 *
 * This software is released under the terms of the Unlicense.
 * See https://unlicense.org/
 * for more information.
 *
 */

package de.jan.universalcommands;

import de.jan.universalcommands.api.UniversalCommandsAPI;
import de.jan.universalcommands.server.UniversalServer;
import net.md_5.bungee.api.plugin.Plugin;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public final class UniversalCommands extends Plugin {

    private static UniversalServer server;
    private static UniversalCommandsAPI api;

    @Override
    public void onEnable() {
        server = new UniversalServer();
        try {
            server.start("localhost");
        } catch (IOException | TimeoutException ex) {
            ex.printStackTrace();
        }
        api = new UniversalCommandsAPI();
    }

    @Override
    public void onDisable() {
        try {
            server.stop();
        } catch (IOException | TimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public static UniversalCommandsAPI getApi() {
        return api;
    }

    public static UniversalServer getServer() {
        return server;
    }
}