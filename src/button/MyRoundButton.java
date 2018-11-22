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
package button;

import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Dimension;

public class MyRoundButton extends MyButton {

    /**
     * Default center point of the round button.
     * Value:
     * <ul>
     * <li>X: 50</li>
     * <li>Y: 50</li>
     * </ul>
     */
    public static final Point DEFAULT_CENTER = new Point(50, 50);

    /**
     * Default radius of the round button.
     * Value: 50.
     */
    public static final int DEFAULT_RADIUS = 50;

    /**
     * Default content of the round button.
     * Value: "MyRoundButton".
     */
    public static final String DEFAULT_CONTENT = "MyRoundButton";

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
     * Setter for the center of the round button center.
     *
     * @param buttonCenter Center of the round button.
     */
    public void setButtonCenter(Point buttonCenter) {
        this.buttonCenter = buttonCenter;
    }

    /**
     * Getter for the radius of the button center.
     *
     * @return Radius of the button center.
     */
    public int getRadius() {
        return this.radius;
    }

    /**
     * Setter for the radius of the button center.
     *
     * @param radius Radius of the button center.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * No parameter constructor. All default parameters.
     */
    public MyRoundButton() {
        this(DEFAULT_CENTER);
    }

    /**
     * Constructor with y position, x position.
     *
     * @param y Y position of the button in the view.
     * @param x X position of the button in the view.
     */
    public MyRoundButton(int x, int y) {
        this(x, y, DEFAULT_RADIUS);
    }

    /**
     * Contructor with button center.
     *
     * @param buttonCenter Center of the Round button
     */
    public MyRoundButton(Point buttonCenter) {
        this(buttonCenter, DEFAULT_RADIUS);
    }

    /**
     * Constructor with y position, x position, radius.
     *
     * @param y      Y position of the button in the view.
     * @param x      X position of the button in the view.
     * @param radius Radius of the round button.
     */
    public MyRoundButton(int x, int y, int radius) {
        this(x, y, radius, DEFAULT_CONTENT);
    }

    /**
     * Contructor with button center, radius.
     *
     * @param buttonCenter Center of the Round button
     * @param radius       Radius of the round button.
     */
    public MyRoundButton(Point buttonCenter, int radius) {
        this(buttonCenter, radius, DEFAULT_CONTENT);
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
        this(x, y, radius, DEFAULT_BG_COLOR, content);
    }

    /**
     * Contructor with button center, button radiuscontent.
     *
     * @param buttonCenter Center of the Round button
     * @param radius       Radius of the round button.
     * @param content      Content of the round button.
     */
    public MyRoundButton(Point buttonCenter, int radius, String content) {
        this(buttonCenter, radius, DEFAULT_BG_COLOR, content);
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
        this(x, y, radius, bgColor, DEFAULT_FG_COLOR, content);
    }

    /**
     * Contructor with button center, button radius, background color, content.
     *
     * @param buttonCenter Center of the Round button
     * @param radius       Radius of the round button.
     * @param bgColor      Background round button color.
     * @param content      Content of the round button.
     */
    public MyRoundButton(Point buttonCenter, int radius, Color bgColor, String content) {
        this(buttonCenter, radius, bgColor, DEFAULT_FG_COLOR, content);
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
     * Contructor with button center, button radius, background color, foreground color, content.
     *
     * @param buttonCenter Center of the Round button
     * @param radius       Radius of the round button.
     * @param bgColor      Background round button color.
     * @param fgColor      Foreground round button color.
     * @param content      Content of the round button.
     */
    public MyRoundButton(Point buttonCenter, int radius, Color bgColor, Color fgColor, String content) {
        this(buttonCenter, radius, bgColor, fgColor, DEFAULT_FONT_SIZE, content);
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
     * Contructor with button center, button radius, background color, foreground color, font size, content.
     *
     * @param buttonCenter Center of the Round button
     * @param radius       Radius of the round button.
     * @param bgColor      Background round button color.
     * @param fgColor      Foreground round button color.
     * @param fontSize     Font content size.
     * @param content      Content of the round button.
     */
    public MyRoundButton(Point buttonCenter, int radius, Color bgColor, Color fgColor, int fontSize, String content) {
        this(buttonCenter, radius, bgColor, fgColor, DEFAULT_MG_COLOR, fontSize, content);
    }

    /**
     * Constructor with y position, x position, radius, background color, foreground color, font size, label content.
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
     * Contructor with button center, button radius, background color, foreground color, marign color, font size, content.
     *
     * @param buttonCenter Center of the Round button
     * @param radius       Radius of the round button.
     * @param bgColor      Background round button color.
     * @param fgColor      Foreground round button color.
     * @param mgColor      Margin round button color.
     * @param fontSize     Font content size.
     * @param content      Content of the round button.
     */
    public MyRoundButton(Point buttonCenter, int radius,
                         Color bgColor, Color fgColor, Color mgColor,
                         int fontSize,
                         String content) {
        this(buttonCenter, radius, bgColor, fgColor, mgColor, fontSize, DEFAULT_MG_SIZE, content);
    }

    /**
     * Constructor with y position, x position, width, height, background color, foreground color, font size, label content.
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
        this(new Point(x, y), radius, bgColor, fgColor, mgColor, fontSize, mgSize, content);
    }

    /**
     * Constructor with position, radius, background color, foreground color, margin color, font size, margins size, content.
     *
     * @param buttonCenter Center of the Round button
     * @param radius       Radius of the round button.
     * @param bgColor      Background round button color.
     * @param fgColor      Foreground round button color.
     * @param mgColor      Margin round button color.
     * @param fontSize     Font content size.
     * @param mgSize       Margin size of the round button.
     * @param content      Content of the round button.
     */
    public MyRoundButton(Point buttonCenter, int radius,
                         Color bgColor, Color fgColor, Color mgColor,
                         int fontSize, int mgSize,
                         String content) {
        this.setButtonCenter(buttonCenter);
        this.setRadius(radius);

        this.setBgColor(bgColor);
        this.setFgColor(fgColor);
        this.setMgColor(mgColor);

        this.setFontSize(fontSize);
        this.setMgSize(mgSize);

        this.setContent(content);

        this.setSize(new Dimension(radius * 2, radius * 2));
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
