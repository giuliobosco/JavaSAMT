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
package mybutton;

import java.awt.*;

/**
 * Translate from IT point to cartesian point.
 *
 * @author giuliobosco
 * @version 09.09.2018
 */
public class PointTraslator {
    /**
     * X Position of the circle.
     */
    private int circleX;

    /**
     * Y Position of the circle.
     */
    private int circleY;

    /**
     * Width of the circle.
     */
    private int circleWidth;

    /**
     * Height of the circle.
     */
    private int circleHeight;

    /**
     * Contructor with all the parameters.
     * All the parameters must to be bigger than 0.
     * @param circleX X Position of the circle.
     * @param circleY Y Position of the circle.
     * @param circleWidth Width of the circle.
     * @param circleHeight Height of the circle.
     */
    public PointTraslator (int circleX, int circleY, int circleWidth, int circleHeight) {
        if (circleX >= 0 && circleY >= 0 && circleWidth >= 0 && circleHeight >= 0 ) {
            this.circleWidth = circleWidth;
            this.circleHeight = circleHeight;

            this.circleX = circleX;
            this.circleY = circleY;
        }
    }

    /**
     * Translate point from IT coordinates to cartesian coordinates.
     * @param x IT point coordinates.
     * @param size Size of the circle.
     * @return Cartesian point coordinates.
     */
    private int translate(int x,int position, int size) {
        return position + size - x;
    }

    /**
     * Point Translator from it coordinates to cartesian coordinates.
     * @param point Point to translate.
     * @return Translated point.
     */
    public Point translatePoint(Point point) {
        point.x = translate(this.circleX, this.circleWidth, point.x);
        point.y = translate(this.circleY, this.circleHeight, point.y);

        return point;
    }

    private static String autoTest() {
        String test = "";

        PointTraslator pt = new PointTraslator(100, 100, 50, 50);
        Point p;

        p = pt.translatePoint(new Point(25, 25));

        test += "Test 1:";
        test += " DATA:   X=25 Y=25";
        test += " RESULT: X=" + p.x + " Y=" + p.y;

        p = pt.translatePoint(new Point(75, 75));

        test += "Test 2:";
        test += " DATA:   X=75 Y=75";
        test += " RESULT: X=" + p.x + " Y=" + p.y;

        return test;
    }

    /**
     * Class TEST.
     * Default Circle data:
     * <ul>
     *     <li>circle start x: 100</li>
     *     <li>circle start y: 100</li>
     *     <li>circle width: 50</li>
     *     <li>circle height: 50</li>
     * </ul>
     * @param args Argument 0: x for test, argument 1: y for test.
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                int x = Integer.parseInt(args[0]);
                int y = Integer.parseInt(args[1]);

                PointTraslator pt = new PointTraslator(100,100 ,50,50);
                Point p;

                p = pt.translatePoint(new Point(x, y));

                System.out.println("Test 1:");
                System.out.println(" DATA:   X=25 Y=25");
                System.out.println(" RESULT: X=" + p.x + " Y=" + p.y);

            } catch (NumberFormatException nfe) {
                System.out.println("Wrong test data. Run AutoTest.\n");
                System.out.println(autoTest());
            }
        } else {
            System.out.println("Run AutoTest.\n");
            System.out.println(autoTest());
        }
    }
}
