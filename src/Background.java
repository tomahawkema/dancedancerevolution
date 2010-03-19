import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

/**
 * 
 * Class for generating the background image.
 * 
 * @author Tor Marius Jensen
 */

public class Background extends JLayeredPane {
	
	protected Image back;
	
	/**
	 * Constructor that adds the background image to a JLayeredPane.
	 */
	public Background(){
		try {
			this.back = ImageIO.read(new File("images/back.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(800, 600);
		this.setVisible(true);
		this.setEnabled(true);
	}
	
	/**
	 * Paints the background.
	 */
	public void paint(Graphics g) {
		g.drawImage(back, 0, 0, null);
	}
	
}
