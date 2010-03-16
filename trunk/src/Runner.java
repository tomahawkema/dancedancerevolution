import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

public class Runner extends Thread implements KeyListener, ActionListener{

	public static void main(String[] args) {
		(new Thread(new Runner())).start();
	}
	
	public static CreateGUI gui;
	public static JLayeredPane panel;
	protected Image perfect;
	protected Image sick;
	protected Image insane;
	protected Image current;
	
	
	
	public void run(){
		try {
			perfect = ImageIO.read(new File("images/perfect.png"));
			sick = ImageIO.read(new File("images/sick.png"));
			insane = ImageIO.read(new File("images/201b.png"));
			
			gui = new CreateGUI();
			gui.setFocusable(false);
			
			panel = new JLayeredPane();
			panel.setFocusable(true);
			panel.requestFocus();
			panel.setSize(800, 600);
			
			LoadMP3 load = new LoadMP3();
			load.setLocation(500,260);
			load.setSize(200,20);
//			load.revalidate();
			
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
					CreateGUI.score.setCombo(CreateGUI.score.getCombo()+6);
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
					CreateGUI.score.setCombo(CreateGUI.score.getCombo()+6);
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
					CreateGUI.score.setCombo(CreateGUI.score.getCombo()+6);
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
					CreateGUI.score.setCombo(CreateGUI.score.getCombo()+6);
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
	
	public void paint(Graphics g) {
		if(CreateGUI.score.getCombo()>20)
			g.drawImage(perfect, 0, 0, null);
		else if(CreateGUI.score.getCombo()>10)
			g.drawImage(sick, 0, 0, null);
		else if(CreateGUI.score.getCombo()>5)
			g.drawImage(insane, 0, 0, null);
		else
			g.drawImage(insane, 0, 0, null);
	}
}
