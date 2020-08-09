/*
 * (C) Copyright 2020, Jan Benz, http://seltrox.de.
 *
 * This software is released under the terms of the Unlicense.
 * See https://unlicense.org/
 * for more information.
 *
 */

package de.jan.universallib.packet;

import java.io.Serializable;

public abstract class Packet implements Serializable {

    private String command;

    public void setCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}