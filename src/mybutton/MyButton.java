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
import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * MyButton.
 *
 * @author giuliobosco
 * @version 28.05.2018
 */
public class MyButton implements MouseListener, MouseMotionListener {
    /**
     * Default button start point.
     * Value: 0, 0.
     */
    public static final Point DEFAULT_START = new Point(0, 0);

    /**
     * Default button size.
     * Value: 08, 30.
     */
    public static final Dimension DEFAULT_SIZE = new Dimension(80, 30);

    /**
     * Default button background color.
     * Value: (Color) Blue.
     */
    public static final Color DEFAULT_BG_COLOR = Color.blue;

    /**
     * Default button foreground color.
     * Value: (Color) White.
     */
    public static final Color DEFAULT_FG_COLOR = Color.white;

    /**
     * Default button margin color.
     * Value: (Color) Black.
     */
    public static final Color DEFAULT_MG_COLOR = Color.black;

    /**
     * Default content font size.
     * Value: 13.
     */
    public static final int DEFAULT_FONT_SIZE = 13;

    /**
     * Default margin size.
     * Value: 2.
     */
    public static final int DEFAULT_MG_SIZE = 2;

    /**
     * Default button content.
     * Value: "MyButton".
     */
    public static final String DEFAULT_CONTENT = "MyButton";

    /**
     * Button start point.
     */
    protected Point start;

    /**
     * Button size.
     */
    protected Dimension size;

    /**
     * Button background Color.
     */
    protected Color bgColor;

    /**
     * Button Foreground Color.
     */
    protected Color fgColor;

    /**
     * Button Margin Color.
     */
    protected Color mgColor;

    /**
     * Button content font-size.
     */
    protected int fontSize;

    /**
     * Button margin size.
     */
    protected int mgSize;

    /**
     * Label of the button
     */
    protected String content;

    /**
     * Button listeners.
     */
    protected List<MyButtonListener> listeners;

    /**
     * Constructor with all default parameters.
     */
    public MyButton() {
        this(DEFAULT_START, DEFAULT_SIZE);
    }

