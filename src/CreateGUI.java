import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CreateGUI extends Thread implements KeyListener {
	
	private JFrame frame;
	private JPanel panel;
	
	public JFrame getFrame(){
		return frame;
	}
	public JPanel getPanel(){
		return panel;
	
	frame = new JFrame(gConf);
	frame.setFocusableWindowState(true);
	frame.setFocusable(true);
	frame.setSize(1024,768);
	frame.requestFocus();
	frame.addKeyListener(this);
	frame.setUndecorated(true);
	frame.setIgnoreRepaint(true);
	frame.setBackground(Color.WHITE);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel = new JPanel();
	frame.add(panel);
	}
	
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_DOWN:
			break;
		case KeyEvent.VK_UP:
			break;
		case KeyEvent.VK_LEFT:
			break;
		case KeyEvent.VK_RIGHT:
			break;
		case KeyEvent.VK_Q:
			break;
		case KeyEvent.VK_H:
			break;
		}
		
			
	}
	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

}