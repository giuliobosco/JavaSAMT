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
package concurrency.bomb;

import java.util.ArrayList;
import java.util.List;

/**
 * Bomb is a thread for exercise the concurrency programming paradigm.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class Bomb extends Thread {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Default timeout time. Value: 30 seconds.
     */
    public static final long DEFAULT_TIME_OUT = 30000;

    /**
     * Default Period time. Value 0.5 seconds.
     */
    public static final long DEFAUL_PERIOD = 500;

    /**
     * Default bomb name. Value: "Bomb".
     */
    public static final String DEFAULT_NAME = "Bomb";

    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * Timeout time. Time to explode bomb.
     */
    protected long timeOut;

    /**
     * Period in between ticks.
     */
    protected long period;

    // ----------------------------------------------------------------------------------------------- Getters & Setters

    /**
     * Get the timeout time.
     *
     * @return Timeout time.
     */
    public long getTimeOut() {
        return this.timeOut;
    }

    /**
     * Get the period in between ticks.
     *
     * @return Period in between ticks.
     */
    public long getPeriod() {
        return this.period;
    }

    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Constructors with timeout time, period in between ticks and name of the bomb.
     *
     * @param timeOut Timeout time.
     * @param period  Period in between ticks.
     * @param name    Name of the bomb.
     */
    public Bomb(long timeOut, long period, String name) {
        this.timeOut = timeOut;
        this.period = period;
        this.setName(name);
    }

    /**
     * Constructors with timeout time and period in between ticks. Name of the bomb set with default values.
     *
     * @param timeOut Timeout time.
     * @param period  Period in between ticks.
     */
    public Bomb(long timeOut, long period) {
        this(timeOut, period, DEFAULT_NAME);
    }

    /**
     * Constructors with timeout time. Period in between ticks and bomb name set with default values.
     *
     * @param timeOut Timeout time.
     */
    public Bomb(long timeOut) {
        this(timeOut, DEFAUL_PERIOD);
    }

    /**
     * Constructors with the name of the bomb. Timeout time and period in between ticks set with default values.
     *
     * @param name Name of the bomb.
     */
    public Bomb(String name) {
        this(DEFAULT_TIME_OUT, DEFAUL_PERIOD, name);
    }

    /**
     * Constructor without parameters. All defaults values.
     */
    public Bomb() {
        this(DEFAULT_TIME_OUT);
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Run the thread. Execute an tick (TIC or TAC) alternately by the period. After the timeout the bomb will explode
     * (BOOOMMMM!!!). If the thread receive an Interruption the bomb will be unarmed.
     */
    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();
            boolean ticTac = true;

            while (System.currentTimeMillis() < startTime + this.timeOut) {
                System.out.format("Bomb %s: %s", this.getName(), ticTac ? "Tic" : "Tac");
                ticTac = !ticTac;
                Thread.sleep(period);
            }

            System.out.println("Bomb " + this.getName() + " BOOOMMMM!!!");
        } catch (InterruptedException ie) {
            System.out.println("Bomb " + this.getName() + " unarmed");
        }
    }

    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Main class for test the class.
     * Create 3 bombs, 2 bombs will explode and one will be disarmed.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        String[] names = {"Nuclear", "Hydrogen", "Granate"};
        List<Bomb> bombs = new ArrayList<>();
        for (String name : names) {
            bombs.add(new Bomb(name));
            bombs.get(bombs.size() - 1).start();
        }

        try {
            Thread.sleep(15000);
            bombs.get(bombs.size() / 2).interrupt();
        } catch (InterruptedException ie) {

        }
    }
}
