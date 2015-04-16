
package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @author Beau Marwaha
 */
public class window extends JPanel implements ActionListener {
    
    final private Timer timer;
    private BufferedImage image;
    private BufferedImage leftScoreImage;
    private BufferedImage rightScoreImage;
    
    final private paddleLeft paddleLeft;
    final private paddleRight paddleRight;
    final private ball ball;
    
    private int leftPoints = 0;
    private int rightPoints = 0;
   
    public window() {
        
        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
        try {                
           image = ImageIO.read(new File("src\\pong\\images\\back.png"));
        } catch (IOException ex) {}
        
        try {                
            leftScoreImage = ImageIO.read(new File("src\\pong\\images\\0.png"));
        } catch (IOException ex) {}
        
        try {                
            rightScoreImage = ImageIO.read(new File("src\\pong\\images\\0.png"));
        } catch (IOException ex) {}
        
        paddleLeft = new paddleLeft();
        paddleRight = new paddleRight();
        ball = new ball();
        
        timer = new Timer(0, this);
        timer.start();
    }
    
    @Override
    public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D)g;

            //Paints the background of the screen
            g.drawImage(image, 0, 0, null);
            
            //Paints the objects on the screen
            g2d.drawImage(paddleLeft.getImage(), paddleLeft.getX(), paddleLeft.getY(), this);
            g2d.drawImage(paddleRight.getImage(), paddleRight.getX(), paddleRight.getY(), this);
            g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(), this);
            
            //Paints the score on the screen
            try {                
                leftScoreImage = ImageIO.read(new File("src\\pong\\images\\"+leftPoints+".png"));
            } catch (IOException ex) {}
            try {                
                rightScoreImage = ImageIO.read(new File("src\\pong\\images\\"+rightPoints+".png"));
            } catch (IOException ex) {}
            g2d.drawImage(leftScoreImage, 300, 100, this);
            g2d.drawImage(rightScoreImage, 900, 100, this);
            
            //restricts the left paddles movement
            if(paddleLeft.getY() < 0){
                paddleLeft.setY(0); 
            }else if(paddleLeft.getY() > 675){
                paddleLeft.setY(675); 
            }
            
            //restricts the right paddles movement
            if(paddleRight.getY() < 0){
                paddleRight.setY(0); 
            }else if(paddleRight.getY() > 675){
                paddleRight.setY(675); 
            }
            
            Toolkit.getDefaultToolkit().sync();
            g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        paddleLeft.move();
        paddleRight.move();
        ball.move();
        
        //These rectangles represent the current locations of the three objects
        Rectangle rectanglePaddleL = new Rectangle(paddleLeft.getX(), paddleLeft.getY(), paddleLeft.getWidth(), paddleLeft.getHeight());
        Rectangle rectanglePaddleR = new Rectangle(paddleRight.getX(), paddleRight.getY(), paddleRight.getWidth(), paddleRight.getHeight());
        Rectangle rectangleball = new Rectangle(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        
        //This section handles paddle and ball collision
        if(rectanglePaddleL.intersects(rectangleball)){
            ball.setdx(ball.getSpeed());
            ball.setSpeed(ball.getSpeed() + 1);
        }else if(rectanglePaddleR.intersects(rectangleball)){
            ball.setdx(-ball.getSpeed());
            ball.setSpeed(ball.getSpeed() + 1);
        }
        
        //This section handles scoring
        if(ball.getX() < 0){
            ball.setSpeed(3);
            ball.setdx(ball.getSpeed());
            ball.setdy(ball.getSpeed());
            ball.setX(600);
            ball.setY(350);  
            rightPoints += 1;
            if(rightPoints > 9){
                JOptionPane.showMessageDialog(null, "Right Side Wins! \n"
                                                + "Final Score: " + rightPoints + " to " + leftPoints + ".");
                System.exit(0);
            }
        }else if(ball.getX() > 1175){
            ball.setSpeed(3);
            ball.setdx(-ball.getSpeed());
            ball.setdy(-ball.getSpeed());
            ball.setX(600);
            ball.setY(350); 
            leftPoints += 1;
            if(leftPoints > 9){
                JOptionPane.showMessageDialog(null, "Left Side Wins! \n"
                                                + "Final Score: " + leftPoints + " to " + rightPoints + ".");
                System.exit(0);
            }
        }
        
        //This section handles bouncing off the top and bottom of the screen
        if(ball.getY() < 0){
            ball.setdy(ball.getSpeed());
        }else if(ball.getY() > 750){
            ball.setdy(-ball.getSpeed());
        }
        System.out.println("speed " + ball.getSpeed());
        repaint();  
    }
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            paddleLeft.keyReleased(e);
            paddleRight.keyReleased(e);
        }
        
        @Override
        public void keyPressed(KeyEvent e) {
            paddleLeft.keyPressed(e);
            paddleRight.keyPressed(e);
        }
    }
    
}
