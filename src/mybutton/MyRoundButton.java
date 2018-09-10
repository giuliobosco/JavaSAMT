package mybutton;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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
        g.setColor(this.bgColor);
        g.fillOval(x, y, w, h);

        g.setFont(new Font("TimesRoman", Font.PLAIN, this.fontSize));
        g.setColor(this.fgColor);
        g.drawString(this.content, this.x, this.y + this.h / 2);
    }
}
