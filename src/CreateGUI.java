
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;



import javax.swing.JFrame;

public class CreateGUI extends JFrame{
	
	private Container cp;
	public static ArrowListener arrowlistener;
	public static Score score;
	public static ComboImage combo;
		
	public CreateGUI() throws IOException{
		this.setFocusable(false);
		this.setTitle("Dance Dance Revolution - 201B Edition");
		this.setSize(800, 600);		 	// sets the size of the windows
		this.setLocation(100, 100); 	// where it appears on the screen at start-up
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		cp = getContentPane();
		cp.setBackground(Color.black);
		arrowlistener = new ArrowListener();
		score = new Score();
		combo = new ComboImage();
	}
}