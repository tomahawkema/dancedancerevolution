import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import java.util.*;

public class Arrow extends JLayeredPane{
	
	protected Image arrowImage;
	protected int xPos;

	public enum Direction{
		LEFT, UP, DOWN, RIGHT
	}
			
	public Arrow(Direction dir){
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
		
		this.setSize(100, 100);
		this.setVisible(true);
		this.setLocation(xPos, 700);
	}
	
	public void setYpos(int yPos){
		this.setLocation(xPos, yPos);
	}
	
	public int getYpos(){
		return this.getY();
	}
	
	public void paint(Graphics g) {
		g.drawImage(arrowImage, 0, 0, arrowImage.getWidth(this), arrowImage.getHeight(this), null);
	}
 }

