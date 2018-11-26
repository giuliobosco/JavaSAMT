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

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author giuliobosco
 * @version 1.0
 */
public class Timer extends Thread {
    // -------------------------------------------------------------------------------------------------------- Costants

    public static final int INITIAL_RADIIUS = 20;

    public static final int SLEEP_TIME = 1000;

    // ------------------------------------------------------------------------------------------------------ Attributes

    private List<TimerListener> listeners;

    private Point center;

    private int radius;

    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    public Timer(int x, int y) {
        this(new Point(x, y));
    }

    public Timer(Point center) {
        this.center = center;
        this.radius = INITIAL_RADIIUS;

        this.listeners = new ArrayList<>();
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods

    public void addTimerListener(TimerListener listener) {
        this.listeners.add(listener);
    }

    public void removeTimerListener(TimerListener listener) {
        this.listeners.remove(listener);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < this.radius; i++) {
            if (i % 2 == 0) {
                g.setColor(Color.green);
            } else {
                g.setColor(Color.red);
            }

            g.fillOval(center.x - i, center.y - i, i * 2, i * 2);
        }
    }

    public void run() {
        try {
            while (radius > 0) {
                for (TimerListener listener : this.listeners) {
                    listener.timeElapsed(this);
                }
                radius--;
                Thread.sleep(SLEEP_TIME);
            }
        } catch (InterruptedException ie) {

        }
    }

    // ----------------------------------------------------------------------------------------------- Static Components
    
}
