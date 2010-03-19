import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JLayeredPane;
/**
 * The class that starts the program. This also listen to key inputs from user and responds to that.
 * Creates the panel where the initial widgets are being added.
 * 
 * @see <a href="http://code.google.com/p/dancedancerevolution/source/checkout">Dance Dance Revolution - 201B edition</a>
 * 
 * @author Tor Marius Jensen
 */
public class Runner extends Thread implements KeyListener, ActionListener{

	/**
	 * Executing the program.
	 * @param args
	 */
	public static void main(String[] args) {
		(new Thread(new Runner())).start();
	}
	
	public static CreateGUI gui;
	public static JLayeredPane panel;

	/**
	 * Initializing the static variable gui and sets its properties and also adding the static variable
	 * panel and adding its initial widgets. Adding keylistener as well. 
	 */
	public void run(){
		try {
			gui = new CreateGUI();
			gui.setFocusable(false);
			
			panel = new JLayeredPane();
			panel.setFocusable(true);
			panel.requestFocus();
			panel.setSize(800, 600);
			
			LoadMP3 load = new LoadMP3();
			load.setLocation(500,260);
			load.setSize(200,20);
			
			panel.add(new Background(), new Integer(-1));
			panel.add(load);
			panel.addKeyListener(this);
		
			load.revalidate();
			gui.getContentPane().add(panel);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the panel.
	 * @return the panel where other components can be added in addition
	 */
	public static JLayeredPane getPanel(){
		return panel;
	}
	
	/**
	 * Listening to the keys being pressed. Depending on the key that's pressed, different actions
	 * will take place.
	 */
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				int a = CreateGUI.arrowlistener.findArrow(0); //checks if a arrow of this type is present at the top of the screen
				if(a != -1){
					CreateGUI.score.setScore(100); //if arrow is present: add 100 to score
					CreateGUI.arrowlistener.removeArrow(a); //remove arrow from arrowlist
					CreateGUI.score.setCombo(CreateGUI.score.getCombo()+1); //add 1 to the combo
				}
				else{
					CreateGUI.score.setCombo(0); //if arrow isn't present: setting combo to 0
					CreateGUI.score.setScore(-20); // subtract 20 from the score
				}
				break;
			
			case KeyEvent.VK_UP:
				int b = CreateGUI.arrowlistener.findArrow(1);
				if(b != -1){
					CreateGUI.score.setScore(100);
					CreateGUI.arrowlistener.removeArrow(b);
					CreateGUI.score.setCombo(CreateGUI.score.getCombo()+1);
				}
				else{
					CreateGUI.score.setCombo(0);
					CreateGUI.score.setScore(-20);
				}
				break;
					
			case KeyEvent.VK_DOWN:
				int c = CreateGUI.arrowlistener.findArrow(2);
				if(c != -1){
					CreateGUI.score.setScore(100);
					CreateGUI.arrowlistener.removeArrow(c);
					CreateGUI.score.setCombo(CreateGUI.score.getCombo()+1);
				}
				else{
					CreateGUI.score.setCombo(0);
					CreateGUI.score.setScore(-20);
				}
				break;
			
			case KeyEvent.VK_RIGHT:
				int d = CreateGUI.arrowlistener.findArrow(3);
				if(d != -1){
					CreateGUI.score.setScore(100);
					CreateGUI.arrowlistener.removeArrow(d);
					CreateGUI.score.setCombo(CreateGUI.score.getCombo()+1);
				}
				else{
					CreateGUI.score.setCombo(0);
					CreateGUI.score.setScore(-20);
				}
				break;
		}
	}
		
	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}
	
	public void actionPerformed(ActionEvent e) {
	}
}
