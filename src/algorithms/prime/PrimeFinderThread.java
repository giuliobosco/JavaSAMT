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
 * Prime numbers finder.
 * 
 * @author giuliobosco
 * @version 24.01.2019
 */
public class PrimeFinderThread extends Thread {
    
    /**
     * Start of the range where the finder have to count all the prime numbers.
     */
    private long start;
    
    /**
     * End of the range where the finder have to count all the prime numbers.
     */
    private long end;
    
    /**
     * Internal counter of the prime numbers found.
     */
    private long count;
    
    /**
     * Global prime numbers finder.
     */
    private PrimeCounter counter;
    
    /**
     * Previous global numbers finder.
     * Before finish this global numbers finder finish the previous global 
     * numbers finder.
     */
    private PrimeFinderThread previous;
    
    /**
     * Create the PrimeFinderThread with the start and the end of the range 
     * where the finder have to count all the prime numbers.
     * Initialize the internal counter to 0.
     * 
     * @param start Start of the range where the finder have to count all the 
     *              prime numbers.
     * @param end   End of the range where the finder have to count all the 
     *              prime numbers.
     */
    PrimeFinderThread(long start, long end) {
        this.start = start;
        this.end = end;
        
        this.count = 0;
    }
    
    /**
     * Set the global prime numbers finder.
     * 
     * @param counter Global prime numbers finder.
     */
    public void setCounter(PrimeCounter counter) {
        this.counter = counter;
    }
    
    /**
     * Set the previous global numbers finder.
     * 
     * @param previous Previous global numbers finder.
     */
    public void setPrevious(PrimeFinderThread previous) {
        this.previous = previous;
    }
    
    /**
     * Check if the number passed as parameter is a prime number.
     * The algorithm for search the prime number looks at first if the number, 
     * is even if it's and is 2, it will return true, other way false. If the 
     * number is odd it try if it's divisible by first half of his previous 
     * numbers, if it's divisible by one and his module is 0 it will return 
     * false, if after he tried all the numbers he will return true.
     * 
     * @param n Number to check.
     * @return True if the number is prime, other ways false.
     */
    public boolean isPrime(long n) {
        if (n % 2 == 0) {
            if (n == 2) {
                return  true;
            }
            return false;
        } else {
            for (long i = 3; i < n / 2 + 1; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Run the prime finder thread.
     * Check all the numbers in the range in between start and end, if founds a 
     * prime number increase the internal counter and if there is one the global
     * counter.
     * Then, when he finished his research, he wait for the finish of the 
     * previous thread, and then prints the message with the start and the end 
     * of the range and the number of primes numbers he found.
     */
    @Override 
    public void run() {
        for (long i = start; i < end; i++) {
            if (isPrime(i)) {
                this.count++;
                
                if (this.counter != null) {
                    this.counter.incrementCounter();
                }
            }
        }
        
        try {
            if (this.previous != null) {
                this.previous.join();
            }
        } catch (InterruptedException ignored) {
            
        } finally {
            System.out.println("Done [" + this.start + ", " + this.end + 
                    "] found:" + this.count);
        }
    }
}
