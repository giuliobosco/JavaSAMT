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
public class CounterThread extends Thread {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Sleep time of the thread.
     */
    public final static int CICLES_PER_MINUTE = 20;

    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * Global counter.
     */
    private Counter globalCounter;

    /**
     * Internal counter.
     */
    private Counter internalCounter;

    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Create the CounterThread with the global counter.
     *
     * @param globalCounter Counter of the thread.
     */
    public CounterThread(Counter globalCounter) {
        this.globalCounter = globalCounter;
        this.internalCounter = new Counter();
    }

    /**
     * Create the CounterThread with the global counter and the thread name.
     *
     * @param globalCounter
     * @param name
     */
    public CounterThread(Counter globalCounter, String name) {
        this(globalCounter);
        this.setName(name);
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

                Thread.sleep(60 * 1000 / CICLES_PER_MINUTE);
            }
        } catch (InterruptedException ie) {

        }
    }

    // ----------------------------------------------------------------------------------------------- Static Components
}
