
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;

public class Arrow extends JLayeredPane{
	private Image arrowImage;

	//private final Direction direction;

	public enum Direction {LEFT, UP, DOWN, RIGHT} 
	
	public Arrow(){
		try {
			arrowImage =ImageIO.read(new File("images/arrow_down.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setSize(100, 50);
		this.setVisible(true);
		this.setLocation(0, 0);
		this.repaint();
	}
	public void setYpos(int posY){
		this.setLocation(0, posY);
	}
	
	public void paint(Graphics g) {
		g.drawImage(arrowImage, 0,0,100,100,null);
	}
 }

