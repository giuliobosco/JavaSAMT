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

package swingpainting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 * Circle Follower. Fill the panel with circles.
 * 
 * @author giuliobosco
 * @version 08.11.2018
 */
public class CircleFollower extends JPanel implements MouseMotionListener {
    
    /**
     * Default circle size.
     * Value: 30.
     */
    public final static int DEFAULT_CIRCLE_SIZE = 30;
    
    /**
     * Default selected cell.
     * Value: -1,-1.
     */
    public final static Point DEFAULT_SELECTED_CELL = new Point(-1,-1);
    
    /**
     * Circle size.
     */
    private int circleSize;
    
    /**
     * Selected cell.
     */
    private Point selectedCell;
    
    /**
     * Get the set the cell by Mouse Event.
     * 
     * @param e Mouse event.
     */
    public void setCell(MouseEvent e) {
        this.selectedCell = new Point(getCell(e.getX()), getCell(e.getY()));
    }
    
    /**
     * Get the cell from the pixels.
     * 
     * @param pixels Pixels.
     * @return Cell
     */
    public int getCell(int pixels) {
        return pixels / this.circleSize;
    }
    
    /**
     * Get the pixel from the cell.
     * 
     * @param cell Cell.
     * @return Pixels.
     */
    public int getPixels(int cell) {
        return cell * this.circleSize;
    }
    
    /**
     * Constructor without parameters.
     * Add mouse listener, set default circle size and set default selected cell.
     */
    public CircleFollower() {
        this.addMouseMotionListener(this);
        this.circleSize = DEFAULT_CIRCLE_SIZE;
        this.selectedCell = DEFAULT_SELECTED_CELL;
    }
    
    /**
     * Fill oval from row and col.
     * 
     * @param g Graphics of the panel.
     * @param row Row of the oval.
     * @param col Col of the oval.
     */
    private void fillOval(Graphics g, int row, int col) {
        this.fillOval(g, new Point(row, col));
    }
    
    /**
     * Fill oval from the coordinates of the cell.
     * 
     * @param g Graphics of the panel.
     * @param cell Coordinates of the oval.
     */
    private void fillOval(Graphics g, Point cell) {
        g.fillOval(getPixels(cell.x), 
                getPixels(cell.y), 
                this.circleSize, 
                this.circleSize);
    }
    
    /**
     * Paint the panel, the circles matrix and the selected matrix.
     * 
     * @param g Graphics of the window.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(Color.black);
        for (int i = 0; i <= this.getCell(this.getWidth()); i++) {
            for (int  j = 0; j <= this.getCell(this.getHeight()); j++) {
                this.fillOval(g, i, j);
            }
        }
        
        g.setColor(Color.red);
        this.fillOval(g, selectedCell);
    }

    /**
     * Mouse dragged event.
     * Call mouse moved event.
     * 
     * @param e Mouse Event.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        this.mouseMoved(e);
    }

    /**
     * Mouse dragged event.
     * 
     * @param e Mouse Event.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        this.setCell(e);
        
        this.repaint();
    }

}
