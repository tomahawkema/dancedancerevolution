import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Runner extends Thread implements KeyListener, ActionListener{

	public static void main(String[] args) {
		(new Thread(new Runner())).start();
	}
	
	public static CreateGUI gui;
	public static JLayeredPane panel;
	private Timer timer;
	protected Image bonusArrow = null;
	
	public void run(){
		try {
			gui = new CreateGUI();
			gui.setFocusable(false);
			
			panel = new JLayeredPane();
			panel.setFocusable(true);
			panel.requestFocus();
			
//			int score = new Score().getScore();
//			String s = Integer.toString(score);
//			JTextArea text = new JTextArea(s);
//			text.setLocation(500,200);
//			text.setSize(200,20);

			LoadMP3 load = new LoadMP3();
			load.setLocation(500,260);
			load.setSize(200,20);
			
			panel.add(new Background(), new Integer(-1));
//			panel.add(text);
			panel.add(load);
//			panel.add(knapp);
			panel.setSize(800, 600);
			panel.addKeyListener(this);

			
//			knapp.revalidate();
			load.revalidate();
//			text.revalidate();
			
			gui.getContentPane().add(panel);
		
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static JLayeredPane getPanel(){
		return panel;
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_LEFT:
				int a = CreateGUI.arrowlistener.findArrow(0);
				if(a != -1){
					timer = new Timer(10, null);
					timer.setInitialDelay(10);
					timer.start();
					CreateGUI.score.setScore(100);
					CreateGUI.arrowlistener.removeArrow(a);
				}
				break;
			
			case KeyEvent.VK_UP:
				int b = CreateGUI.arrowlistener.findArrow(1);
				if(b != -1){
					CreateGUI.score.setScore(100);
					CreateGUI.arrowlistener.removeArrow(b);
				}
				break;
					
			case KeyEvent.VK_DOWN:
				int c = CreateGUI.arrowlistener.findArrow(2);
				if(c != -1){
					CreateGUI.score.setScore(100);
					CreateGUI.arrowlistener.removeArrow(c);
				}
				CreateGUI.score.setScore(-1000);
				break;
			
			case KeyEvent.VK_RIGHT:
				int d = CreateGUI.arrowlistener.findArrow(3);
				if(d != -1){
					CreateGUI.score.setScore(100);
					CreateGUI.arrowlistener.removeArrow(d);
				}
				break;
		}
	}
		

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
