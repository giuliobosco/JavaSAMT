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
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Bold Thread, serve html page, on a HTTP GET request, it will return in bold the content of the
 * request, example: http://localhost/word. The html word will be opened from
 *
 * @author giuliobosco (giuliobva@gmail.com)
 * @version 1.0 (2019-04-05)
 */
public class BoldThread extends Thread {
    // ------------------------------------------------------------------------------------ Costants

    private final String HTTP_HEADER = "HTTP/1.1 GET 200 OK";

    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Path of the file to serve.
     */
    private Path path;

    /**
     * Socket with the connection with the client.
     */
    private Socket socket;

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
     * Get the socket with the connection with the client.
     *
     * @return Socket with the connection with the client.
     */
    public Socket getSocket() {
        return this.socket;
    }

    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the BoldThread with the path of the file to server and the socket with the connection
     * with the client.
     *
     * @param path   Path of the file to serve.
     * @param socket Socket with connection with the client.
     */
    public BoldThread(Path path, Socket socket) {
        this.path = path;
        this.socket = socket;
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    @Override
    public void run() {
        try {
            InputStream in = this.getSocket().getInputStream();
            OutputStream out = this.getSocket().getOutputStream();

            int read = 0;
            String url = "";

            while ((read = in.read()) != -1) {
                if (read == 13 || read == 10) {
                    url += "\n";
                } else {
                    url += (char) read;
                }
            }

            if (url.contains("GET")) {
                String word = url.substring(url.lastIndexOf('/'));

                String file = new String(Files.readAllBytes(path));

                int bodyStartIndex = file.indexOf("<body>");
                int bodyEndIndex = file.lastIndexOf("</body>");

                String init = file.substring(0, bodyStartIndex + 6);
                String end = file.substring(bodyEndIndex, file.length());

                file = file.substring(bodyStartIndex + 6, bodyEndIndex);

                file = file.replaceAll(word, "<b>" + word + "</b>");

                file = init + file + end;

                out.write(file.getBytes());
            }
        } catch (IOException ioe) {

        }
    }

    // --------------------------------------------------------------------------- Static Components

}
