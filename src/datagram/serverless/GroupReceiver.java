/*
 * The MIT License
 *
 * Copyright 2019 giuliobosco.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package datagram.serverless;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.MulticastSocket;

/**
 * Group receiver, listen for datagram packets in the group and send them to the group listener.
 *
 * @author giuliobosco (giuliobva@gmail.com)
 * @version 1.0 (2019-02-21)
 */
public class GroupReceiver extends Thread {
    // ------------------------------------------------------------------------------------ Costants
    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Listener for the datagram packets received.
     */
    private GroupListener groupListener;

    /**
     * Multicast socket.
     */
    private MulticastSocket socket;

    // --------------------------------------------------------------------------- Getters & Setters
    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the group receiver.
     *
     * @param groupListener Listener for the datagram packets received.
     * @param socket        Multicast socket.
     */
    public GroupReceiver(GroupListener groupListener, MulticastSocket socket) {
        this.groupListener = groupListener;
        this.socket = socket;
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    /**
     * Run the multicast socket, listen for datagram packets in the group and send them to the
     * group listener.
     */
    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                byte[] buffer = new byte[256];

                DatagramPacket receivedDatagram = new DatagramPacket(
                        buffer,
                        buffer.length,
                        this.socket.getInetAddress(),
                        this.socket.getLocalPort()
                );

                this.socket.receive(receivedDatagram);

                this.groupListener.datagramPacketReceived(receivedDatagram);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    // --------------------------------------------------------------------------- Static Components

}
