/*
 * (C) Copyright 2020, Jan Benz, http://seltrox.de.
 *
 * This software is released under the terms of the Unlicense.
 * See https://unlicense.org/
 * for more information.
 *
 */

package de.jan.universalcommands.task;

import de.jan.universalcommands.UniversalCommands;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnectionTask {

    public void run(final UniversalCommands plugin) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (!(UniversalCommands.getClient().isConnected())) {
                    try {
                        UniversalCommands.getClient().start(plugin, "localhost");
                    } catch (IOException | TimeoutException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }.runTaskTimer(plugin, 20, 5 * 20);
    }

}