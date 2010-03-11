import javax.swing.JButton;
import javax.swing.JLayeredPane;


public class Runner extends Thread {

	public static void main(String[] args) {
		(new Thread(new Runner())).start();
	}

	public void run(){
		try {
			CreateGUI gui = new CreateGUI();
			gui.setFocusable(false);
			
			Arrow left = new Arrow(Arrow.Direction.LEFT);
			Arrow up = new Arrow(Arrow.Direction.UP);
			Arrow down = new Arrow(Arrow.Direction.DOWN);
			Arrow right = new Arrow(Arrow.Direction.RIGHT);

			JLayeredPane panel = new JLayeredPane();
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
