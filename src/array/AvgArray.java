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
package array;

import help.Random;

/**
 * Calculate the avg of the array, create array with random values.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class AvgArray {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes
    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors
    // ---------------------------------------------------------------------------------------------------- Help Methods
    // ------------------------------------------------------------------------------------------------- General Methods
    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Main method of the class.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        // creo array val
        double[] val = new double[50];

        // assegno a tutto l'array val i valori
        for (int i = 0; i < 50; i++) {
            val[i] = Random.getInt(-10, 10);
        }

        // stampo tutti i valori conuti nell'array
        System.out.println("Valori:");
        for (int i = 0; i < 50; i++) {
            System.out.println(val[i]);

        }

        // creo la variabile della media
        double media = 0;

        // aggiungo tutti i valori alla variabile della media
        for (int i = 0; i< 50; i++) {
            media += val[i];
        }

        // divido la somma per il numero di  numeri
        media /= 50;

        // stampo la media
        System.out.println("Media: " + media);
    }
}
