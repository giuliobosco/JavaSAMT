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
 * Create a checkerboard, with 0 and 1 (0 represent black and 1 white)
 *
 * @author giuliobosco
 * @version 1.0
 */
public class CheckerBoard {
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
        BufferedReader tastira = new BufferedReader(input);

        try {
            System.out.print("Inserire numero di righe: ");
            String righeString = tastira.readLine();
            int righe = Integer.parseInt(righeString);

            System.out.print("Inserire numero di colonne: ");
            String colonneString  = tastira.readLine();
            int colonne = Integer.parseInt(colonneString);

            int[][] matrice = new int[righe][colonne];

            for (int i = 0; i < righe; i++) {
                for (int l = 0; l < colonne; l++) {
                    int sum = (i + l) % 2;
                    matrice[i][l] = sum;

                    System.out.print(sum + " ");
                }
                System.out.println();
            }
        }
        catch (IOException ioe) {
            System.out.println("Errore!");
        }
    }
}
