
package pong;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setTitle("Pong");
        setResizable(false);
        setVisible(true); 
    }
    
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to Pong. \n"
                                        + "Left Side use W and S to move up and down. \n" 
                                        + "Right Side use the UP and DOWN arrows to move up and down. \n");
        new Pong();
    }
    
}
