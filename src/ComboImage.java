import java.awt.Graphics;
import java.awt.Image;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLayeredPane;

public class ComboImage extends JLayeredPane{
	
	protected Image current;
	protected Image perfect;
	protected Image sick;
	protected Image insane;
	
	public ComboImage() throws IOException{
		current = null;
		insane = ImageIO.read(new File("images/201b.png"));
		sick = ImageIO.read(new File("images/sick.png"));
		perfect = ImageIO.read(new File("images/perfect.png"));
		
		this.setFocusable(false);
		this.setSize(800, 600);
		this.setVisible(true);
		this.setEnabled(true);
		this.setLocation(440, 450);
	}
	
	public int getComboFromFile(int fjas){
		return fjas;
	}

	public void paint(Graphics g) {
		if(CreateGUI.score.getCombo()>19)
			g.drawImage(insane, 0, 0, null);
		else if(CreateGUI.score.getCombo()>9)
			g.drawImage(sick, 0, 0, null);
		else if(CreateGUI.score.getCombo()>-1)
			g.drawImage(perfect, 0, 0, null);
		g.drawImage(null, 0, 0, null);
	}
}
