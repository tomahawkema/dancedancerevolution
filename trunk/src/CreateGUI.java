import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.net.URL;

import javax.swing.*;
import java.awt.*;


public class CreateGUI extends JFrame{
	
	public static void main(String[] args) throws InterruptedException{
		runThisShit();
	}
	
	public static void runThisShit() throws InterruptedException{
		CreateGUI GUI = new CreateGUI();
		GUI.setVisible(true);
		GUI.setFocusable(true);
		GUI.repaint();
		
		
		Arrow rightarrow = new Arrow();
		JLayeredPane panel = new JLayeredPane();
		panel.setSize(1000, 600);
		panel.setVisible(true);
		panel.setLocation(0, 0);
		panel.add(rightarrow);
		panel.repaint();
		GUI.getContentPane().add(panel);
		
		for(int i=0;i<100;i++){
			Thread.sleep(20);
			rightarrow.setYpos(i);
		}
	}
	
	private ImageIcon background = new ImageIcon("arrow_down.jpg");
	private Image i = background.getImage();
	private Container cp; // our contentpane

	
	public CreateGUI(){
		this.setTitle("");
		this.setSize(800, 600);
		this.setLocation(300, 100);
		this.setVisible(true);
		this.repaint();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cp = getContentPane();
		cp.setBackground(Color.black);
	}
	
	//Where the images are initialized:
	
	

}