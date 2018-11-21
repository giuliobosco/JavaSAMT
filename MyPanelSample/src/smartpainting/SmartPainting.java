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

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.Frame;
import java.awt.event.WindowEvent;

/**
 * Smart painting frame.
 * 
 * @author giuliobosco
 * @version 07.11.2018
 */
public class SmartPainting extends Frame {
    
    /**
     * Circle matrix, with smart painting.
     */
    private CircleMatrix circleMatrix;
    
    /**
     * Constructor without parameters.
     * Initialize components.
     */
    public SmartPainting() {
        this.initComponents();
        
        this.setSize(300, 300);
    }
    
    /**
     * Initialize components.
     */
    private void initComponents() {
        
        this.circleMatrix = new CircleMatrix();
        
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        
        add(circleMatrix, BorderLayout.CENTER);
        
        pack();
    }
    
    /**
     * Main method of the class. 
     * Create an SmartPainting.
     * 
     * @param args Command line arguments.
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SmartPainting().setVisible(true);
            }
        });
    }
}
