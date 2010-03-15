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
	public int pub_dir = -1;
	protected int scalingFactor = 17;
	//protected Timer timer;

	public enum Direction{
		LEFT, UP, DOWN, RIGHT
	}
			
	public Arrow(int dir, int initialYposition) throws InterruptedException{
		pub_dir = dir;
		this.addKeyListener(this);
		this.score = 0;		
		try {
			switch(dir){
	    		case 0:
	    			arrowImage =ImageIO.read(new File("images/arrow_left_trans.png"));
	    			xPos = 0;
	    			break;
	    		case 1:
	    			arrowImage =ImageIO.read(new File("images/arrow_up_trans.png"));
	    			xPos = 100;
	    			break;
	    		case 2:
	    			arrowImage =ImageIO.read(new File("images/arrow_down_trans.png"));
	    			xPos = 200;
	    			break;
	    		case 3:
	    			arrowImage =ImageIO.read(new File("images/arrow_right_trans.png"));
	    			xPos = 300;
	    			break;
	    		default:
	    			System.out.println("error");
	    	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		timer = new Timer(70, this);
		timer.setInitialDelay(initialYposition*scalingFactor);
		timer.start();
		
		this.setSize(100, 100);
		this.setVisible(true);
		this.setEnabled(true);
		this.setLocation(xPos, 700); //her skal det stå initialYposition
	}
	
//	public void setYpos(int decrease){
//		this.setLocation(getLocation().x, getLocation().y-decrease);
//		System.out.println("HVA FAEN?");
//		if(this.getLocation().y < 100 && getLocation().y > -100)
//			System.out.println("hei du");
//			this.requestFocus(); //this is a terrible way of getting focus
//	}
		
	public void setFocusParameters(){
		this.setRequestFocusEnabled(true);
		this.setFocusable(true);
		this.addKeyListener(this);
		this.requestFocus();
		this.requestFocusInWindow();
	}
	
	public void paint(Graphics g) {
		if(this.getLocation().y < 600 && this.getLocation().y > -100)
			g.drawImage(arrowImage, 0, 0, null);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(this.getLocation().y < 600 && getLocation().y > -100){
			switch(e.getKeyCode()){
				case KeyEvent.VK_LEFT:
					if(pub_dir == 0){
						System.out.println("RIKTIG venstre!");
						this.arrowImage = null;
					}
					else{
						System.out.println("FEIL venstre");
					}
					this.removeKeyListener(this);
					break;
				case KeyEvent.VK_UP:
					if(pub_dir == 1){
						System.out.println("RIKTIG opp");
						this.arrowImage = null;
					}
					else{
						System.out.println("FEIL opp");
					}
					this.removeKeyListener(this);
					break;
				case KeyEvent.VK_DOWN:
					if(pub_dir == 2){
						System.out.println("RIKTIG ned");
						this.arrowImage = null;
					}
					else{
						System.out.println("FEIL ned");
					}
					this.removeKeyListener(this);
					break;
				case KeyEvent.VK_RIGHT:
					if(pub_dir == 3){
						System.out.println("RIKTIG høyre");
						this.arrowImage = null;
					}
					else{
						System.out.println("FEIL høyre");
					}
					this.removeKeyListener(this);
					break;
			}
			 //remove listening to this object
		}
		else{
			System.out.println("INGENTING!");
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
		this.setLocation(getLocation().x, getLocation().y-2);
		if(getLocation().y<-100){
			this.timer.stop();
			this.removeKeyListener(this); //remove listening to this object
		}
		else if(getLocation().y<100)
			this.requestFocus(); //this is not a good way to obtain focus for an object
		
	}
 }

