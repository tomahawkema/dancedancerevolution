import javax.swing.JButton;
import javax.swing.JLayeredPane;

public class Runner extends Thread {

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
			panel.setFocusable(false);			
			
			JButton knapp = new JButton("DETTE ER EN SABLA BRA KNAPP");
			knapp.setSize(300, 20);
			knapp.setLocation(400, 400);
			knapp.setVisible(true);
			knapp.requestFocus();
			knapp.revalidate();
//			
			LoadMP3 load = new LoadMP3();
			load.setLocation(600,100);
			load.setSize(100,20);
			
			panel.add(load);
			panel.add(knapp);
			panel.setSize(800, 600);
//			panel.add(right);
//			panel.add(left);
//			panel.add(up);
//			panel.add(down);
			
			gui.getContentPane().add(panel);
			knapp.revalidate();
			load.revalidate();
			
//			left.revalidate();
//			up.revalidate();
//			down.revalidate();
//			right.revalidate();
			
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static JLayeredPane getPanel(){
		return panel;
	}
}
