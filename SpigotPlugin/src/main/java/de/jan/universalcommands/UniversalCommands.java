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
import de.jan.universalcommands.client.UniversalClient;
import de.jan.universalcommands.commands.ExecuteAllCommand;
import de.jan.universalcommands.task.ConnectionTask;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public final class UniversalCommands extends JavaPlugin {

    public static final String PREFIX = "§aUniversalCommands §8» §7";
    public static final String NO_PERMISSION = PREFIX + "You don't have permission to do this!";

    private static UniversalClient client;
    private static UniversalCommandsAPI api;

    @Override
    public void onEnable() {
        client = new UniversalClient();
        new ConnectionTask().run(this);
        api = new UniversalCommandsAPI();
        this.getCommand("executeAll").setExecutor(new ExecuteAllCommand());
    }

    @Override
    public void onDisable() {
        try {
            client.stop();
        } catch (IOException | TimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public static UniversalCommandsAPI getApi() {
        return api;
    }

    public static UniversalClient getClient() {
        return client;
    }
}