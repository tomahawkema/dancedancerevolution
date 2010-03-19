
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;



import javax.swing.JFrame;

/**
 * This class creates the JFrame and the general GUI that the different panels will be added to. 
 * In addition, a bunch of static variables are intialized here.
 * 
 * @author Tor Marius Jensen
 */
public class CreateGUI extends JFrame{
	
	private Container cp;
	public static ArrowListener arrowlistener;
	public static Score score;
	public static ComboImage combo;
	
	/**
	 * Constructor that sets the different variable for the GUI. Static variables are being initialized
	 * here as well.
	 * 
	 * @throws IOException
	 */
	public CreateGUI() throws IOException{
		this.setFocusable(false);
		this.setTitle("Dance Dance Revolution - 201B Edition");
		this.setSize(800, 600);		 	
		this.setLocation(100, 100); 	
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