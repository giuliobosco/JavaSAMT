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
package panelsalmple.smartpainting;

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
    private Point lastClick;

    /**
     * Constructor without parameters.
     * Add the mouse listener and initialize the old point.
     */
    public CircleMatrix() {
        this.addMouseListener(this);
        lastClick = new Point(0, 0);
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
        g.fillRect(clippingArea.x, 
                clippingArea.y, 
                clippingArea.width, 
                clippingArea.height);
        
        if (clippingArea.getWidth() == size && clippingArea.getHeight() == size) {
            g.setColor(Color.red);
            g.fillOval(clippingArea.x, clippingArea.y, size, size);
            
            g.setClip(lastClick.x, lastClick.y, size, size);
            
            g.setColor(Color.green);
            g.fillOval(lastClick.x, lastClick.y, size, size);
            
            this.lastClick = new Point(clippingArea.getLocation());
        } else {
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
     * Get the row by y coordinate.
     * 
     * @param point Coordinates point.
     * @return Row of the circles matrix.
     */
    public int getRow(Point point) {
        return this.getCell(point.y);
    }

    /**
     * Get the column by the x coordinate.
     * 
     * @param point Coordinates point.
     * @return Column of the circles matrix.
     */
    public int getCol(Point point) {
        return this.getCell(point.x);
    }
    
    /**
     * Get the cell from the pixels.
     * 
     * @param pixels Size in pixels.
     * @return Number of the row or column.
     */
    public int getCell(int pixels) {
        return pixels / this.size;
    }
    
    /**
     * Get the pixels from the cell.
     * 
     * @param cell Cell.
     * @return Pixels.
     */
    public int getPixels(int cell) {
        return cell * this.size;
    }

    /**
     * Mouse clicked event.
     * 
     * @param e Mouse Event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int row = getRow(e.getPoint());
        int col = getCol(e.getPoint());

        if (row != getRow(lastClick) || col != getCol(lastClick)) {
            this.repaint(col * size, row * size, size, size);
        }
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
     * Mouse released event (not used).
     * 
     * @param e Mouse Event.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        
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
