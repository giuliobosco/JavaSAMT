package panelsframes;

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
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Exercise begin use graphical interface Design.
 * Design a flower.
 * @author Giulio Bosco
 * @version 23.04.2018
 */
public class FlowerPowerPanel extends JPanel {

    /**
     * Columns used for the design.
     */
    public final int GRID_COLUMS = 3;
    
    /**
     * Rows used for the design.
     */
    public final int GRID_ROWS = 9;
    
    /**
     * Array margins.
     * Array contains 2 elements.
     * 1° Element: Lateral margin.
     * 2° Element: Vertical margin.
     */
    private int[] margins;
    
    /**
     * Height and Width of the square.
     */
    private int squareSize;
    
    /**
     * Empty Constructor.
     */
    public FlowerPowerPanel() {
        
    }
    
    /**
     * Calculate margin, for respect the proportion.
     * Array contains 2 elements.
     * 1° Element: Lateral margin.
     * 2° Element: Vertical margin.
     */
    private void marginSize() {
        int squareWidth = (int) getWidth() / GRID_COLUMS;
        
        int idealHeight = squareWidth * GRID_ROWS;
        int idealWidth = getWidth();

        int actualHeight = getHeight();
                
        if (idealHeight > actualHeight) {
            squareWidth = (int) actualHeight / GRID_ROWS;
            idealWidth = squareWidth * GRID_COLUMS;
            
            this.squareSize = squareWidth;
            
            margins = new int[]{(getWidth() - idealWidth) / 2, 0};
        } else {
            this.squareSize = squareWidth;
            idealWidth = squareSize * GRID_COLUMS;
            
            margins = new int[]{(getWidth() - idealWidth) / 2, (actualHeight - idealHeight) / 2};
        }
    }
    
    /**
     * Calculate the size of a figure (in pixel).
     * @param blocks Number of blocks.
     * @return Size  of the figure.
     */
    private int getFigureSize(int blocks) {
        return squareSize * blocks;
    }
    
    /**
     * Calculate the pixel coordinate Y, where begin to design the figure.
     * @param blocks Number of blocks.
     * @return coordinate Y.
     */
    private int getTop(int blocks) {
        return margins[1] + getFigureSize(blocks);
    }
    
    /**
     * Calculate the pixel coordinate X, where begin to design the figure.
     * @param blocks Number of blocks.
     * @return  Coordinate X.
     */
    private int getLeft(int blocks) {
        return margins[0] + getFigureSize(blocks);
    }
    
    /**
     * Clear background of the window.
     * @param g Graphics of the window.
     */
    public void clearBg(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,getWidth(),getHeight());
    }
    
    /**
     * Paint the sky of the design.
     * @param g Graphics of the window.
     */
    public void paintSky(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(
                getLeft(0),
                getTop(0),
                getFigureSize(GRID_COLUMS), 
                getFigureSize(GRID_ROWS)
        );
    }
    
    /**
     * Paint the bottom grass where to plant the flower.
     * @param g Graphics of the window.
     */
    public void paintGrass(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(
                getLeft(0), 
                getTop(8), 
                getFigureSize(GRID_COLUMS), 
                getFigureSize(1)
        );
    }
    
    /**
     * Paint the background of the design.
     * @param g Graphics of the window.
     */
    public void paintBg(Graphics g) {
        paintSky(g);
        paintGrass(g);
    }
    
    /**
     * Paint the gambo of the flower.
     * @param g Graphics of the window.
     */
    public void paintFlowerGambo(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(
                getLeft(1), 
                getTop(3), 
                getFigureSize(1), 
                getFigureSize(6)
        );
    }
    
    /**
     * Paint the leaf of the flower.
     * Left & Right Leafs
     * @param g Graphics of the window.
     */
    public void paintFlowerLeaf(Graphics g) {
        g.setColor(Color.green);
        // left leaf
        g.fillOval(
                getLeft(0),
                getTop(4),
                getFigureSize(1),
                getFigureSize(2)
        );
        // right leaf
        g.fillOval(
                getLeft(2),
                getTop(5),
                getFigureSize(1),
                getFigureSize(2)
        );
    }
    
    /**
     * Paint the main part of the flower.
     * @param g Graphics of the window.
     */
    public void paintFlowerMain(Graphics g) {
        // print the yellow main part.
        g.setColor(Color.yellow);
        g.fillOval(
                getLeft(0),
                getTop(1),
                getFigureSize(3),
                getFigureSize(3)
        );
        
        // print the four orange ovals.
        g.setColor(Color.orange);
        g.fillOval(
                getLeft(1),
                getTop(1),
                getFigureSize(1),
                getFigureSize(1)
        );
        g.fillOval(
                getLeft(2),
                getTop(2),
                getFigureSize(1),
                getFigureSize(1)
        );
        g.fillOval(
                getLeft(1),
                getTop(3),
                getFigureSize(1),
                getFigureSize(1)
        );
        g.fillOval(
                getLeft(0),
                getTop(2),
                getFigureSize(1),
                getFigureSize(1)
        );
        
        // paint the center oval
        g.setColor(Color.white);
        g.fillOval(
                getLeft(1),
                getTop(2),
                getFigureSize(1),
                getFigureSize(1)
        );
    }
    
    /**
     * Paint the flower.
     * @param g Graphics of the window.
     */
    public void paintFlower(Graphics g) {
        paintFlowerGambo(g);
        paintFlowerLeaf(g);
        paintFlowerMain(g);
    }
    
    /**
     * Paint grid over the bike.
     * @param g Graphics of the window.
     */
    public void paintGrid(Graphics g) {
        g.setColor(Color.lightGray);
        for (int i = 0; i <= GRID_COLUMS; i++) {
            g.drawLine(
                    getLeft(i),
                    getTop(0),
                    getLeft(i),
                    getTop(GRID_ROWS)
            );
        }
        for (int i = 0; i <= GRID_ROWS; i++) {
            g.drawLine(
                    getLeft(0),
                    getTop(i),
                    getLeft(GRID_COLUMS),
                    getTop(i)
            );
        }
    }
    
    @Override
    public void paint(Graphics g) {
        marginSize();
        clearBg(g);
        
        paintBg(g);
        
        paintFlower(g);
        
        paintGrid(g);
    }
}
