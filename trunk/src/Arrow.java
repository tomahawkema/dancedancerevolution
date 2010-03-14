import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class Arrow extends JLayeredPane implements KeyListener, ActionListener{
	
	protected Image arrowImage;
	protected int xPos;
	private Timer timer;
	private int score;
	//protected Timer timer;

	public enum Direction{
		LEFT, UP, DOWN, RIGHT
	}
			
	public Arrow(int dir, int initialYposition) throws InterruptedException{
		this.addKeyListener(this);
		this.score = 0;		
		try {
			switch(dir){
	    		case 0:
	    			arrowImage =ImageIO.read(new File("images/arrow_left.png"));
	    			xPos = 0;
	    			break;
	    		case 1:
	    			arrowImage =ImageIO.read(new File("images/arrow_up.png"));
	    			xPos = 100;
	    			break;
	    		case 2:
	    			arrowImage =ImageIO.read(new File("images/arrow_down.png"));
	    			xPos = 200;
	    			break;
	    		case 3:
	    			arrowImage =ImageIO.read(new File("images/arrow_right.png"));
	    			xPos = 300;
	    			break;
	    		default:
	    			System.out.println("error");
	    	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		timer = new Timer(100, this);
		timer.setInitialDelay(5);
		timer.start();
		
		this.setSize(100, 100);
		this.setVisible(true);
		this.setLocation(xPos, initialYposition);
		this.setEnabled(true);
	}
	
	public void setYpos(int decrease){
		this.setLocation(getLocation().x, getLocation().y-decrease);
	}
	
	public int getYpos(){
		return this.getY();
	}
		
	public void setFocusParameters(){
		this.setRequestFocusEnabled(true);
		this.setFocusable(true);
		this.addKeyListener(this);
		this.requestFocus();
		this.requestFocusInWindow();
	}
	
	public void paint(Graphics g) {
		if(this.getY()<600 && this.getY()> -100)
			g.drawImage(arrowImage, 0, 0, null);
		this.requestFocus(); //this is a terrible way of getting focus
//		System.out.println(getY());
//		super.paint(g); //WTF?
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				if(getLocation().y<100){
					score += 100-Math.abs(getLocation().y);
					this.arrowImage = null;
				}
				else
					score += -10;
				System.out.println("Trykker venstre!");
				System.out.println(score);
				System.out.println("DU TRYKKA SÅ LANGT UNNA PERFEKT: " + getY());
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
//		this.removeKeyListener(this); //remove listening to this object
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
		this.setLocation(getLocation().x, getLocation().y-10);
		if(getLocation().y<-100){
//			this.removeKeyListener(this); //remove listening to this object
			this.remove(this);
		}
	}
 }

