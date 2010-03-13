import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import ddf.minim.*;
import ddf.minim.analysis.*;

public class Runner extends Thread {

	public static void main(String[] args) {
		(new Thread(new Runner())).start();
	}
	
	public void run(){
		try {
			CreateGUI gui = new CreateGUI();
			gui.setFocusable(false);
			
			Arrow left = new Arrow(Arrow.Direction.LEFT);
			Thread.sleep(2000);
			Arrow up = new Arrow(Arrow.Direction.UP);
			Thread.sleep(2000);
			Arrow down = new Arrow(Arrow.Direction.DOWN);
			Thread.sleep(2000);
			Arrow right = new Arrow(Arrow.Direction.RIGHT);

	
			JButton knapp = new JButton("DETTE ER EN SABLA BRA KNAPP");
			knapp.setSize(300, 20);
			knapp.setLocation(400, 400);
			
			LoadMP3 load = new LoadMP3();
			load.setLocation(600,100);
			load.setSize(100,20);
			
			JLayeredPane panel = new JLayeredPane();
			panel.setFocusable(false);
			panel.add(load);
			panel.add(knapp);
			panel.setSize(800, 600);
			panel.add(right);
			panel.add(left);
			panel.add(up);
			panel.add(down);
			
			gui.getContentPane().add(panel);

			left.revalidate();
			up.revalidate();
			down.revalidate();
			right.revalidate();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
