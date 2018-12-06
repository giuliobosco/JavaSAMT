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
 * @author giuliobosco
 * @version 1.0
 */
public class SequentialBomb extends Bomb {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * Previous bomb to explode, wait the first explode than run this bomb.
     */
    private Bomb previousBomb;

    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Create bomb with timeout time, period time, name of the bomb and previous bomb,
     *
     * @param timeOut      Timeout time.
     * @param period       Period in between ticks.
     * @param name         Name of the bomb.
     * @param previousBomb Previous bomb to explode.
     */
    public SequentialBomb(long timeOut, long period, String name, Bomb previousBomb) {
        super(timeOut, period, name);
        this.previousBomb = previousBomb;
    }

    /**
     * Create a bomb with name and previous bomb.
     *
     * @param name         Name of the bomb.
     * @param previousBomb Previous bomb to explode.
     */
    public SequentialBomb(String name, Bomb previousBomb) {
        super(name);
        this.previousBomb = previousBomb;
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Run the previous bomb then run this bomb.
     */
    @Override
    public void run() {
        if (this.previousBomb != null && this.previousBomb.isAlive()) {
            try {
                this.previousBomb.join();
            } catch (InterruptedException ignored) {

            }
        }

        super.run();
    }

    // ----------------------------------------------------------------------------------------------- Static Components

}
