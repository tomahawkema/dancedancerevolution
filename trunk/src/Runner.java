import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JLayeredPane;

public class Runner extends Thread implements KeyListener, ActionListener{

	public static void main(String[] args) {
		(new Thread(new Runner())).start();
	}
	
	public static CreateGUI gui;
	public static JLayeredPane panel;

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
	public static JLayeredPane getPanel(){
		return panel;
	}
	

	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				int a = CreateGUI.arrowlistener.findArrow(0);
				if(a != -1){
					CreateGUI.score.setScore(100);
					CreateGUI.arrowlistener.removeArrow(a);
					CreateGUI.score.setCombo(CreateGUI.score.getCombo()+1);
				}
				else{
					CreateGUI.score.setCombo(0);
					CreateGUI.score.setScore(-20);
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
