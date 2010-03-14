import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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
			
			List<Float> peaks = new Threshold().getPeaks();
			
			JLayeredPane panel = new JLayeredPane();
			panel.setFocusable(false);			
			
			System.out.println("HER SKAL DET KOMME UT NOE BRAAA:");
			for( int i = 0; i < peaks.size() - 1; i++ ){
//		    	System.out.println(peaks.get(i));
				if(peaks.get(i)>50){
//					System.out.println(i);
//					System.out.println(peaks.get(i));
					float f = peaks.get(i);
					panel.add(new Arrow((int)f%4, i*3));
				}
			}
			System.out.println("PEAKS SIZE I RUNNER: " + peaks.size());
				
			
//			JButton knapp = new JButton("DETTE ER EN SABLA BRA KNAPP");
//			knapp.setSize(300, 20);
//			knapp.setLocation(400, 400);
//			
			LoadMP3 load = new LoadMP3();
			load.setLocation(600,100);
			load.setSize(100,20);
//			
//			panel.add(load);
//			panel.add(knapp);
			panel.setSize(800, 600);
//			panel.add(right);
//			panel.add(left);
//			panel.add(up);
//			panel.add(down);
			
			gui.getContentPane().add(panel);

//			left.revalidate();
//			up.revalidate();
//			down.revalidate();
//			right.revalidate();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
