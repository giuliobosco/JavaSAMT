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

package datagram;

import java.awt.*;
import javax.swing.*;

/**
 * Chat.
 *
 * @author giuliobosco
 * @version 1.0 (2019-02-20)
 */
public class ChatFrame extends JFrame {

    /**
     * Chat panel.
     */
    private ChatPanel chatPanel;

    /**
     * Creates new form ChatFrame.
     *
     * @param port Listening port.
     */
    public ChatFrame(int port) {
        super("Chat - " + port);
        chatPanel = new ChatPanel(port);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(chatPanel, BorderLayout.CENTER);

        pack();
    }

    /**
     * Run the chat.
     *
     * @param args Command line arguments (first argument: listening port).
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            try {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new ChatFrame(Integer.parseInt(args[0])).setVisible(true);
                    }
                });
            } catch (NumberFormatException nfe) {
                System.out.println("Not a port.");
            }
        } else {
            System.out.println("Insert a port please.");
        }
    }

}
