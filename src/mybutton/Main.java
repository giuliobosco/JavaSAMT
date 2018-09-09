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
package mybutton;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Main Application Class.
 * Create the frame (window) and add the button.
 *
 * @author giuliobosco
 * @version 04.06.2018
 */
public class Main extends JFrame implements MouseListener, MouseMotionListener, MyButtonListener {
    
    /**
     * Button of the window.
     */
    private MyButton button;
    
    /**
     * Constructor with window title.
     * @param title Window Title.
     */
    public Main(String title) {
        super(title);
        
        this.setSize(300,200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        button = new MyButton(20,20,100,80,Color.red,"MyButton");
        button.addMyButtonListener(this);
    }

    /**
     * Mouse Clicked event.
     * @param e Mouse Event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        button.mouseClicked(e);
    }

    /**
     * Mouse Pressed event.
     * @param e Mouse Event.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        button.mousePressed(e);
    }

    /**
     * Mouse Released event.
     * @param e Mouse Event.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        button.mouseReleased(e);
    }

    /**
     * Mouse Entered event (not implemented).
     * @param e Mouse Event
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    /**
     * Mouse exited event (not implemented).
     * @param e Mouse Event.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    /**
     * Mouse dragged event.
     * @param e Mouse Event.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        button.mouseEntered(e);
    }

    /**
     * Mouse moved event.
     * @param e Mouse Event.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        button.mouseEntered(e);
    }

    /**
     * Button Clicked event.
     * @param source Event source.
     */
    @Override
    public void buttonClicked(MyButton source) {
        System.out.println("button clicked");
    }

    /**
     * Button Pressed event.
     * @param source Event source.
     */
    @Override
    public void buttonPressed(MyButton source) {
        System.out.println("button pressed");
    }

    /**
     * Button released.
     * @param source Event source.
     */
    @Override
    public void buttonReleased(MyButton source) {
        System.out.println("button released");
    }

    /**
     * Over button.
     * @param source Over source.
     */
    @Override
    public void buttonOver(MyButton source) {
        System.out.println("button over");
    }

    /**
     * Paint the windows view.
     * @param g Graphics of the window.
     */
    @Override
    public void paint(Graphics g) {
        button.paint(g); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Application runner.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main("Demo").setVisible(true);
            }
        });
    }
}
