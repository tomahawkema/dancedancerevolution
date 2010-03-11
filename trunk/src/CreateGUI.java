import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class CreateGUI extends JFrame implements KeyListener, ActionListener{
	
	private Container cp;
	
	public CreateGUI(){
		this.setTitle("Dance Dance Revolution - 201B Edition");
		this.setSize(800, 600);		 	// sets the size of the windows
		this.setLocation(300, 100); 	// where it appears on the screen at start-up
		this.setVisible(true);
		//this.repaint();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(false);
		//this.addKeyListener(this); denne skal være i Arrow mest sannsynlig, tror jeg
		cp = getContentPane();
		//cp.setBackground(Color.red);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		/*switch(e.getKeyCode()){
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
		}*/
	}

	@Override
	public void keyReleased(KeyEvent e) {		
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//System.out.println("balle");
	}
}