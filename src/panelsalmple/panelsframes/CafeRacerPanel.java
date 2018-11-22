package panelsalmple.panelsframes;

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

import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
/**
 * CafeRacer Responsive Design
 * 
 * @author giuliobosco
 * @version 26.09.2018
 */
public class CafeRacerPanel extends JPanel{
    /**
     * Columns used for the design.
     */
    public final int GRID_COLUMS = 27;
    
    /**
     * Rows used for the design.
     */
    public final int GRID_ROWS = 18;
    
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
     * Constructor
     */
    public CafeRacerPanel() {
    }

    /**
     * Calculate margin, for respect the proportion.
     * Array contains 2 elements.
     * 1° Element: Lateral margin.
     * 2° Element: Vertical margin.
     * @return Array margins.
     */
    private int[] marginSize() {
        int squareWidth = (int) getWidth() / GRID_COLUMS;
        
        int idealHeight = squareWidth * GRID_ROWS;
        int idealWidth = getWidth();

        int actualHeight = getHeight();
                
        if (idealHeight > actualHeight) {
            squareWidth = (int) actualHeight / GRID_ROWS;
            idealWidth = squareWidth * GRID_COLUMS;
            
            this.squareSize = squareWidth;
            
            return new int[]{(getWidth() - idealWidth) / 2, 0};
        } else {
            this.squareSize = squareWidth;
            idealWidth = squareSize * GRID_COLUMS;
            
            return new int[]{(getWidth() - idealWidth) / 2, (actualHeight - idealHeight) / 2};
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
     * Paint a container for the design.
     * @param g Graphics of the window.
     */
    public void paintContainer(Graphics g) {
        g.setColor(Color.lightGray);
        g.fillRect(
                getLeft(0),
                getTop(0),
                getFigureSize(GRID_COLUMS), 
                getFigureSize(GRID_ROWS)
        );
    }
    
    /**
     * Paint the grass in the middle of the container.
     * @param g Graphics of the window.
     */
    public void paintGrass(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(
                getLeft(0),
                getTop(5),
                getFigureSize(GRID_COLUMS),
                getFigureSize(5)
        );
    }
    
    /**
     * Paint the sky in the top of the container.
     * @param g Graphics of the window.
     */
    public void paintSky(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(
                getLeft(0),
                getTop(0),
                getFigureSize(GRID_COLUMS),
                getFigureSize(5)
        );
    }
    
    /**
     * Paint the background of the image.
     * @param g Graphics of the window.
     */
    public void paintBg(Graphics g) {
        paintContainer(g);
        paintGrass(g);
        paintSky(g);
    }
    
    /**
     * Paint the sit of the bike.
     * @param g Graphics of the window.
     */
    public void paintBikeSeat(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(
                getLeft(5), 
                getTop(3), 
                getFigureSize(2), 
                getFigureSize(1)
        );
        g.fillRect(
                getLeft(5), 
                getTop(4), 
                getFigureSize(7), 
                getFigureSize(1)
        );
    }
    
    /**
     * Paint the top part of the bike.
     * @param g Graphics of the window.
     */
    public void paintBikeTop(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(
                getLeft(5), 
                getTop(5), 
                getFigureSize(15), 
                getFigureSize(1)
        );
        g.fillOval(
                getLeft(12),
                getTop(2),
                getFigureSize(9),
                getFigureSize(6)
        );
    }
    
    /**
     * Paint the bottom part of the bike.
     * @param g Graphics of the window.
     */
    public void paintBikeBottom(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(
                getLeft(12),
                getTop(6),
                getFigureSize(9),
                getFigureSize(2)
        );
        g.fillRect(
                getLeft(12),
                getTop(8),
                getFigureSize(3),
                getFigureSize(5)
        );
    }
    
    /**
     * Paint the back wheel of the bike. 
     * @param g Graphics of the window.
     */
    public void paintBikeBackWheel(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(
                getLeft(1),
                getTop(8),
                getFigureSize(9),
                getFigureSize(9)
        );
        g.setColor(Color.lightGray);
        g.fillOval(
                getLeft(3),
                getTop(10),
                getFigureSize(5),
                getFigureSize(5)
        );
        g.setColor(Color.yellow);
        g.fillRect(
                getLeft(5),
                getTop(12),
                getFigureSize(8),
                getFigureSize(1)
        );
    }
    
    /**
     * Paint the front wheel of the bike.
     * @param g Graphics of the window.
     */
    public void paintBikeFrontWheel(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(
                getLeft(16),
                getTop(8),
                getFigureSize(9),
                getFigureSize(9)
        );
        g.setColor(Color.lightGray);
        g.fillOval(
                getLeft(18),
                getTop(10),
                getFigureSize(5),
                getFigureSize(5)
        );
        g.setColor(Color.yellow);
        g.fillRect(
                getLeft(20),
                getTop(2),
                getFigureSize(1),
                getFigureSize(10)
        );
    }
    
    /**
     * Paint the HandleBar of the bike.
     * @param g Graphics of the bike.
     */
    public void paintBikeHandleBar(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(
                getLeft(19),
                getTop(1),
                getFigureSize(1),
                getFigureSize(1)
        );
    }
    
    /**
     * Paint the bike in center of the window.
     * @param g Graphics of the window.
     */
    public void paintBike(Graphics g) {
        paintBikeSeat(g);
        
        paintBikeTop(g);
        paintBikeBottom(g);
        
        paintBikeBackWheel(g);
        paintBikeFrontWheel(g);
        
        paintBikeHandleBar(g);
    }
    
    /**
     * Paint grid over the bike.
     * @param g Graphics of the window.
     */
    public void paintGrid(Graphics g) {
        g.setColor(Color.white);
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
        super.paint(g);
        margins = marginSize();
        clearBg(g);
        
        paintBg(g);
        paintBike(g);
        
        paintGrid(g);
    }
    
    
    
}
