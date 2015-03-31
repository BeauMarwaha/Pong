
package pong;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Beau Marwaha
 */
public class paddleLeft {
    
    private int dy;
    private int x;
    private int y;
    private final ImageIcon II = new ImageIcon(this.getClass().getResource("images/stance.gif"));
    private final Image IMAGE = II.getImage();
    
    public paddleLeft() {
        x = 50;
        y = 300;
    }
    
    public void move() {
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
    
    public void setdy(int dy) {
        this.dy = dy;
    }
    
    public Image getImage() {
        return IMAGE;
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            if(y > 0){
                dy = -2;
            }else{
                y = 0;
                dy = 0;
            }

        }

        if (key == KeyEvent.VK_S) {
            if(y < 700){
                dy = 2;
            }else{
                y = 570;
                dy = 0;
            }
        }
    }
    
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            dy = 0;
        }

        if (key == KeyEvent.VK_S) {
            dy = 0;
        }
    }
    
}
