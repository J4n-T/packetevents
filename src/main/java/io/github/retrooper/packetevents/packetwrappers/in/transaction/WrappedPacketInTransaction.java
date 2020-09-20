/*
 * MIT License
 *
 * Copyright (c) 2020 retrooper
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.retrooper.packetevents.packetwrappers.in.transaction;

import io.github.retrooper.packetevents.packettype.PacketTypeClasses;
import io.github.retrooper.packetevents.packetwrappers.WrappedPacket;

public final class WrappedPacketInTransaction extends WrappedPacket {
    private static Class<?> packetClass;
    private int windowId;
    private short actionNumber;
    private boolean accepted;
    public WrappedPacketInTransaction(final Object packet) {
        super(packet);
    }

    public static void load() {
        packetClass = PacketTypeClasses.Client.TRANSACTION;
    }

    @Override
    protected void setup() {
        this.windowId = readInt(0);
        this.actionNumber = readShort(0);
        this.accepted = readBoolean(0);
    }

    /**
     * Get the window ID.
     * @return Window ID
     */
    public int getWindowId() {
        return windowId;
    }

    /**
     * Get the action number.
     * @return Action number
     */
    public short getActionNumber() {
        return actionNumber;
    }

    /**
     * Is transaction accepted.
     * @return Transaction Accepted
     */
    public boolean isAccepted() {
        return accepted;
    }
}
