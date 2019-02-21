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

package datagram.peer2peer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.*;

/**
 * Chat Panel.
 *
 * @author giuliobosco
 * @version 1.0 (2019-02-18)
 */
public class ChatPanel extends JPanel implements ChatListener {

    /**
     * Chat receiver.
     */
    private ChatReceiver chatReceiver;

    /**
     * IP Label.
     */
    private JLabel ipLabel;

    /**
     * Ip Text Field.
     */
    private JTextField ipTextField;

    /**
     * Port  Label.
     */
    private JLabel portLabel;

    /**
     * Port text field.
     */
    private JTextField portTextField;

    /**
     * Message Label.
     */
    private JLabel messageLabel;

    /**
     * Message Label.
     */
    private JLabel messagesLabel;

    /**
     * Message Text Field.
     */
    private JTextField messageTextField;

    /**
     * Send Message button.
     */
    private JButton sendMessageButton;

    /**
     * Message Scroll Pane.
     */
    private JScrollPane messagesScrollPane;

    /**
     * Message text area.
     */
    private JTextArea messagesTextArea;

    /**
     * Creates new ChatPanel.
     *
     * @param port Listening port.
     */
    public ChatPanel(int port) {

        // ---------------- chat Receiver
        this.chatReceiver = new ChatReceiver(this,port);
        this.chatReceiver.start();

        GridBagConstraints gridBagConstraints;

        setLayout(new GridBagLayout());

        // ---------------- ipLabel
        ipLabel = new JLabel();
        ipLabel.setText("IP:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(ipLabel, gridBagConstraints);

        // ---------------- ipTextField
        ipTextField = new JTextField();
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        add(ipTextField, gridBagConstraints);

        // ---------------- portLabel
        portLabel = new JLabel();
        portLabel.setText("Port:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;

        // ---------------- portTextField
        portTextField = new JTextField();
        add(portLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(portTextField, gridBagConstraints);

        // ---------------- messageLabel
        messageLabel = new JLabel();
        messageLabel.setText("message:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(messageLabel, gridBagConstraints);

        // ---------------- messageTextField
        messageTextField = new JTextField();
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(messageTextField, gridBagConstraints);

        // ---------------- sendButton
        sendMessageButton = new JButton();
        sendMessageButton.setText("Send Message");
        sendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(sendMessageButton, gridBagConstraints);

        // ---------------- messagesLabel
        messagesLabel = new JLabel();
        messagesLabel.setText("messages:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(messagesLabel, gridBagConstraints);

        // ---------------- messagesScrolPane & textArea
        messagesScrollPane = new JScrollPane();
        messagesTextArea = new JTextArea();
        messagesTextArea.setColumns(20);
        messagesTextArea.setRows(5);
        messagesScrollPane.setViewportView(messagesTextArea);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        add(messagesScrollPane, gridBagConstraints);
    }

    /**
     * Send message to host.
     *
     * @param e Send message action event.
     */
    private void sendMessageButtonActionPerformed(ActionEvent e) {
        try {
            InetAddress address = InetAddress.getByName(this.ipTextField.getText());
            int port = Integer.parseInt(this.portTextField.getText());
            System.out.println(this.messageTextField.getText());
            byte[] buffer = this.messageTextField.getText().getBytes();
            DatagramPacket packet = new DatagramPacket(
                    buffer,
                    buffer.length,
                    address,
                    port);

            System.out.println("try");
            DatagramSocket socket = new DatagramSocket(port);
            socket.send(packet);
            socket.close();
            System.out.println("ok");
        } catch (UnknownHostException uhe) {

        } catch (NumberFormatException nfe) {

        } catch (IOException se) {

        }
    }

    /**
     * Message received.
     *
     * @param packet Received packet.
     */
    @Override
    public void messageReceived(DatagramPacket packet) {
        String toAppend = "";
        toAppend += packet.getAddress().toString() + ":";
        toAppend += packet.getPort() + "->";
        toAppend += new String(packet.getData());
        toAppend += "\n";

        this.messagesTextArea.append(toAppend);
    }
}
