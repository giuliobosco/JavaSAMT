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

package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Echo client, client for echo server.
 *
 * @author giuliobosco
 * @version 1.0 (2019-01-31)
 */
public class EchoClient {
    // ------------------------------------------------------------------------------------ Costants

    /**
     * Client port.
     */
    public final static int PORT = 5555;

    /**
     * Client host.
     */
    public final static String HOST = "127.0.0.1";

    // ---------------------------------------------------------------------------------- Attributes
    // --------------------------------------------------------------------------- Getters & Setters
    // -------------------------------------------------------------------------------- Constructors
    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods
    // --------------------------------------------------------------------------- Static Components

    /**
     * Main method of the class.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        try {
            Socket server = new Socket(HOST, PORT);
            InputStream in = server.getInputStream();
            OutputStream out = server.getOutputStream();
            int read = 0;
            while ((read = System.in.read()) != -1) {
                out.write(read);
                System.out.print((char) in.read());
            }
            out.close();
            in.close();
            server.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
