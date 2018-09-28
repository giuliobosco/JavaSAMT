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

/**
 *
 * @author giuliobosco
 */
public class EquilateralTriangle extends Triangle {
    
    /**
     * Setter for the height.
     * Calculate Base. Formula: hypotenuse = arccos(30°) * adjacent cateto. 
     * 
     * @param height Height of the triangle.
     */
    @Override
    public void setHeight(double height) {
        this.height = height;
        
        double angle = Math.PI / 180 * 30;
        
        this.base = Math.acos(angle) * this.height;
    }
    
    /**
     * Setter for the base.
     * Calculate the height of the triangle.
     * 
     * @param base Base of the triangle.
     */
    @Override
    public void setBase(double base) {
        this.base = base;
        
        this.height = Math.sqrt(
                Math.pow(this.base, 2) - Math.pow(this.base / 2, 2)
        );        
    }
}
