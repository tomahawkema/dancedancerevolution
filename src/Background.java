import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;
import javax.swing.Timer;


public class Background extends JLayeredPane {
	
	protected Image back;
	
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
	
	public void paint(Graphics g) {
		g.drawImage(back, 0, 0, null);
	}
	
}
