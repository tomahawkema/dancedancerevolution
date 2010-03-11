import javax.swing.JButton;
import javax.swing.JLayeredPane;


public class Runner extends Thread {

	public static void main(String[] args) {
		(new Thread(new Runner())).start();
	}

	public void run(){
		try {
			CreateGUI gui = new CreateGUI();
			Arrow left = new Arrow(Arrow.Direction.LEFT);
			Arrow up = new Arrow(Arrow.Direction.UP);
			Arrow down = new Arrow(Arrow.Direction.DOWN);
			Arrow right = new Arrow(Arrow.Direction.RIGHT);
			
//			JLayeredPane panel = new JLayeredPane();
//			panel.setSize(800, 600);
//			panel.setLocation(500, 500);
//			panel.setVisible(true);
//			panel.setFocusable(true);
//			panel.setOpaque(true);
//			panel.add(right);
//			gui.getContentPane().add(panel);
//			
	
			gui.add(left);
			
			
			//gui.getContentPane().add(panel);
			
			//gui.add(panel);
			
		//	gui.add(left);
//			gui.add(up);
//			gui.add(down);
//			gui.add(right);
//			
		
			left.revalidate();
			up.revalidate();
			down.revalidate();
			right.revalidate();
		
			
//			JLayeredPane panel = new JLayeredPane();
//			panel.setSize(800, 600);
//			panel.setVisible(true); //denne har jo ikke en dritt å si tydeligvis
//			panel.setLocation(0, 0);
//			panel.add(up_arrow, 2);
//			panel.setOpaque(true);
//			panel.repaint();
//			//panel.setFocusable(false);
			
//			gui.getContentPane().add(up_arrow);
			

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
