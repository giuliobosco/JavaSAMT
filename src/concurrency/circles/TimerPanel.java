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
package concurrency.circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Panel for the Timer.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class TimerPanel extends JPanel implements MouseListener, TimerListener {


    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * Timers in the panel.
     */
    private List<Timer> timers;

    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Create the timer panel, initialize the timers and add the mouse listener.
     */
    public TimerPanel() {
        this.timers = new ArrayList<>();

        this.addMouseListener(this);
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * An Timer has made an tick.
     *
     * @param source Source timer.
     */
    @Override
    public void timeElapsed(Timer source) {
        this.repaint();
    }

    @Override
    public void click() {

    }

    /**
     * Mouse clicked in the TimerPanel.
     *
     * @param e Mouse clicked event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Timer timer = new Timer(e.getPoint());
        timer.addTimerListener(this);
        timer.start();
        this.timers.add(timer);
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    /**
     * Paint the timers.
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        for (Timer timer : this.timers) {
            timer.paint(g);
        }
    }

    // ----------------------------------------------------------------------------------------------- Static Components

}
