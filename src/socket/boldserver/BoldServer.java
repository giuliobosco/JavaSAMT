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

package socket.boldserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author giuliobosco (giuliobva@gmail.com)
 * @version 1.0 (2019-04-05)
 */
public class BoldServer extends Thread {
    // ------------------------------------------------------------------------------------ Costants
    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Path of the file to serve.
     */
    private Path path;

    /**
     * Listening port of the server.
     */
    private int port;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Get the path of the file to serve.
     *
     * @return Path of the file to serve.
     */
    public Path getPath() {
        return this.path;
    }

    /**
     * Get the listening port of the server.
     *
     * @return Listening port of the server.
     */
    public int getPort() {
        return this.port;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create bold server with the path of the file to serve and the listening port of the server.
     *
     * @param path Path of the file to serve.
     * @param port Listening port of the server.
     * @throws IOException The file is not available or the port is not valid.
     */
    public BoldServer(Path path, int port) throws IOException {
        if (!(Files.exists(path) && !Files.notExists(path) && Files.isReadable(path))) {
            throw new IOException(path.toString() + " is not available.");
        }

        if (port > 0 && port < 65535) {
            throw new IOException(port + " is not a valid port");
        }

        this.path = path;
        this.port = port;
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    /**
     * Run method of hte bold server, open the server on the right port, and create for each
     * request a new BoldThread.
     */
    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(getPort());

            while (!isInterrupted()) {
                new BoldThread(getPath(), server.accept());
            }
        } catch (IOException ioe) {

        }
    }

    // --------------------------------------------------------------------------- Static Components

    public static void main(String[] args){
        try {
            new BoldServer(Paths.get("divina.html"), 80);
        } catch (IOException ioe) {

        }
    }

}
