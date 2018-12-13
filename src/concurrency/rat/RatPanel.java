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

package concurrency.rat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Panel for the rats.
 *
 * @author giuliobosco
 * @version 1.0
 */
public class RatPanel extends JPanel implements MouseListener, RatContainer {
    // -------------------------------------------------------------------------------------------------------- Costants

    /**
     * Background dot size.
     */
    public final static int BG_DOT_SIZE = 2;

    // ------------------------------------------------------------------------------------------------------ Attributes

    /**
     * List of rats.
     */
    private List<Rat> rats;

    // ----------------------------------------------------------------------------------------------- Getters & Setters
    // ---------------------------------------------------------------------------------------------------- Constructors

    /**
     * Constructor without parameters, initialize the rats list and add the mouse listener.
     */
    public RatPanel() {
        this.rats = new ArrayList<>();
        this.addMouseListener(this);
    }

    // ---------------------------------------------------------------------------------------------------- Help Methods

    /**
     * Add a rat to the rat list.
     *
     * @param rat Rat to add to the list.
     */
    public void addRat(Rat rat) {
        this.rats.add(rat);
    }

    /**
     * Paint the background of the panel.
     *
     * @param g Graphics of the panel.
     */
    private void paintBackground(Graphics g) {
        g.setColor(Color.orange);
        Rectangle clippingArea = g.getClipBounds();

        g.fillRect(
                clippingArea.x,
                clippingArea.y,
                clippingArea.width,
                clippingArea.height
        );

        for (int i = 0; i < clippingArea.height / BG_DOT_SIZE * 2; i++) {
            for (int j = 0; j < clippingArea.width / BG_DOT_SIZE * 2; j++) {
                g.setColor(Color.black);
                g.fillOval(
                        clippingArea.x + j * BG_DOT_SIZE * 2,
                        clippingArea.y + i * BG_DOT_SIZE * 2,
                        BG_DOT_SIZE * 2,
                        BG_DOT_SIZE * 2
                );

                g.setColor(Color.yellow);
                g.fillOval(
                        clippingArea.x + j * BG_DOT_SIZE * 2 + 1,
                        clippingArea.y + i * BG_DOT_SIZE * 2 + 1,
                        BG_DOT_SIZE,
                        BG_DOT_SIZE
                );
            }
        }
    }

    // ------------------------------------------------------------------------------------------------- General Methods

    /**
     * Rat moved, repaint the panel.
     *
     * @param source Moved rat.
     */
    @Override
    public void ratMoved(Rat source) {
        this.repaint();
    }

    /**
     * Mouse clicked, create a new rat.
     *
     * @param e Mouse event.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        Rat rat = new Rat(this);
        rat.start();
        this.addRat(rat);
        this.repaint();
    }

    /**
     * Not used.
     *
     * @param e Mouse event.
     */
    @Override
    public void mousePressed(MouseEvent e) {

    }

    /**
     * Not used.
     *
     * @param e Mouse event.
     */
    @Override
    public void mouseReleased(MouseEvent e) {

    }

    /**
     * Not used.
     *
     * @param e Mouse event.
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }

    /**
     * Not used.
     *
     * @param e Mouse event.
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }

    // ----------------------------------------------------------------------------------------------- Static Components

}
