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
 * Search algorithms.
 *
 * @author giuliobosco
 * @version 1.0.1
 */
public class Search {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Search the biggest number in the array, there are two it will return the first.
     *
     * @param array Array with the values.
     * @param number Value to search.
     * @return Index of the value, if not find returns -1.
     */
    public static int maxFirst(int[] array, int number) {
        int max = 1;

        for (int i = 0; i < array.length; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }

        return max - 1;
    }

    /**
     * Binary search algorithm, require an array with incremental order of the values.
     *
     * @param array Array with the values.
     * @param number Value to search.
     * @return Index of the value.
     */
    public static int binary(int[] array, int number) {

        int start = 0;
        int end = array.length - 1;
        int mid = (start + end) / 2;

        while (start <= end) {
            if (array[mid] == number) {
                return mid;
            } else if (array[mid] < number) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

            mid = (start + end) / 2;
        }

        return -1;
    }

}
