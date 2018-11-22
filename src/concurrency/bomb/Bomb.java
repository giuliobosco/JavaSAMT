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
/**
 * 
 * @author giuliobosco
 * @version 1.0
 */
public class Bomb extends Thread {
    // -------------------------------------------------------------------------------------------------------- Costants

    public static final long DEFAULT_TIME_OUT = 30000;

    public static final long DEFAUL_PERIOD = 500;

    public static final String DEFAULT_NAME = "Bomb";

    // ------------------------------------------------------------------------------------------------------ Attributes

    private long timeOut;

    private long period;

    // ----------------------------------------------------------------------------------------------- Getters & Setters

    public long getTimeOut() {
        return this.timeOut;
    }

    public long getPeriod() {
        return this.period;
    }

    // ---------------------------------------------------------------------------------------------------- Constructors

    public Bomb(long timeOut, long period, String name) {
        this.timeOut = timeOut;
        this.period = period;
        this.setName(name);
    }

    public Bomb(long timeOut, long period) {
        this(timeOut, period, DEFAULT_NAME);
    }

    public Bomb(long timeOut) {
        this(timeOut, DEFAUL_PERIOD);
    }

    public Bomb(String name) {
        this(DEFAULT_TIME_OUT, DEFAUL_PERIOD, name);
    }

    public Bomb() {
        this(DEFAULT_TIME_OUT);
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis();

            while (System.currentTimeMillis() < startTime + this.timeOut) {
                System.out.println("Bomb " + this.getName() + ": TIC");
                Thread.sleep(period);

                System.out.println("Bomb " + this.getName() + ": TAC");
                Thread.sleep(period);
            }

            System.out.println("Bomb " + this.getName() + " exploded");
        } catch (InterruptedException ie) {
            System.out.println("Bomb " + this.getName() + " unarmed");
        }
    }

    // ----------------------------------------------------------------------------------------------- Static Components

    public static void main(String[] args) {
        String[] names = {"Nuclear", "Hydrogen", "Granate"};

        for (String name : names) {
            (new Bomb(name)).start();
        }
    }
}