    /**
     * Constructor with x position, y position.
     *
     * @param x X position of the button in the view.
     * @param y Y position of the button in the view.
     */
    public MyButton(int x, int y) {
        this(x, y, DEFAULT_SIZE.width, DEFAULT_SIZE.height);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param start    Start point of the button.
     */
    public MyButton(Point start) {
        this(start, DEFAULT_SIZE);
    }

    public MyButton(Point start, int w, int h) {
        this(start, new Dimension(w, h));
    }

    /**
     * Constructor with y position, x position, width, height.
     *
     * @param x X position of the button in the view.
     * @param y Y position of the button in the view.
     * @param w Width of the button.
     * @param h Height of the button.
     */
    public MyButton(int x, int y, int w, int h) {
        this(x, y, w, h, DEFAULT_CONTENT);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param start    Start point of the button.
     * @param size     Size of the button.
     */
    public MyButton(Point start, Dimension size) {
        this(start, size, DEFAULT_CONTENT);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y       Y position of the button in the view.
     * @param x       X position of the button in the view.
     * @param w       Width of the button.
     * @param h       Height of the button.
     * @param content Content of the button.
     */
    public MyButton(int x, int y, int w, int h, String content) {
        this(x, y, w, h, DEFAULT_BG_COLOR, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param start    Start point of the button.
     * @param size     Size of the button.
     * @param content  Content of the button.
     */
    public MyButton(Point start, Dimension size, String content) {
        this(start, size, DEFAULT_BG_COLOR, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y       Y position of the button in the view.
     * @param x       X position of the button in the view.
     * @param w       Width of the button.
     * @param h       Height of the button.
     * @param bgColor Background color of the button.
     * @param content Content of the button.
     */
    public MyButton(int x, int y, int w, int h, Color bgColor, String content) {
        this(x, y, w, h, bgColor, DEFAULT_FG_COLOR, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param start    Start point of the button.
     * @param size     Size of the button
     * @param bgColor  Background color of the button.
     * @param content  Content of the button.
     */
    public MyButton(Point start, Dimension size, Color bgColor, String content) {
        this(start, size, bgColor, DEFAULT_FG_COLOR, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y       Y position of the button in the view.
     * @param x       X position of the button in the view.
     * @param w       Width of the button.
     * @param h       Height of the button.
     * @param bgColor Background color of the button.
     * @param fgColor Foreground color of the button.
     * @param content Content of the button.
     */
    public MyButton(int x, int y, int w, int h, Color bgColor, Color fgColor, String content) {
        this(x, y, w, h, bgColor, fgColor, DEFAULT_FONT_SIZE, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param start    Start point of the button.
     * @param size     Size of the button
     * @param bgColor  Background color of the button.
     * @param fgColor  Foreground color of the button.
     * @param content  Content of the button.
     */
    public MyButton(Point start, Dimension size, Color bgColor, Color fgColor, String content) {
        this (start, size, bgColor, fgColor, DEFAULT_FONT_SIZE, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y        Y position of the button in the view.
     * @param x        X position of the button in the view.
     * @param w        Width of the button.
     * @param h        Height of the button.
     * @param bgColor  Background color of the button.
     * @param fgColor  Foreground color of the button.
     * @param fontSize Font size of the button content.
     * @param content  Content of the button.
     */
    public MyButton(int x, int y, int w, int h, Color bgColor, Color fgColor, int fontSize, String content) {
        this(x, y, w, h, bgColor, fgColor, DEFAULT_MG_COLOR, fontSize, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param start    Start point of the button.
     * @param size     Size of the button
     * @param bgColor  Background color of the button.
     * @param fgColor  Foreground color of the button.
     * @param fontSize Font size of the button content.
     * @param content  Content of the button.
     */
    public MyButton(Point start, Dimension size, Color bgColor, Color fgColor, int fontSize, String content) {
        this(start, size, bgColor, fgColor, DEFAULT_MG_COLOR, fontSize, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y        Y position of the button in the view.
     * @param x        X position of the button in the view.
     * @param w        Width of the button.
     * @param h        Height of the button.
     * @param bgColor  Background color of the button.
     * @param fgColor  Foreground color of the button.
     * @param fontSize Font size of the button content.
     * @param content  Content of the button.
     */
    public MyButton(int x, int y, int w, int h, Color bgColor, Color fgColor, Color mgColor, int fontSize, String content) {
        this(x, y, w, h, bgColor, fgColor, mgColor, fontSize, DEFAULT_MG_SIZE, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param start    Start point of the button.
     * @param size     Size of the button
     * @param bgColor  Background color of the button.
     * @param fgColor  Foreground color of the button.
     * @param mgColor  Margin color of the button.
     * @param fontSize Font size of the button content.
     * @param content  Content of the button.
     */
    public MyButton(Point start, Dimension size, Color bgColor, Color fgColor, Color mgColor, int fontSize, String content) {
        this(
                start, size,
                bgColor, fgColor, mgColor,
                fontSize, DEFAULT_MG_SIZE,
                content
        );
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y        Y position of the button in the view.
     * @param x        X position of the button in the view.
     * @param w        Width of the button.
     * @param h        Height of the button.
     * @param bgColor  Background color of the button.
     * @param fgColor  Foreground color of the button.
     * @param fontSize Font size of the button content.
     * @param content  Content of the button.
     */
    public MyButton(int x, int y,
                    int w, int h,
                    Color bgColor, Color fgColor, Color mgColor,
                    int fontSize, int mgSize,
                    String content) {
        this(
                new Point(x, y),
                new Dimension(w, h),
                bgColor, fgColor, mgColor,
                fontSize, mgSize,
                content
        );
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param start    Start point of the button.
     * @param size     Size of the button
     * @param bgColor  Background color of the button.
     * @param fgColor  Foreground color of the button.
     * @param mgColor  Margin color of the button.
     * @param fontSize Font size of the button content.
     * @param mgSize   Margin size of the button.
     * @param content  Content of the button.
     */
    public MyButton(Point start,
                    Dimension size,
                    Color bgColor, Color fgColor, Color mgColor,
                    int fontSize, int mgSize,
                    String content) {
        this.start = start;
        this.size = size;
        this.bgColor = bgColor;
        this.fgColor = fgColor;
        this.mgColor = mgColor;
        this.fontSize = fontSize;
        this.mgSize = mgSize;
        this.content = content;
        listeners = new ArrayList<>();
    }

    /**
     * Add listener to listeners.
     *
     * @param listener Listener to add.
     */
    public void addMyButtonListener(MyButtonListener listener) {
        listeners.add(listener);
    }

    /**
     * Remove listener from buttons listeners.
     *
     * @param listener Listener to remove.
     */
    public void removeMyButtonListener(MyButtonListener listener) {
        this.listeners.remove(listener);
    }

    /**
     * Check if the Mouse event as been triggered in the button area.
     *
     * @param p Point to check.
     * @return True if the Mouse Event as been triggered in the button area.
     */
    protected boolean contains(Point p) {
        // check if the event has been triggered in the button area.
        if (p.x >= this.start.x && p.x <= this.start.x + this.size.width && p.y >= this.start.y && p.y <= this.start.y + this.size.height) {
            return true;
        }
        return false;
    }

    /**
     * Mouse Clicked Event.
     *
     * @param e Mouse Event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        // check the event position
        if (this.contains(e.getPoint())) {
            // trigger event for each listener
            for (MyButtonListener listener : listeners) {
                listener.buttonClicked(this);
            }
        }
    }

    /**
     * Mouse Pressed Event.
     *
     * @param e Mouse Event.
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // check the event position
        if (this.contains(e.getPoint())) {
            // trigger event for each listener
            for (MyButtonListener listener : listeners) {
                listener.buttonPressed(this);
            }
        }
    }

    /**
     * Mouse Released Event.
     *
     * @param e Mouse Event.
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        // check the event position
        if (this.contains(e.getPoint())) {
            // trigger event for each listener
            for (MyButtonListener listener : listeners) {
                listener.buttonReleased(this);
            }
        }
    }

    /**
     * Mouse Entered Event (not implemented).
     *
     * @param e Mouse Event.
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        // future implementations
    }

    /**
     * Mouse Exited Event (not implemented).
     *
     * @param e Mouse Event.
     */
    @Override
    public void mouseExited(MouseEvent e) {
        // future implementations
    }

    /**
     * Mouse dragged event.
     *
     * @param e Mouse Event.
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        // check the event position
        if (this.contains(e.getPoint())) {
            // trigger event for each listener
            for (MyButtonListener listener : listeners) {
                listener.buttonOver(this);
            }
        }
    }

    /**
     * Mouse dragged event.
     *
     * @param e Mouse Event.
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        // check the event position
        if (this.contains(e.getPoint())) {
            // trigger event for each listener
            for (MyButtonListener listener : listeners) {
                listener.buttonOver(this);
            }
        }
    }

    /**
     * Paint graphics of the button.
     *
     * @param g Graphics of the window.
     */
    public void paint(Graphics g) {
        // design the button margin
        g.setColor(this.mgColor);
        g.fillRect(start.x, start.y, size.width, size.height);

        // design the button
        g.setColor(this.bgColor);
        g.fillRect(start.x + mgSize, start.y + mgSize, size.width - mgSize * 2, size.height - mgSize * 2);

        // write the content of the button
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
        g.setColor(this.fgColor);
        g.drawString(this.content, this.start.x + mgSize, this.start.y + this.size.height / 2);
    }
}
