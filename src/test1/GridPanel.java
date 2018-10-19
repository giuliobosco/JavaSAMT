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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;

/**
 * Grid panel.
 * 
 * @author giuliobosco
 * @version 04.10.2018
 */
public class GridPanel extends JPanel implements MouseMotionListener {
    
    /**
     * Default margin of the grid.
     * Used also for margin increase or decrease.
     */
    public static final int DFL_MARGIN = 10;
    
    /**
     * Minimal columns in the grid.
     */
    public static final int MIN_COLS = 5;
    
    /**
     * Default columns in the grid.
     */
    public static final int DFL_COLS = 10;
    
    /**
     * Minimal rows in the grid.
     */
    public static final int MIN_ROWS = 5;
    
    /**
     * Default rows in the grid.
     */
    public static final int DFL_ROWS = 10;
    
    /**
     * Margin of the grid.
     */
    private int margin;
    
    /**
     * Columns of the grid.
     */
    private int cols;
    
    /**
     * Rows of the grid.
     */
    private int rows;
    
    /**
     * Size of the 
     */
    private int size;
    
    /**
     * Padding for center the grid.
     */
    private Dimension padding;
    
    /**
     * Over square.
     */
    private Point hover;
    
    /**
     * Setter for the margin of the grid.
     * 
     * @param margin Margin of the grid.
     */
    public void setMargin(int margin) {
        if (margin > 0) {
            this.margin = margin;
        } else {
            this.margin = 0;
        }
        
        this.repaint();
    }
    
    /**
     * Getter for the margin of the grid.
     * 
     * @return Margin of the grid.
     */
    public int getMargin() {
        return this.margin;
    }
    
    /**
     * Setter for the columns of the grid.
     * 
     * @param cols Columns of the grid.
     */
    public void setCols(int cols) {
        if (cols >= MIN_COLS) {
            this.cols = cols;
        } else {
            this.cols = MIN_COLS;
        }
        
        this.repaint();
    }
    
    /**
     * Getter for the columns of the grid.
     * 
     * @return Columns of the grid.
     */
    public int getCols() {
        return this.cols;
    }
    
    /**
     * Setter for the rows of the grid.
     * 
     * @param rows Rows of the grid.
     */
    public void setRows(int rows) {
        if (rows >= MIN_ROWS) {
            this.rows = rows;
        } else {
            this.rows = MIN_ROWS;
        }
        
        this.repaint();
    }
    
    /**
     * Getter for the rows of the grid.
     * 
     * @return Rows of the grid.
     */
    public int getRows() {
        return this.rows;
    }
    
    /**
     * Getter for the width of the panel without the margins.
     * 
     * @return Width of the panel without the margins.
     */
    public int getWidthMargin() {
        return this.getWidth() - 2 * this.margin;
    }
    
     /** 
      * Getter for the height of the panel without the margins.
      * 
      * @return Height of the panel without the margins.
      */
    public int getHeightMargin() {
        return this.getHeight() - 2 * this.margin;
    }
    
    /**
     * Create the panel with default rows, columns and margins.
     */
    public GridPanel() {
        this.rows = DFL_ROWS;
        this.cols = DFL_COLS;
        
        this.margin = DFL_MARGIN;
        
        this.hover = new Point(-1, -1);
        
        this.addMouseMotionListener(this);
    }
    
    /**
     * Calculate the coordinate for center the grid and the block size.
     */
    public void center() {
        int midHeight = this.getHeightMargin() / this.rows;
        int midWidth = this.getWidthMargin() / this.cols;
        
        this.size = (midHeight > midWidth)? midWidth : midHeight;
        
        this.padding = new Dimension(
                (int) ((getWidthMargin() - this.cols * this.size) / 2) + this.margin,
                (int) ((getHeightMargin() - this.rows * this.size) / 2) + this.margin
        );
    }
    
    /**
     * Get the blocks height in pixels.
     * 
     * @param blocks Blocks.
     * @return Pixels.
     */
    private int getBlocks(int blocks) {
        return this.size * blocks;
    }
    
    /**
     * Get position form top in pixels for blocks.
     * 
     * @param blocks Blocks.
     * @return Pixels.
     */
    private int getTop(int blocks) {
        return this.padding.height + this.getBlocks(blocks);
    }
    
    /**
     * Get position from left in pixels for blocks.
     * 
     * @param blocks Blocks.
     * @return Pixels.
     */
    private int getLeft(int blocks) {
        return this.padding.width + this.getBlocks(blocks);
    }
    
    /**
     * Paint the grid.
     * @param g Graphics of the window.
     */
    @Override
    public void paint(Graphics g) {
        this.center();
        
        g.setColor(Color.white);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(Color.black);
        for (int i = 0; i <= this.cols; i++) {
           g.drawLine(
                   this.getLeft(i), 
                   this.getTop(0), 
                   this.getLeft(i), 
                   this.getTop(this.rows));
        }
        for (int i = 0; i <= this.rows; i++) {
            g.drawLine(
                   this.getLeft(0), 
                   this.getTop(i), 
                   this.getLeft(this.cols), 
                   this.getTop(i));
        }
        
        if (this.hover.x >= 0 && this.hover.y >= 0) {
            g.fillRect(
                    this.getLeft(this.hover.x), 
                    this.getTop(this.hover.y), 
                    this.size, 
                    this.size);
        }
    }
    
    /**
     * Increase the rows of the grid.
     */
    public void increaseRows() {
        this.setRows(this.getRows() + 1);
    }
    
    /**
     * Decrease the rows in the grid.
     */
    public void decreaseRows() {
        this.setRows(this.getRows() - 1);
    }
    
    /**
     * Increase the columns in the grid.
     */
    public void increaseCols() {
        this.setCols(this.getCols() + 1);
    }
    
    /**
     * Decrease the columns in the grid.
     */
    public void decreaseCols() {
        this.setCols(this.getCols() - 1);
    }
    
    /**
     * Increase the margin.
     */
    public void increaseMarign() {
        this.setMargin(this.getMargin() + DFL_MARGIN);
    }
    
    /**
     * Decrease the margin.
     */
    public void decreaseMargin() {
        this.setMargin(this.getMargin() - DFL_MARGIN);
    }
    
    /**
     * Check if the the mouse event is in the grid. 
     * Write the column and the row, on which is the hover attribute.
     * 
     * @param e Mouse Event.
     * @return True if the event has been triggered in the grid.
     */
    public boolean contains(MouseEvent e) {
        if (e.getX() > this.getLeft(0) && e.getX() < this.getLeft(this.cols)) {
            this.hover.x = (int) ((e.getX() - this.getLeft(0)) / this.size);
        } else {
            this.hover.x = -1;
        }
        
        if (e.getY() > this.getTop(0) && e.getY() < this.getTop(this.rows)) {
            this.hover.y = (int) ((e.getY() - this.getTop(0)) / this.size);
        } else {
            this.hover.y = -1;
        }
        
        this.repaint();
        
        if (this.hover.x >= 0 && this.hover.y >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mouse dragged event.
     * 
     * @param e Mouse Event.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        this.contains(e);
    }

    /**
     * Mouse moved event.
     * 
     * @param e Mouse Event.
     */
    @Override
    public void mouseMoved(MouseEvent e) {        
        this.contains(e);
    }
}
