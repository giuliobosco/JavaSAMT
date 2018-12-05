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

import java.awt.*;
import java.io.IOException;

/**
 * Print matrix with number of the cell, from left to right, from top to bottom.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class MatrixLRTD {
    // -------------------------------------------------------------------------------------------------------- Costants
    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * Size of the matrix to print.
     */
    private Dimension matrixSize;

    /**
     * Maximum spaces to print.
     */
    private int spaces;

    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Empty constructor.
     */
    public MatrixLRTD() {}

    // ---------------------------------------------------------------------------------------------------- Help Methods

    /**
     * Quest the size of the matrix.
     *
     * @throws FormInterruptedException Form interrupted.
     * @throws IOException Input/Output error.
     */
    private void quest() throws FormInterruptedException, IOException {
        Asker asker = new Asker();
        IntegerValidator iv = new IntegerValidator(0, Integer.MAX_VALUE);
        String rows = asker.ask("Rows", iv);
        String cols = asker.ask("Cols", iv);
        try {
            this.matrixSize = new Dimension(Integer.parseInt(rows), Integer.parseInt(cols));
        } catch (NumberFormatException nfe) {
            throw new FormInterruptedException("NaN");
        }
    }

    /**
     * Calculate the maximum spaces.
     */
    private void calculateSpaces() {
        int space = this.matrixSize.width * this.matrixSize.height - 1;

        int counter = 1;
        while (space > 10) {
            space /= 10;
            counter++;
        }

        this.spaces = counter;
    }

    /**
     * Print an number with spaces.
     *
     * @param number Number to print.
     */
    private void printNumber(int number) {

        int length = 0, n = number;

        while (n >= 10) {
            n /= 10;
            length++;
        }

        for (int i = 0; i < this.spaces - length; i++) {
            System.out.print(" ");
        }

        System.out.print(number);
    }

    /**
     * Print the matrix.
     */
    private void printMatrix() {
        int counter = 0;

        for (int i = 0; i < this.matrixSize.height; i++) {
            for (int j = 0; j < this.matrixSize.width; j++) {
                this.printNumber(counter);
                counter++;
            }

            System.out.println();
        }
    }


    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Run the Matrix printer, from left to right, from top to bottom.
     */
    public void run() {
        try {
            this.quest();
            this.calculateSpaces();
            this.printMatrix();
        } catch (FormInterruptedException | IOException fie) {

        }
    }


    // ----------------------------------------------------------------------------------------------- Static Components

    /**
     * Main method of the MatrixPrinter.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        new MatrixLRTD().run();
    }
}
