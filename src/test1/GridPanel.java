import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * Grid panel.
 * 
 * @author giuliobosco
 * @version 04.10.2018
 */
public class GridPanel extends JPanel{
    
    /**
     * Default margin of the grid.
     * Used also for margin increase or decrease.
     */
    public static final int DFL_MARGIN = 10;
    
    /**
     * Minimal columns in the grid.
     */
    public static final int MIN_COLS = 5;
    
    /**
     * Default columns in the grid.
     */
    public static final int DFL_COLS = 10;
    
    /**
     * Minimal rows in the grid.
     */
    public static final int MIN_ROWS = 5;
    
    /**
     * Default rows in the grid.
     */
    public static final int DFL_ROWS = 10;
    
    /**
     * Margin of the grid.
     */
    private int margin;
    
    /**
     * Columns of the grid.
     */
    private int cols;
    
    /**
     * Rows of the grid.
     */
    private int rows;
    
    /**
     * Size of the 
     */
    private int size;
    
    /**
     * Padding for center the grid.
     */
    private Dimension padding;
    
    /**
     * Setter for the margin of the grid.
     * 
     * @param margin Margin of the grid.
     */
    public void setMargin(int margin) {
        if (margin > 0) {
            this.margin = margin;
        } else {
            this.margin = 0;
        }
        
        this.repaint();
    }
    
    /**
     * Getter for the margin of the grid.
     * 
     * @return Margin of the grid.
     */
    public int getMargin() {
        return this.margin;
    }
    
    /**
     * Setter for the columns of the grid.
     * 
     * @param cols Columns of the grid.
     */
    public void setCols(int cols) {
        if (cols >= MIN_COLS) {
            this.cols = cols;
        } else {
            this.cols = MIN_COLS;
        }
        
        this.repaint();
    }
    
    /**
     * Getter for the columns of the grid.
     * 
     * @return Columns of the grid.
     */
    public int getCols() {
        return this.cols;
    }
    
    /**
     * Setter for the rows of the grid.
     * 
     * @param rows Rows of the grid.
     */
    public void setRows(int rows) {
        if (rows >= MIN_ROWS) {
            this.rows = rows;
        } else {
            this.rows = MIN_ROWS;
        }
        
        this.repaint();
    }
    
    /**
     * Getter for the rows of the grid.
     * 
     * @return Rows of the grid.
     */
    public int getRows() {
        return this.rows;
    }
    
    /**
     * Getter for the width of the panel without the margins.
     * 
     * @return Width of the panel without the margins.
     */
    public int getWidthMargin() {
        return this.getWidth() - 2 * this.margin;
    }
    
     /** 
      * Getter for the height of the panel without the margins.
      * 
      * @return Height of the panel without the margins.
      */
    public int getHeightMargin() {
        return this.getHeight() - 2 * this.margin;
    }
    
    /**
     * Create the panel with default rows, columns and margins.
     */
    public GridPanel() {
        this.rows = DFL_ROWS;
        this.cols = DFL_COLS;
        
        this.margin = DFL_MARGIN;
    }
    
    /**
     * Calculate the coordinate for center the grid and the block size.
     */
    public void center() {
        int midHeight = this.getHeightMargin() / this.rows;
        int midWidth = this.getWidthMargin() / this.cols;
        
        this.size = (midHeight > midWidth)? midWidth : midHeight;
        
        this.padding = new Dimension(
                (int) ((getHeightMargin() - this.rows * this.size) / 2) + this.margin,
                (int) ((getWidthMargin() - this.cols * this.size) / 2) + this.margin
        );
        
        System.out.println(size);
    }
    
    /**
     * Get the blocks height in pixels.
     * 
     * @param blocks Blocks.
     * @return Pixels.
     */
    private int getBlocks(int blocks) {
        return this.size * blocks;
    }
    
    /**
     * Get position form top in pixels for blocks.
     * 
     * @param blocks Blocks.
     * @return Pixels.
     */
    private int getTop(int blocks) {
        return this.padding.height + this.getBlocks(blocks);
    }
    
    /**
     * Get position from left in pixels for blocks.
     * 
     * @param blocks Blocks.
     * @return Pixels.
     */
    private int getLeft(int blocks) {
        return this.padding.width + this.getBlocks(blocks);
    }
    
    /**
     * Paint the grid.
     * @param g Graphics of the window.
     */
    @Override
    public void paint(Graphics g) {
        this.center();
        
        g.setColor(Color.white);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
        
        g.setColor(Color.black);
        for (int i = 0; i <= this.cols; i++) {
           g.drawLine(
                   this.getTop(0), 
                   this.getLeft(i), 
                   this.getTop(this.rows), 
                   this.getLeft(i));
        }
        for (int i = 0; i <= this.rows; i++) {
            g.drawLine(
                   this.getTop(i), 
                   this.getLeft(0), 
                   this.getTop(i), 
                   this.getLeft(this.cols));
        }
        
    }
    
    public void increaseRow() {
        this.setRows(this.getRows() + 1);
    }
    
    public void decreaseRow() {
        this.setRows(this.getRows() - 1);
    }
    
    public void increaseCol() {
        this.setCols(this.getCols() + 1);
    }
    
    public void decreaseCol() {
        this.setCols(this.getCols() - 1);
    }
    
    public void increaseMarign() {
        this.setMargin(this.getMargin() + DFL_MARGIN);
    }
    
    public void decreaseMargin() {
        this.setMargin(this.getMargin() - DFL_MARGIN);
    }
}
