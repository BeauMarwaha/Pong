
package pong;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * @author Beau Marwaha
 */
public class ball {
    
    
    private int dx;
    private int dy;
    private int x;
    private int y;
    private final ImageIcon II = 
            new ImageIcon(this.getClass().getResource("images/ball.png"));
    private final Image IMAGE = II.getImage();
    
    /**
     * Standard ball object with default values
     */
    public ball() {
        x = 300;
        y = 300;
        dx = 0;
        dy = 0;
    }
    
    /**
     * Changes the y and x value by dy and dx allowing 
     * the paddle to move onscreen
    */
    public void move() {
        x += dx;
        y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public void setdx(int dx) {
        this.dx = dx;
    }

    public void setdy(int dy) {
        this.dy = dy;
    }
    
    public Image getImage() {
        return IMAGE;
    }
}
