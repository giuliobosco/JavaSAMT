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

package panelsalmple.manualayoutsample;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Create a BorderLayout with 5 buttons manually.
 * 
 * @author giuliobosco
 * @version 11.10.2018
 */
public class ManualBorderLayout extends JFrame {
    /**
     * Button on the top of the App.
     */
    private JButton northButton;
    
    /**
     * Button on the right of the App.
     */
    private JButton eastButton;
    
    /**
     * Button on the bottom of the App.
     */
    private JButton southButton;
    
    /**
     * Button on the left of the App.
     */
    private JButton westButton;
    
    /**
     * Button on the center of the App.
     */
    private JButton centerButton;
    
    /**
     * Constructor without parameters, set the 5 buttons and the layout.
     */
    public ManualBorderLayout() {
        super();
        
        // JFrame configuations
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        
        // Set Frame Layout.
        this.getContentPane().setLayout(new BorderLayout());
        
        // create and add the Top Button
        this.northButton = new JButton("N");
        this.getContentPane().add(northButton, BorderLayout.NORTH);
        
        // create and add the Right Button
        this.eastButton = new JButton("E");
        this.getContentPane().add(eastButton, BorderLayout.EAST);
        
        // create and add the Bottom Button
        this.southButton = new JButton("S");
        this.getContentPane().add(southButton, BorderLayout.SOUTH);
        
        // create and add the West Button
        this.westButton = new JButton("W");
        this.getContentPane().add(westButton, BorderLayout.WEST);
        
        // create and add the Center Button
        this.centerButton = new JButton("C");
        this.getContentPane().add(centerButton, BorderLayout.CENTER);
        
        // recalcule size of the app.
        pack();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManualBorderLayout().setVisible(true);
            }
        });
    }
}
