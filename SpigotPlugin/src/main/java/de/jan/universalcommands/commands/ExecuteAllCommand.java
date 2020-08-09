/*
 * (C) Copyright 2020, Jan Benz, http://seltrox.de.
 *
 * This software is released under the terms of the Unlicense.
 * See https://unlicense.org/
 * for more information.
 *
 */

package de.jan.universalcommands.commands;

import de.jan.universalcommands.UniversalCommands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;

public class ExecuteAllCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
        if (commandSender.hasPermission("commands.executeall")) {
            if (args.length > 0) {
                StringBuilder command = new StringBuilder();
                for (String arg : args) {
                    command.append(arg).append(" ");
                }
                commandSender.sendMessage(UniversalCommands.PREFIX + "The §acommand §7will be sent to all servers...");
                try {
                    UniversalCommands.getApi().sendRequest(command.toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                commandSender.sendMessage(UniversalCommands.PREFIX + "Use: §a/executeAll (command)");
            }
        } else {
            commandSender.sendMessage(UniversalCommands.NO_PERMISSION);
        }
        return false;
    }
}