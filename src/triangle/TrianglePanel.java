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

package triangle;

import javax.swing.JPanel;
import java.awt.Point;
import java.awt.Graphics;

/**
 * TrianglePanel
 * 
 * @author giuliobosco
 * @version 28.09.2018
 */
public class TrianglePanel extends JPanel {
    
    /**
     * Triangle of the view.
     */
    private Triangle triangle;
    
    /**
     * Constructor without parameters.
     * Create the triangle on position (0,0).
     */
    public TrianglePanel() {
        int triangleSide = 50;
        this.triangle = new EquilateralTriangle(new Point(0,0), triangleSide);
    }
    
    public void centerTriangle() {
        int triangleX = (int)(this.getWidth() - this.triangle.getBase())/2;
        int triangleY = (int)(this.getHeight() - this.triangle.getHeight())/2;
        
        this.triangle.setPosition(new Point(triangleX, triangleY));
    }
    
    /**
     * Move the triangle on the X asses for the number of pixels passed as 
     * parameter.
     * 
     * @param move Number of pixel to move the triangle. 
     */
    public void moveX(int move) {
        this.triangle.getPosition().x += move;
        
        if (this.triangle.getPosition().x < 0) {
            this.triangle.getPosition().x = 0;
        } else if (
                this.triangle.getPosition().x >= 
                this.getWidth() - this.triangle.getBase()) {
            this.triangle.getPosition().x = (int)(
                    this.getWidth() - this.triangle.getBase());
        }
    }
    
    /**
     * Move the triangle on the Y asses for the number of pixels passed as
     * parameter.
     * 
     * @param move Number of pixel to move the triangle. 
     */
    public void moveY(int move) {
        this.triangle.getPosition().y += move;
        
        if (this.triangle.getPosition().y < 0) {
            this.triangle.getPosition().y = 0;
        } else if (
                this.triangle.getPosition().y >=
                this.getHeight()- this.triangle.getHeight()) {
            this.triangle.getPosition().y = (int)(
                    this.getHeight() - this.triangle.getHeight());
        }
    }
    
    /**
     * Paint the TrianglePanel.
     * 
     * @param g Graphics of the window.
     */
    @Override
    public void paint(Graphics g) {
        this.moveX(0);
        this.moveY(0);
        this.triangle.paint(g);
    }
}
