import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class CreateGUI extends JFrame implements KeyListener, ActionListener{
	
	private Container cp;
	
	public CreateGUI(){
		this.setTitle("Dance Dance Revolution - 201B Edition");
		this.setSize(800, 600);
		this.setLocation(300, 100);
		this.setVisible(true);
		this.repaint();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusableWindowState(true);
		this.setFocusable(true);
		this.addKeyListener(this);
		cp = getContentPane();
		cp.setBackground(Color.white);
	}
	
	static CreateGUI GUI = new CreateGUI();
	
	public static void createArrows(Arrow.Direction dir) throws InterruptedException{
		Arrow rightarrow = new Arrow(dir);
		JLayeredPane panel = new JLayeredPane();
		panel.setSize(800, 600);
		panel.setVisible(true);
		panel.setLocation(0, 0);
		panel.add(rightarrow);
		panel.setFocusable(true);
		GUI.getContentPane().add(panel);
		
		for(int i=600;i>-100;i--){
			Thread.sleep(2);
			rightarrow.setYpos(i);
		}	
	}
	
	public static void main(String[] args) throws InterruptedException{
		createArrows(Arrow.Direction.DOWN);
		createArrows(Arrow.Direction.UP);
		createArrows(Arrow.Direction.LEFT);
		createArrows(Arrow.Direction.RIGHT);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				System.out.println("Trykker venstre!");
				break;
			case KeyEvent.VK_UP:
				System.out.println("Trykker høyre!");
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("Trykker ned!");
				break;
			case KeyEvent.VK_RIGHT:
				System.out.println("Trykker opp!");
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}