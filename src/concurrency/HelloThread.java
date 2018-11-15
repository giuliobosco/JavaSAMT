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
package concurrency;

/**
 * Concurrency exercise, using threads.
 *
 * @author giuliobosco
 * @version 15.11.2018
 */
public class HelloThread extends Thread {

    /**
     * Default thread name. Value: Thread.
     */
    private static final String DEFAULT_THREAD_NAME = "Thread";

    /**
     * Default sleep time. Value: 500.
     */
    private final int SLEEP_TIME = 500;

    /**
     * Name of the thread.
     */
    private String threadName;

    /**
     * Create the thread with his name.
     *
     * @param threadName Name of the thread.
     */
    public HelloThread(String threadName) {
        this.threadName = threadName;
    }

    /**
     * Create the thread with the default name.
     */
    public HelloThread() {
        this(DEFAULT_THREAD_NAME);
    }

    /**
     * Run the thread.
     */
    public void run() {
        while (true) {
            try {
                System.out.println("Thread: " + this.threadName + " is active");
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException ie) {
                System.out.println("Thread: " + this.threadName + " has been interrupted");
                break;
            }

        }
    }

    /**
     * Main method of the class.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                int threads = Integer.parseInt(args[0]);
                
                for (int i = 0; i < threads; i++) {
                    (new HelloThread(Integer.toString(i))).start();
                }
            } catch (NumberFormatException nfe) {
                (new HelloThread(args[0])).start();
            }
        } else if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                (new HelloThread(args[i])).start();
            }
        } else {
            (new HelloThread()).start();
        }
    }
}
