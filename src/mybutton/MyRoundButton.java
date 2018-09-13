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

import java.awt.*;
import java.awt.event.MouseEvent;

public class MyRoundButton extends MyButton {

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     * @param y Y position of the button in the view.
     * @param x X position of the button in the view.
     * @param radius Radius of the round button.
     * @param content Content of the button.
     */
    public MyRoundButton(int x, int y, int radius, String content) {
        super(x,y,radius,radius,content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     * @param y Y position of the button in the view.
     * @param x X position of the button in the view.
     * @param radius Radius of the round button.
     * @param bgColor Background color of the button.
     * @param content Content of the button.
     */
    public MyRoundButton(int x, int y, int radius, Color bgColor, String content) {
        super(x,y,radius,radius,bgColor,content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     * @param y Y position of the button in the view.
     * @param x X position of the button in the view.
     * @param radius Radius of the round button.
     * @param bgColor Background color of the button.
     * @param fgColor Foreground color of the button.
     * @param content Content of the button.
     */
    public MyRoundButton(int x, int y, int radius, Color bgColor, Color fgColor, String content) {
        super(x,y,radius,radius,bgColor,fgColor,content);
    }

    /**
     * Constructor with y position, x position, width, height, bgColor, label content.
     * @param y Y position of the button in the view.
     * @param x X position of the button in the view.
     * @param radius Radius of the round button.
     * @param bgColor Background color of the button.
     * @param fgColor Foreground color of the button.
     * @param fontSize Font size of the button content.
     * @param content Content of the button.
     */
    public MyRoundButton(int x, int y, int radius, Color bgColor, Color fgColor, int fontSize, String content) {
        super(x,y,radius,radius,bgColor,fgColor,fontSize,content);
    }

    /**
     * Check if the Mouse event as been triggered in the button area.
     * @param e Mouse Event.
     * @return True if the Mouse Event as been triggered in the button area.
     */
    @Override
    protected boolean isMouseEventIn(MouseEvent e) {

        int radius = (int) this.w / 2;

        if (Math.pow(e.getX() - (this.x + radius), 2) + Math.pow(e.getY() - (this.y + radius), 2) < Math.pow(radius, 2)) {
            return true;
        }
        return false;
    }

    /**
     * Paint graphics of the button.
     * @param g Graphics of the window.
     */
    public void paint(Graphics g) {
        // design the button margin
        g.setColor(mgColor);
        g.fillOval(x, y, w, h);

        // design the button
        g.setColor(this.bgColor);
        g.fillOval(x + mgSize, y + mgSize, w - 2 * mgSize, h - 2 * mgSize);

        // print the content of the button
        g.setFont(new Font("TimesRoman", Font.PLAIN, this.fontSize));
        g.setColor(this.fgColor);
        g.drawString(this.content, this.x + mgSize, this.y + this.h / 2);
    }
}
