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

package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author giuliobosco
 * @version 1.0
 */
public class EchoServer {
    // ------------------------------------------------------------------------------------ Costants

    /**
     * Quit the connection command.
     */
    public static final String QUIT_COMMAND = "quit";

    /**
     * Get the actual time on the server command.
     */
    public static final String TIME_COMMAND = "time";

    /**
     * Shut down the server socket command.
     */
    public static final String SHUT_COMMAND = "shutdown";

    // ---------------------------------------------------------------------------------- Attributes
    // --------------------------------------------------------------------------- Getters & Setters
    // -------------------------------------------------------------------------------- Constructors
    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods
    // --------------------------------------------------------------------------- Static Components

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5555);

            System.out.println("Server listening on port: 5555");

            boolean alive = true;
            while (alive) {
                Socket client = server.accept();

                System.out.println("Connection from: " + client.getRemoteSocketAddress().toString());
                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();

                boolean connected = true;
                int read = 0;
                String command = "";
                while ((read = in.read()) != -1 && connected) {
                    if (read == 13 || read == 10) {
                        command = "";
                    } else {
                        command += (char) read;
                    }

                    if (command.trim().equals(QUIT_COMMAND)) {
                        connected = false;
                    } else if (command.trim().equals(SHUT_COMMAND)) {
                        connected = false;
                        alive = false;
                    } else if (command.trim().equals(TIME_COMMAND)) {
                        Calendar cal = Calendar.getInstance();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String date = new Date().toString();//sdf.format(cal.getTime());
                        for (int i = 0; i < date.length(); i++) {
                            out.write(date.charAt(i));
                        }
                    } else {
                        out.write(read);
                    }
                    System.out.println(command);
                }
                System.out.println("Connection close with :" + client.getRemoteSocketAddress().toString());

                in.close();
                out.close();
                client.close();
            }

        } catch (IOException ignored) {

        }
    }
}
