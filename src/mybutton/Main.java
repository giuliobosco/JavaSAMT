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
import java.util.ArrayList;
import java.util.List;

/**
 * Main Application Class.
 * Create the frame (window) and test the working flow of the buttons.
 * Implements one button and an round button.
 * @author giuliobosco
 * @version 04.06.2018
 */
public class Main extends JFrame implements MyButtonListener {
    /**
     * Buttons of the window.
     */
    private List<MyButton> buttons;
    
    /**
     * Constructor with window title.
     * @param title Window Title.
     */
    public Main(String title) {
        super(title);

        // set window size
        this.setSize(280,302);
        // set close operation
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // initialize buttons list
        buttons = new ArrayList<>();

        // add buttons
        buttons.add(new MyButton(30,52,100,100,Color.red,"L1")); // button on left top
        buttons.add(new MyRoundButton(30,172,100,"L2")); // round button on left bottom
        buttons.add(new MyRoundButton(150, 52, 100,"R1")); // round button on right top
        buttons.add(new MyButton(150,172,100,100,"R2")); // round button on right bottom

        // execute for all buttons in the this.buttons list
        for (MyButton button : buttons) {
            // add to button the this window as button listener
            button.addMyButtonListener(this);

            // add the MouseListener and the MouseMotionListener to the button
            this.addMouseListener(button);
            this.addMouseMotionListener(button);
        }
    }

    /**
     * Button Clicked event.
     * @param source Event source.
     */
    @Override
    public void buttonClicked(MyButton source) {
        System.out.println("button: " + source.content + " clicked");
    }

    /**
     * Button Pressed event.
     * @param source Event source.
     */
    @Override
    public void buttonPressed(MyButton source) {
        System.out.println("button: " + source.content + " pressed");
    }

    /**
     * Button released.
     * @param source Event source.
     */
    @Override
    public void buttonReleased(MyButton source) {
        System.out.println("button: " + source.content + " released");
    }

    /**
     * Over button.
     * @param source Over source.
     */
    @Override
    public void buttonOver(MyButton source) {
        System.out.println("over button:" + source.content);
    }

    /**
     * Paint the windows view.
     * @param g Graphics of the window.
     */
    @Override
    public void paint(Graphics g) {
        for (MyButton button : buttons) {
            button.paint(g); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    /**
     * Application runner.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main("MyButtonAPP").setVisible(true);
            }
        });
    }
}
