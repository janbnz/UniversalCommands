/*
 * (C) Copyright 2020, Jan Benz, http://seltrox.de.
 *
 * This software is released under the terms of the Unlicense.
 * See https://unlicense.org/
 * for more information.
 *
 */

package de.jan.universallib.packet;

import java.io.*;

public class PacketSerialization {

    public static byte[] serialize(final Packet packet) {
        byte[] bytes;
        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            final ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(packet);
            objectOutputStream.flush();
            objectOutputStream.reset();
            bytes = outputStream.toByteArray();
            objectOutputStream.close();
            outputStream.close();
        } catch (IOException ex) {
            bytes = new byte[]{};
            ex.printStackTrace();
        }
        return bytes;
    }

    public static Packet deserialize(final byte[] bytes) {
        Packet packet = null;
        try {
            final ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
            final ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            packet = (Packet) objectInputStream.readObject();
            objectInputStream.close();
            inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return packet;
    }


}