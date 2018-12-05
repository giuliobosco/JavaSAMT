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
 * 
 * @author giuliobosco
 * @version 1.0
 */
public class PacNum {
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

        int x = Random.getInt(0, 10);
        int y = Random.getInt(0, 10);
        int vx = Random.getInt(0, x);
        int vy = Random.getInt(0, y);

        int[][] m = new int[x][y];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = 0;
            }
        }

        int n = Random.getInt(0,4);

        m[vx][vy] = n;

        step(m);

		/*
		int[][] m = {{0,1,0},{0,0,0},{0,0,0},{0,0,0},{0,0,0}};

		step(m);*/
    }

    public static void step(int[][] m) {
        int mH = m.length;
        int mW = m[0].length;
        boolean giusto = true;
        int count = 0;
        int n = 0;
        int x = -1;
        int y = -1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (m[i][j] == 1 || m[i][j] == 2 || m[i][j] == 3 || m[i][j] == 4) {
                    count++;
                    x = i;
                    y = j;
                    n = m[i][j];
                }
                else if (m[i][j] < 0 ||m[i][j] > 4) {
                    giusto = false;
                }
            }
        }
        if (count == 1 && giusto) {

            if (n == 1) {
                int newX = (x + mH - 1) % mH;
                m[newX][y] = n;
                m[x][y] = 0;
            }

            else if (n == 2) {
                int newX = (x + 1) % mH;
                m[newX][y] = n;
                m[x][y] = 0;
            }
            else if (n == 3) {
                int newY = (y + mW - 1) % mW;
                m[x][newY] = n;
                m[x][y] = 0;
            }
            else if (n == 4) {
                int newY = (y + 1) % mW;
                m[x][newY] = n;
                m[x][y] = 0;
            }

            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    System.out.print(m[i][j]);
                }
                System.out.println();
            }
        }
    }
}
