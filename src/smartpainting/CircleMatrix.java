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
package smartpainting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.Panel;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

/**
 * Circle matrix. Fill the panel with circles.
 * 
 * @author giuliobosco
 * @version 07.11.2018
 */
public class CircleMatrix extends Panel implements MouseListener {

    /**
     * Size of the circles.
     */
    private int size = 30;

    /**
     * Old clicked point.
     */
    private Point old;

    /**
     * Constructor without parameters.
     * Add the mouse listener and initialize the old point.
     */
    public CircleMatrix() {
        this.addMouseListener(this);
        old = new Point(0, 0);
    }

    /**
     * Paint the panel.
     * 
     * @param g Graphics of the panel.
     */
    @Override
    public void paint(Graphics g) {
        long startTime = System.nanoTime();
        Rectangle clippingArea = g.getClipBounds();
        g.setColor(Color.blue);
        g.fillRect(clippingArea.x, clippingArea.y, clippingArea.width, clippingArea.height);
        if (clippingArea.getWidth() == size && clippingArea.getHeight() == size) {
            g.setColor(Color.RED);
            g.fillOval(clippingArea.x, clippingArea.y, size, size);
            g.setClip(old.x, old.y, size, size);
            g.setColor(Color.GREEN);
            g.fillOval(old.x, old.y, size, size);
            old = new Point(clippingArea.x, clippingArea.y);
        } else {
            System.out.println("first");

            for (int i = 0; i < this.getWidth() / 10; i++) {
                for (int j = 0; j < this.getHeight() / 10; j++) {
                    g.setColor(Color.green);

                    g.fillOval(size * i, size * j, size, size);
                }
            }
        }
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    /**
     * Get the row by x coordinate.
     * 
     * @param x X coordinate.
     * @return Row of the circles matrix.
     */
    public int getRow(int x) {
        return x / this.size;
    }

    /**
     * Get the column by the y coordinate.
     * 
     * @param y Y coordinate.
     * @return Column of the circles matrix.
     */
    public int getColumn(int y) {
        return y / this.size;
    }

    /**
     * Mouse clicked event (not used).
     * 
     * @param e Mouse Event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Mouse pressed event (not used).
     * 
     * @param e Mouse Event.
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Mouse released event.
     * 
     * @param e Mouse Event.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        int row = getRow(e.getY());
        int col = getColumn(e.getX());

        if (row != getRow(old.y) || col != getColumn(old.x)) {
            this.repaint(col * size, row * size, size, size);
        }
    }

    /**
     * Mouse entered event (not used).
     * 
     * @param e Mouse Event.
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Mouse exited event (not used).
     * 
     * @param e Mouse Event.
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
