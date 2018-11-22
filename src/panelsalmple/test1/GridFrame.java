package panelsalmple.test1;/*
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

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Frame for control the GridPanl.
 * 
 * @author giuliobosco
 * @version 21.10.2018
 */
public class GridFrame extends JFrame {
    
    /**
     *  North Panel for control the columns of the grid panel.
     */
    private JPanel colsManagementPanel;
    
    /**
     * Button for Increase the columns of the grid panel.
     */
    private JButton increaseColsButton;
    
    /**
     * Button for Decrease the columns of the grid panel.
     */
    private JButton decreaseColsButton;
    
    /**
     * East Panel for control the rows of the grid panel.
     */
    private JPanel rowsManagementPanel;
    
    /**
     * Button for Increase the rows of the grid panel.
     */
    private JButton increaseRowsButton;
    
    /**
     * Button for Decrease the rows of the grid panel.
     */
    private JButton decreaseRowsButton;
    
    /**
     * South Panel for control the margin of the grid panel.
     */
    private JPanel marginManagementPanel;
    
    /**
     * Button for increase the margin of the grid panel.
     */
    private JButton increaseMarginButton;
    
    /**
     * Button for decrease the margin of the grid panel.
     */
    private JButton decreaseMarginButton;
    
    /**
     * Center Panel with the grid.
     */
    private GridPanel gridPanel;

    /** 
     * Constructor without parameters.
     */
    public GridFrame() {
        this.initComponents();
    }
    
    /**
     * Initialize components.
     */
    private void initComponents() {
        /*
         * Initialize the Frame
         */
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        /*
         * Initialize the columns management panel.
         */
        this.colsManagementPanel = new JPanel();
        this.colsManagementPanel.setLayout(new GridLayout(1, 0));
        
        /*
         * Initialize the increase columns button. 
         */
        this.increaseColsButton = new JButton();
        this.increaseColsButton.setText("+");
        this.increaseColsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                increaseColsActionPerformed(e);
            }
        });
        this.colsManagementPanel.add(this.increaseColsButton);
        
        /*
         * Initialize the decrease columns button.
         */
        this.decreaseColsButton = new JButton();
        this.decreaseColsButton.setText("-");
        this.decreaseColsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decreaseColsActionPerformed(e);
            }
        });
        this.colsManagementPanel.add(this.decreaseColsButton);
        
        /*
         * Add the columns management panel to the frame.
         */
        this.getContentPane().add(this.colsManagementPanel, BorderLayout.NORTH);
        
        /*
         * Initialize the rows managemet panel.
         */
        this.rowsManagementPanel = new JPanel();
        this.rowsManagementPanel.setLayout(new GridLayout(0, 1));
        
        /*
         * Initialize the increase rows button.
         */
        this.increaseRowsButton = new JButton();
        this.increaseRowsButton.setText("+");
        this.increaseRowsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                increaseRowsActionPerformed(e);
            }
        });
        this.rowsManagementPanel.add(this.increaseRowsButton);
        
        /*
         * Initialize the decrease rows button.
         */
        this.decreaseRowsButton = new JButton();
        this.decreaseRowsButton.setText("-");
        this.decreaseRowsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                decreaseRowsActionPefrormed(e);
            }
        });
        this.rowsManagementPanel.add(this.decreaseRowsButton);
        
        /*
         * Add the rows management panel to the frame.
         */
        this.getContentPane().add(this.rowsManagementPanel, BorderLayout.EAST);
        
        /**
         * Initialize the margin management panel.
         */
        this.marginManagementPanel = new JPanel();
        this.marginManagementPanel.setLayout(
                new BoxLayout(marginManagementPanel, BoxLayout.LINE_AXIS)
        );
        
        /*
         * Initialize the increase margin button. 
         */
        this.increaseMarginButton = new JButton();
        this.increaseMarginButton.setText("+");
        this.increaseMarginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                increaseMarginActionPerformed(e);
            }
        });
        this.marginManagementPanel.add(this.increaseMarginButton);
        
        /*
         * Initialize the decrease margin button.
         */
        this.decreaseMarginButton = new JButton();
        this.decreaseMarginButton.setText("-");
        this.decreaseMarginButton.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {
                decreaseMarginActionPefrormed(e);
            }
        });
        this.marginManagementPanel.add(this.decreaseMarginButton);
        
        /*
         * Add the margin management panel to the frame.
         */
        this.getContentPane().add(this.marginManagementPanel, BorderLayout.SOUTH);
        
        /*
         * Initialize the grid panel.
         */
        this.gridPanel = new GridPanel();
        
        /*
         * Add the grid panel to the frame. 
         */
        this.getContentPane().add(this.gridPanel, BorderLayout.CENTER);
        
        this.pack();
    }
    
    /**
     * Increase the columns in the grid. 
     * 
     * @param e Action Event.
     */
    private void increaseColsActionPerformed(ActionEvent e) {
        this.gridPanel.increaseCols();
    }
    
    /**
     * Decrease the columns in the grid.
     * 
     * @param e Action Event.
     */
    private void decreaseColsActionPerformed(ActionEvent e) {
        this.gridPanel.decreaseCols();
    }
    
    /**
     * Increase the rows in the grid.
     * 
     * @param e Action Event. 
     */
    private void increaseRowsActionPerformed(ActionEvent e) {
        this.gridPanel.increaseRows();
    }
    
    /**
     * Decrease the rows in the grid.
     * 
     * @param e Action Event.
     */
    private void decreaseRowsActionPefrormed(ActionEvent e) {
        this.gridPanel.decreaseRows();
    }
    
    /**
     * Increase the margin of the grid.
     * 
     * @param e Action Event. 
     */
    private void increaseMarginActionPerformed(ActionEvent e) {
        this.gridPanel.increaseMarign();
    }
    
    /**
     * Increase the margin of the grid.
     * 
     * @param e Action Event.
     */
    private void decreaseMarginActionPefrormed(ActionEvent e) {
        this.gridPanel.decreaseMargin();
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GridFrame().setVisible(true);
            }
        });
    }
}
