
package pong;

import javax.swing.JFrame;

/**
 * @author Beau Marwaha
 */

/**
 * TO DO:
 * 
 */
public class Pong extends JFrame {
    
    public Pong() {
        //creates the window object 
        add(new window());
        
        //customizes the window object made above
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setTitle("Pong");
        setResizable(false);
        setVisible(true); 
    }
    
    public static void main(String[] args) {
        new Pong();
    }
    
}
