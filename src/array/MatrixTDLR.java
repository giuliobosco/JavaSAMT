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

import help.asker.Asker;
import help.asker.FormInterruptedException;
import help.validators.IntegerValidator;

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
        try {
            Asker asker = new Asker();
            IntegerValidator iv = new IntegerValidator(0, Integer.MAX_VALUE);

            int rows = Integer.parseInt(asker.ask("rows", iv));
            int cols = Integer.parseInt(asker.ask("cols", iv));

            int[][] matrix = new int[rows][cols];

            int counter = 0;

            for (int i = 0; i < cols; i++) {
                for (int l = 0; l < rows; l++) {
                    matrix[l][i] = counter;
                    counter++;
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int l = 0; l < matrix[i].length; l++) {
                    System.out.print(matrix[i][l] + "    ");
                    if (matrix[i][l] >= 0 && matrix[i][l] <= 9) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        } catch (IOException | FormInterruptedException ignored) {

        }
    }
}
