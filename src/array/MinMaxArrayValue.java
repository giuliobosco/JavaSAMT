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
 * Find the minimum and the maximum value of the array.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class MinMaxArrayValue {
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
        int[][] matrice = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int l = 0; l < 10; l++) {
                matrice[i][l] = Random.getInt(0, 100);
                System.out.print(matrice[i][l] + "    ");
                if (matrice[i][l] < 10) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println("\n");

        int x = matrice[0][0];

        for (int i = 0; i < 10; i++) {
            for (int l = 0; l < 10; i++) {
                if (matrice[i][l] < x) {
                    x = matrice[i][l];
                }
            }
        }

        System.out.println("Valore min: " + x);

        x = matrice[0][0];
        for (int i = 0; i < 10; i++) {
            for (int l = 0; l < 10; l++) {
                if (matrice[i][l] > x) {
                    x = matrice[i][l];
                }
            }
        }

        System.out.println("Valore max: " + x);
    }
}
