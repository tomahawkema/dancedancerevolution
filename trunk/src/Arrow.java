import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

/**
 * This class generates arrows and add them to a JLayeredPane.
 * 
 * @author tormariu
 */


public class Arrow extends JLayeredPane implements ActionListener{
	
	protected Image arrowImage;
	protected int xPos;
	private Timer timer;
	public int pub_dir = -1;
	protected int scalingFactor = 20; // this is a sync. variable  
	boolean notAdded = true;

	/**
	 * Constructs an arrow with a certain direction given by the parameter direction.
	 * Sets is initial position based on that parameter.
	 * 
	 * @param direction the direction the arrow will have
	 * @param initialDelay the delay passed to the timer
	 * @throws InterruptedException
	 */
	public Arrow(int direction, int initialDelay) throws InterruptedException{
		pub_dir = direction;
		Runner.getPanel().requestFocus();
		this.setFocusable(false);	
		try {
			switch(direction){
	    		case 0:
	    			arrowImage =ImageIO.read(new File("images/left_purple.png"));
	    			xPos = 0;
	    			break;
	    		case 1:
	    			arrowImage =ImageIO.read(new File("images/up_purple.png"));
	    			xPos = 100;
	    			break;
	    		case 2:
	    			arrowImage =ImageIO.read(new File("images/down_purple.png"));
	    			xPos = 200;
	    			break;
	    		case 3:
	    			arrowImage =ImageIO.read(new File("images/right_purple.png"));
	    			xPos = 300;
	    			break;
	    		default:
	    			System.out.println("error");
	    	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		timer = new Timer(15, this); // this is a sync. variable 
		timer.setInitialDelay(initialDelay*scalingFactor);
		timer.start();
		
		this.setSize(100, 100);
		this.setVisible(true);
		this.setEnabled(true);
		this.setLocation(xPos, 600);
	}
	
	/**
	 * Return the direction of the arrow.
	 * 
	 * @return the arrow's direction
	 */
	public int getDir(){
		return this.pub_dir;
	}
	
	/**
	 * Painting the arrow.
	 */
	public void paint(Graphics g) {
		g.drawImage(arrowImage, 0, 0, null);
	}

	/**
	 * Changes the arrow's y-position for every timestep defined in the timer in the constructor.
	 * Adding the arrow to the arrowlistener once its in the range to get focus on the screen. If
	 * options, such that setting the score and setting the combo haven't happened when the arrow
	 * leaves the screen, this will be done now.
	 */
	public void actionPerformed(ActionEvent e) {
		this.setLocation(getLocation().x, getLocation().y-2);
		if(getLocation().y<-100){
			int a = CreateGUI.arrowlistener.findArrow(this.pub_dir);
			if(a != -1){
				CreateGUI.score.setScore(-5);
				CreateGUI.arrowlistener.removeArrow(a);
				CreateGUI.score.setCombo(0);
			}
			this.timer.stop();
		}
		else if(getLocation().y<100 && notAdded){
			CreateGUI.arrowlistener.addArrow(this.pub_dir);
			notAdded = false;
		}
	}
 }

