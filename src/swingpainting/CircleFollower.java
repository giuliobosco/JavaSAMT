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
 *
 * @author giuliobosco
 */
public class CircleFollower extends JPanel implements MouseMotionListener {
    
    public final static int DEFAULT_CIRCLE_SIZE = 30;
    
    public final static Point DEFAULT_SELECTED_CELL = new Point(-1,-1);
    
    private int circleSize;
    
    private Point selectedCell;
    
    public void setCell(MouseEvent e) {
        this.selectedCell = new Point(getCell(e.getX()), getCell(e.getY()));
    }
    
    public int getCell(int pixels) {
        return pixels / this.circleSize;
    }
    
    public int getPixels(int cell) {
        return cell * this.circleSize;
    }
    
    public CircleFollower() {
        this.addMouseMotionListener(this);
        this.circleSize = DEFAULT_CIRCLE_SIZE;
        this.selectedCell = DEFAULT_SELECTED_CELL;
    }
    
    private void fillOval(Graphics g, int row, int col) {
        this.fillOval(g, new Point(row, col));
    }
    
    private void fillOval(Graphics g, Point cell) {
        g.fillOval(getPixels(cell.x), 
                getPixels(cell.y), 
                this.circleSize, 
                this.circleSize);
    }
    
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

    @Override
    public void mouseDragged(MouseEvent e) {
        this.mouseMoved(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.setCell(e);
        
        this.repaint();
    }

}
