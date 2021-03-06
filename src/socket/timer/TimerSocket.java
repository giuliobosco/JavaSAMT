/*
 * The MIT License
 *
 * Copyright 2018 giuliobosco.
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

package socket.timer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Timer socket, return the requests of the client.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class TimerSocket extends Thread {
    // ------------------------------------------------------------------------------------ Costants

    /**
     * Connection length request code.
     */
    public static final int REQUEST_CODE = 65;

    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Connection socket.
     */
    private Socket socket;

    /**
     * Initial connection time.
     */
    private long initTime;

    // --------------------------------------------------------------------------- Getters & Setters
    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create time server with socket.
     * Initialize the initial time at the current time millis.
     *
     * @param socket Socket to use in the server timer.
     */
    public TimerSocket(Socket socket) {
        this.socket = socket;

        this.initTime = System.currentTimeMillis();
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    /**
     * Run the timer server.
     */
    @Override
    public void run() {
        try {
            System.out.println("Client connected " + socket.getRemoteSocketAddress() + ":" + socket.getPort());
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            int read = 0;
            while ((read = in.read()) != -1) {
                if (read == REQUEST_CODE) {
                    long difference = System.currentTimeMillis() - this.initTime;
                    byte min = (byte) (difference / 60000);
                    byte sec = (byte) ((difference - min * 60000) / 1000);
                    byte millis = (byte) (difference - min * 60000 - sec * 1000);

                    out.write(new byte[]{min, sec, millis});
                }
            }

            out.close();
            in.close();
            socket.close();
            System.out.println("Client disconnected" + socket.getRemoteSocketAddress() + ":" + socket.getPort());
        } catch (IOException ignored) {

        }
    }

    // --------------------------------------------------------------------------- Static Components

}
