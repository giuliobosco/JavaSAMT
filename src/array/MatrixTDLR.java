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

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Print the matrix with the number of the cell, the number of the cell is from to down and from left to right.
 * 
 * @author giuliobosco
 * @version 1.0
 */
public class MatrixTDLR {
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
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader tastiera = new BufferedReader(input);

        try {
            System.out.print("Inserire numero di righe: ");
            String righeString = tastiera.readLine();
            int righe = Integer.parseInt(righeString);

            System.out.print("Inserire numero di colonne: ");
            String colonneString = tastiera.readLine();
            int colonne = Integer.parseInt(colonneString);

            int[][] matrice = new int[righe][colonne];

            int counter = 0;

            for (int i = 0; i < colonne; i++) {
                for (int l = 0; l < righe; l++) {
                    matrice[l][i] = counter;
                    counter++;
                }
            }

            for (int i = 0; i < righe; i++) {
                for (int l = 0; l < colonne; l++) {
                    System.out.print(matrice[i][l] + "    ");
                    if (matrice[i][l] >= 0 && matrice[i][l] <= 9) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } catch (IOException ioe) {

        }
    }
}
