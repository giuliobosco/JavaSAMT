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
package algorithms;
/**
 * Sort values in array.
 *
 * @author giuliobosco
 * @version 1.0.2
 */
public class Sort {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Sort an array, with bubble algorithm.
     *
     * @param array Array to sort.
     * @return Sorted array.
     */
    public static int[] bubble(int[] array) {
        boolean reload = true;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] > array[j + 1]) {
                    int n = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = n;
                    reload = false;
                }

                if (reload) {
                    i = array.length;
                }
            }
        }

        return array;
    }

    /**
     * Sort an array, with selection algorithm.
     *
     * @param array Array to sort.
     * @return Sorted array.
     */
    public static int[] selection(int[] array) {
        int n, small;

        for (int i = 0; i < array.length; i++) {
            small = i;
            for (int j = i; j < array.length - 1; j++) {
                if (array[small] > array[j + 1]) {
                    small = j + 1;
                }
            }

            n = array[small];
            array[small] = array[i];
            array[small] = n;
        }

        return array;
    }
}
