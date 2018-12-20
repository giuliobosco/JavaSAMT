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
 * Create two counter, an internal and an external, random increase or decrease them.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class SynchronizedCounterThread extends Thread {
    // ------------------------------------------------------------------------------------ Costants

    /**
     * Cycles to execute.
     */
    public final static int CYCLES = 10000;

    // ---------------------------------------------------------------------------------- Attributes

    /**
     * Global counter.
     */
    private SynchronizedCounter globalCounter;

    /**
     * Internal counter.
     */
    private SynchronizedCounter internalCounter;

    // --------------------------------------------------------------------------- Getters & Setters

    /**
     * Get the internal counter.
     *
     * @return Internal counter.
     */
    public SynchronizedCounter getInternalCounter() {
        return this.internalCounter;
    }


    // -------------------------------------------------------------------------------- Constructors

    /**
     * Create the CounterThread with the global counter.
     *
     * @param globalCounter Counter of the thread.
     */
    public SynchronizedCounterThread(SynchronizedCounter globalCounter) {
        this.globalCounter = globalCounter;
        this.internalCounter = new SynchronizedCounter();
    }

    /**
     * Create the CounterThread with the global counter and the thread name.
     *
     * @param globalCounter Global counter.
     * @param name          Name of the thread.
     */
    public SynchronizedCounterThread(SynchronizedCounter globalCounter, String name) {
        this(globalCounter);
        this.setName(name);
    }

    // -------------------------------------------------------------------------------- Help Methods
    // ----------------------------------------------------------------------------- General Methods

    /**
     * Run the thread.
     */
    @Override
    public void run() {
        for (int i = 0; i < CYCLES; i++) {
            int rnd = Random.getInt(2);
            if (rnd == 1) {
                this.globalCounter.increment();
                this.internalCounter.increment();
            } else {
                this.globalCounter.decrement();
                this.internalCounter.decrement();
            }
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

    // --------------------------------------------------------------------------- Static Components

    public static void main(String[] args) {
        SynchronizedCounter counter = new SynchronizedCounter();

        SynchronizedCounterThread[] counterThreads = new SynchronizedCounterThread[20];
        for (int i = 0; i < counterThreads.length; i++) {
            counterThreads[i] = new SynchronizedCounterThread(counter, "ct" + i);
            counterThreads[i].start();
        }

        try {
            Thread.sleep(10000);

            int sum = 0;
            for (int i = 0; i < counterThreads.length; i++) {
                counterThreads[i].join();
                sum += counterThreads[i].getInternalCounter().value();
            }

            System.out.println("sum of internals: " + sum);
            System.out.println("global counter: " + counter.value());
        } catch (InterruptedException ie) {

        }
    }
}
