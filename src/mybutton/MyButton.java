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

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * MyButton.
 * @author giuliobosco
 * @version 28.05.2018
 */
public class MyButton implements MouseListener{

    /**
     * Y Position of the button in the view.
     */
    private int y;
    
    /**
     * X Position of the button in the view.
     */
    private int x;
    
    /**
     * Width of the button.
     */
    private int w = 100;
    /**
     * Height of the button.
     */
    private int h = 80;
    
    /**
     * Button Color.
     */
    private Color color = Color.blue;
    
    /**
     * Label of the button
     */
    private String content = "UNNAME";
    
    /**
     * Button listeners.
     */
    private List<MyButtonListener> listeners;
    
    /**
     * Constructor with y position, x position, width, height, color, label content.
     * @param y Y position of the button in the view.
     * @param x X position of the button in the view.
     * @param w width of the button.
     * @param h height of the button.
     * @param color color of the button.
     * @param content content of the button.
     */
    public MyButton(int y, int x, int w, int h, Color color, String content) {
        this.y = y;
        this.x = x;
        this.w = w;
        this.h = h;
        this.color = color;
        this.content = content;
        listeners = new ArrayList<>();
    }
    
    /**
     * Add listener to listeners.
     * @param listener Listener to add.
     */
    public void addMyButtonListener(MyButtonListener listener) {
        listeners.add(listener);
    }

    /**
     * Check if the Mouse event as been triggered in the button area.
     * @param e Mouse Event.
     * @return True if the Mouse Event as been triggered in the button area.
     */
    private boolean isMouseEventIn(MouseEvent e) {
        if (e.getX() >= this.x && e.getX() <= this.x + this.w && e.getY() >= this.y && e.getY() <= this.y + this.h) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Mouse Clicked Event.
     * @param e Mouse Event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.isMouseEventIn(e)) {
            for (MyButtonListener listener : listeners) {
                listener.buttonClicked(this);
            }
        }
    }

    /**
     * Mouse Pressed Event.
     * @param e Mouse Event.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (this.isMouseEventIn(e)) {
            for (MyButtonListener listener : listeners) {
                listener.buttonPressed(this);
            }
        }
    }

    /**
     * Mouse Released Event.
     * @param e Mouse Event.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (this.isMouseEventIn(e)) {
            for (MyButtonListener listener : listeners) {
                listener.buttonReleased(this);
            }
        }
    }

    /**
     * Mouse Entered Event (not implemented).
     * @param e Mouse Event.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        if (this.isMouseEventIn(e)) {
            for (MyButtonListener listener : listeners) {
                listener.buttonOver(this);
            }
        }
    }

    /**
     * Mouse Exited Event (not implemented).
     * @param e Mouse Event.
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
    
    /**
     * Paint graphics of the button.
     * @param g Graphics of the window.
     */
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, w, h);

        g.setFont(new Font("TimesRoman", Font.PLAIN, 13));
        g.setColor(Color.black);
        g.drawString(this.content, this.x, this.y + 13);
    }
}
