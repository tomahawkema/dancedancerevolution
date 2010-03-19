import java.awt.Graphics;
import java.awt.Image;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;

/**
 * This class paint an image depending of what your combo is. The combo increases with one every
 * time you hit an arrow in the time interval you're supposed to hit it. If you press a key when you're
 * not supposed to or an arrow leaves the screen without hitting it, the combo automatically will be
 * reset to 0.
 * 
 * @author Tor Marius Jensen
 */


public class ComboImage extends JLayeredPane{
	
	protected Image perfect;
	protected Image sick;
	protected Image insane;
	
	/**
	 * Constructor that loads the different combo-images and sets the necessary parameters of where
	 * the images possibly will be shown.
	 * 
	 * @throws IOException if image file is not found.
	 */
	public ComboImage() throws IOException{
	
		insane = ImageIO.read(new File("images/201b.png"));
		sick = ImageIO.read(new File("images/sick.png"));
		perfect = ImageIO.read(new File("images/perfect.png"));
		
		this.setFocusable(false);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setEnabled(true);
		this.setLocation(450, 450);
	}
	
	/**
	 * Paints the arrow depending on the static combo-variable. 
	 */
	public void paint(Graphics g) {
		if(CreateGUI.score.getCombo()>20)
			g.drawImage(insane, 0, 0, null);
		else if(CreateGUI.score.getCombo()>10)
			g.drawImage(sick, 0, 0, null);
		else if(CreateGUI.score.getCombo()>5)
			g.drawImage(perfect, 0, 0, null);
		g.drawImage(null, 0, 0, null);
	}
}
