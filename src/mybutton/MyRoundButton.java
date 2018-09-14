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

import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Dimension;

public class MyRoundButton extends MyButton {

    /**
     * Center of the round button.
     */
    private Point buttonCenter;

    /**
     * Radius of the round but
     */
    private int radius;

    /**
     * Getter for the center of the round button center.
     *
     * @return Center of the round button.
     */
    public Point getButtonCenter() {
        return buttonCenter;
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y       Y position of the button in the view.
     * @param x       X position of the button in the view.
     * @param radius  Radius of the round button.
     * @param content Content of the button.
     */
    public MyRoundButton(int x, int y, int radius, String content) {
        this(x, y, radius, DEFAULT_BG_COLOR, DEFAULT_FG_COLOR, DEFAULT_FONT_SIZE, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y       Y position of the button in the view.
     * @param x       X position of the button in the view.
     * @param radius  Radius of the round button.
     * @param bgColor Background color of the button.
     * @param content Content of the button.
     */
    public MyRoundButton(int x, int y, int radius, Color bgColor, String content) {
        this(x, y, radius, bgColor, DEFAULT_FG_COLOR, DEFAULT_FONT_SIZE, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y       Y position of the button in the view.
     * @param x       X position of the button in the view.
     * @param radius  Radius of the round button.
     * @param bgColor Background color of the button.
     * @param fgColor Foreground color of the button.
     * @param content Content of the button.
     */
    public MyRoundButton(int x, int y, int radius, Color bgColor, Color fgColor, String content) {
        this(x, y, radius, bgColor, fgColor, DEFAULT_FONT_SIZE, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y        Y position of the button in the view.
     * @param x        X position of the button in the view.
     * @param radius   Radius of the round button.
     * @param bgColor  Background color of the button.
     * @param fgColor  Foreground color of the button.
     * @param fontSize Font size of the button content.
     * @param content  Content of the button.
     */
    public MyRoundButton(int x, int y, int radius, Color bgColor, Color fgColor, int fontSize, String content) {
        this(x, y, radius, bgColor, fgColor, DEFAULT_MG_COLOR, fontSize, DEFAULT_MG_SIZE, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y        Y position of the button in the view.
     * @param x        X position of the button in the view.
     * @param radius   Radius of the round button.
     * @param bgColor  Background color of the button.
     * @param fgColor  Foreground color of the button.
     * @param fontSize Font size of the button content.
     * @param content  Content of the button.
     */
    public MyRoundButton(int x, int y,
                         int radius,
                         Color bgColor, Color fgColor, Color mgColor,
                         int fontSize,
                         String content) {
        this(x, y, radius, bgColor, fgColor, mgColor, fontSize, DEFAULT_MG_SIZE, content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     *
     * @param y        Y position of the button in the view.
     * @param x        X position of the button in the view.
     * @param radius   Radius of the round button.
     * @param bgColor  Background color of the button.
     * @param fgColor  Foreground color of the button.
     * @param fontSize Font size of the button content.
     * @param content  Content of the button.
     */
    public MyRoundButton(int x, int y,
                         int radius,
                         Color bgColor, Color fgColor, Color mgColor,
                         int fontSize, int mgSize,
                         String content) {
        super(x, y, radius * 2, radius * 2, bgColor, fgColor, mgColor, fontSize, mgSize, content);

        this.buttonCenter = new Point(this.start.x + radius, this.start.y + radius);
        this.radius = radius;
        this.size = new Dimension(radius * 2, radius * 2);
    }

    /**
     * Check if the Mouse event as been triggered in the button area.
     *
     * @param p Point to check.
     * @return True if the Mouse Event as been triggered in the button area.
     */
    @Override
    protected boolean contains(Point p) {

        if (buttonCenter.distance(p) < radius) {
            return true;
        }
        return false;
    }

    /**
     * Paint graphics of the button.
     *
     * @param g Graphics of the window.
     */
    public void paint(Graphics g) {
        // design the button margin
        g.setColor(mgColor);
        g.fillOval(this.start.x, this.start.y, this.size.width, this.size.height);

        // design the button
        g.setColor(this.bgColor);
        g.fillOval(this.start.x + mgSize, this.start.y + mgSize, this.size.width - 2 * mgSize, this.size.height - 2 * mgSize);

        // print the content of the button
        g.setFont(new Font("TimesRoman", Font.PLAIN, this.fontSize));
        g.setColor(this.fgColor);
        g.drawString(this.content, this.start.x + mgSize, this.start.y + this.size.height / 2);
    }
}
