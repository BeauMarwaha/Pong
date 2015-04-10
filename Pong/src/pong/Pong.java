
package pong;

import javax.swing.JFrame;

/**
 * @author Beau Marwaha
 */

/**
 * TO DO:
 * change so no lag between button pushes for up and down
 * scoring and scoring on screen
 * directions for game
 */
public class Pong extends JFrame {
    
    public Pong() {
        //creates the window object 
        add(new window());
        
        //customizes the window object made above
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setTitle("Pong");
        setResizable(false);
        setVisible(true); 
    }
    
    public static void main(String[] args) {
        new Pong();
    }
    
}
