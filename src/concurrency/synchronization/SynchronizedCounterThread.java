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

package concurrency.synchronization;

import help.Random;

/**
 * Create two synchronized counter, an internal and an external, random increase or decrease them.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class SynchronizedCounterThread extends Thread {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Sleep time of the thread.
     */
    public final static int CICLES_PER_MINUTE = 20;

    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * Global synchronized counter.
     */
    private SynchronizedCounter globalCounter;

    /**
     * Internal synchronized counter.
     */
    private SynchronizedCounter internalCounter;

    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Create the synchronized counter thread with the global counter and the thread name.
     *
     * @param globalCoutner Synchronized counter thread.
     * @param name          Thead name.
     */
    public SynchronizedCounterThread(SynchronizedCounter globalCoutner, String name) {
        this.globalCounter = globalCoutner;
        this.internalCounter = new SynchronizedCounter();
        this.setName(name);
    }

    /**
     * Create the Synchronized counter thread with the global counter,
     *
     * @param globalCounter Synchronized global counter.
     */
    public SynchronizedCounterThread(SynchronizedCounter globalCounter) {
        this(globalCounter, "Synchronized Counter Thread");
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Run the thread.
     */
    @Override
    public void run() {
        try {
            while (!this.isInterrupted()) {
                int rnd = Random.getInt(2);

                if (rnd == 1) {
                    this.globalCounter.increment();
                    this.internalCounter.increment();
                } else {
                    this.globalCounter.decrement();
                    this.internalCounter.decrement();
                }

                System.out.println(this.toString());
                Thread.sleep(60 * 1000 / CICLES_PER_MINUTE);
            }
        } catch (InterruptedException ie) {

        }
    }

    /**
     * Write the values of the CounterThread, Print the name of the thread and the values of the counters.
     *
     * @return String with the name of the CounterThread and the values of the counters.
     */
    @Override
    public String toString() {
        return this.getName() + ": [internal: " + this.internalCounter.value() + ", global: " + this.globalCounter.value() + "]";
    }

    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Main class method, test the class.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

        SynchronizedCounterThread sct1 = new SynchronizedCounterThread(synchronizedCounter, "sct1");
        SynchronizedCounterThread sct2 = new SynchronizedCounterThread(synchronizedCounter, "sct2");
        sct1.start();
        sct2.start();
    }
}
