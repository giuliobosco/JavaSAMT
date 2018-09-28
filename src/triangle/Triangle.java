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

import java.awt.Point;

/**
 * Class for rappresent a triangle.
 * 
 * @author giuliobosco
 */
public class Triangle {
    
    /**
     * Side of the triangle.
     */
    protected double base;
    
    /**
     * Height of the triangle.
     */
    protected double height;
    
    /**
     * Coordinates of the triangle.
     * Top left point.
     */
    protected Point position;
    
    /**
     * Setter for the side of the triangle.
     * 
     * @param base Side of the triangle.
     */
    public void setBase(double base) {
        this.base = base;
    }
    
    /**
     * Getter for the side of the triangle.
     * 
     * @return Side of the triangle.
     */
    public double getBase() {
        return this.base;
    }
    
    /**
     * Setter for the height of the triangle.
     * 
     * @param height Height of the triangle.
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    /**
     * Getter for the height of the triangle.
     * 
     * @return Height of the triangle.
     */
    public double getHeight() {
        return this.height;
    }
    
    /**
     * Setter for the coordinates of the triangle.
     * 
     * @param position Coordinates of the triangle.
     */
    public void setPoint(Point position) {
        this.position = position;
    }
    
    /**
     * Getter for the coordinates of the triangle.
     * 
     * @return Coordinates of the triangle. 
     */
    public Point getPoint() {
        return this.position;
    }
    
    /**
     * Setter for the X coordinate of the triangle.
     * 
     * @param x X coordinate of the triangle.
     */
    public void setX(int x) {
        this.position.x = x;
    }
    
    /**
     * Setter for the Y coordinate of the triangle.
     * 
     * @param y Y coordinate of the triangle.
     */
    public void setY(int y) {
        this.position.y = y;
    }
    
    /**
     * Empty constructor.
     */
    public Triangle() {
        
    }
    
    /**
     * Constructor with position.
     * 
     * @param position Coordinates of the triangle
     */
    public Triangle(Point position) {
        this.setPoint(position);
    }
    
    /**
     * Constructor with position, base and height of the triangle.
     * 
     * @param position Coordinates of the triangle.
     * @param base Base of the triangle.
     * @param height Height of the triangle.
     */
    public Triangle(Point position, double base, double height) {
        this.setPoint(position);
        this.setBase(base);
        this.setHeight(height);
    }
    
    /**
     * Getter for the area of the triangle.
     * 
     * @return Area of the triangle. 
     */
    public double getArea() {
        double area = this.base * this.height / 2;
        
        return area>=0?area:area*-1;
    }
    
    /**
     * Getter for the perimeter of the triangle.
     * 
     * @return Perimeter of the triangle.
     */
    public double getPerimeter() {
        double side = Math.sqrt(
                Math.pow(this.height, 2) + Math.pow(this.base / 2, 2)
        );
        double perimeter = this.base + side * 2;
        
        return perimeter>=0?perimeter:perimeter*-1;
    }
}
