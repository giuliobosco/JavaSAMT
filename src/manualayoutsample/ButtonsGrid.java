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

package manualayoutsample;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

/**
 * Grid of buttons.
 * Auto generate an matrix of buttons.
 * 
 * @author giuliobosco
 * @version 1.0
 */
public class ButtonsGrid extends JFrame implements ActionListener {
    
    public static final int DFL_ROWS = 10;
    
    public static final int DFL_COLS = 10;
    
    private JButton[][] buttons;
    
    public ButtonsGrid(Dimension size) {
        this.buttons = new JButton[size.height][size.width];
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(80*size.width, 20*size.height));
        
        this.setLayout(new GridLayout(size.width, size.height));
        
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton(j + ":" + i);
                buttons[i][j].addActionListener(this);
                
                this.getContentPane().add(buttons[i][j]);
            }
        }
        
        pack();
    }
    
    public ButtonsGrid(int x, int y) {
        this(new Dimension(x, y));
    }
    
    public ButtonsGrid() {
        this(DFL_ROWS, DFL_COLS);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pressed Button: " + ((JButton) e.getSource()).getText());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ButtonsGrid().setVisible(true);
            }
        });
    }
}
