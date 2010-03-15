import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

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
			
//			int score = new Score().getScore();
//			String s = Integer.toString(score);
//			JTextArea text = new JTextArea(s);
//			text.setLocation(500,200);
//			text.setSize(200,20);
			
//			
		
			LoadMP3 load = new LoadMP3();
			load.setLocation(500,260);
			load.setSize(200,20);
			
			panel.add(new Background(), new Integer(-1));
//			panel.add(text);
			panel.add(load);
//			panel.add(knapp);
			panel.setSize(800, 600);

			
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
}
