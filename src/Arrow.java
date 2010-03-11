import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import java.util.*;
import javax.swing.Timer;

public class Arrow extends JLayeredPane implements KeyListener, ActionListener{
	
	protected Image arrowImage;
	protected int xPos;
	private Timer timer;
	//protected Timer timer;

	public enum Direction{
		LEFT, UP, DOWN, RIGHT
	}
			
	public Arrow(Direction dir) throws InterruptedException{
		try {
			switch(dir){
	    		case LEFT:
	    			arrowImage =ImageIO.read(new File("images/arrow_left.png"));
	    			xPos = 0;
	    			break;
	    		case UP:
	    			arrowImage =ImageIO.read(new File("images/arrow_up.png"));
	    			xPos = 100;
	    			break;
	    		case DOWN:
	    			arrowImage =ImageIO.read(new File("images/arrow_down.png"));
	    			xPos = 200;
	    			break;
	    		case RIGHT:
	    			arrowImage =ImageIO.read(new File("images/arrow_right.png"));
	    			xPos = 300;
	    			break;
	    		default:
	    			System.out.println("error");
	    	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		timer = new Timer(5, this);
		timer.setInitialDelay(5);
		timer.start();
		
		this.setFocusable(true);
		this.addKeyListener(this);
		this.setSize(100, 100);
		this.setVisible(true);
		this.setLocation(xPos, 700);
	}
	
	public void setYpos(int decrease){
		this.setLocation(xPos, getYpos()+decrease);
	}
	
	public int getYpos(){
		return this.getY();
	}
	
	
	public void paint(Graphics g) {
		g.drawImage(arrowImage, xPos, getY(), null);
		//super.paint(g); //WTF?
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				System.out.println("Trykker venstre!");
				break;
			case KeyEvent.VK_UP:
				System.out.println("Trykker opp!");
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("Trykker ned!");
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println("Trykker høyre!");
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		setYpos(3);
	}
 }

