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

package algorithms.prime;

/**
 * Main class for test the class PrimeNumbersFinder and PrimeCounter.
 * 
 * @author giuliobosco
 * @version 24.01.2019
 */
public class Main {
    
    /**
     * Main method of the class.
     * 
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        PrimeCounter counter = new PrimeCounter();
        
        PrimeFinderThread[] pfts = new PrimeFinderThread[100];
        
        for (int i = 0; i < pfts.length; i++) {
            pfts[i] = new PrimeFinderThread(100 * i + 1, 100 * (i + 1));
            pfts[i].setCounter(counter);
            
            if (i > 0) {
                pfts[i].setPrevious(pfts[i - 1]);
            }
            
            pfts[i].start();
        }
    }
}
