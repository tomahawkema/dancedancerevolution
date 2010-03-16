import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

public class GenerateArrowPattern extends Runner {

	private static JLayeredPane panel;
	
	public static JTextArea text_highscore;
	public static JTextArea text_combo;
	
	public GenerateArrowPattern(String filename) throws FileNotFoundException, Exception{
		List<Float> peaks = new Threshold(filename).getPeaks();
		float mean = 0;
		float numberOfPeaks = 0;
		float maxPeak = 0;
		for( int i = 1; i < peaks.size() - 1; i++ ){
			if(peaks.get(i) != 0.0){
				mean += peaks.get(i);
				numberOfPeaks++;
			}
			if(peaks.get(i) > maxPeak)
				maxPeak = peaks.get(i);
		}
		mean = mean/numberOfPeaks;
	
		float weight = 0.01f;
		mean = (maxPeak + mean)/2;
		
		int howMany = 1000;
		float temp = 0;
		
		System.out.println("NUMBEROFPEAKS: " + numberOfPeaks);
		if(numberOfPeaks > 220){
			while(howMany > 120){
				howMany = 0;
				temp = weight*(maxPeak + mean)/2.0f;
				for( int i = 1; i < peaks.size() - 1; i++ ){
					if(peaks.get(i)>temp && i > 200){
						howMany++;
					}	
				}
				weight += 0.01f;
			}
			mean = temp;
		}
		
		System.out.println("HOWMANY: " + howMany);
		
		int numberOfArrows = 0;
		for( int i = 1; i < peaks.size() - 1; i++ ){
			if(peaks.get(i)>mean && i > 200){
				numberOfArrows++;
				float f = peaks.get(i);
				Runner.getPanel().add(new Arrow((int)f%4, i), 5);
				Runner.getPanel().revalidate();
			}
		}
		
		text_highscore = new JTextArea("Good luck!");
		text_highscore.setEditable(false);
		text_highscore.setLocation(500,300);
		text_highscore.setSize(200,20);
		
		text_combo = new JTextArea("Combos");
		text_combo.setEditable(false);
		text_combo.setLocation(500,340);
		text_combo.setSize(200,20);
		
		String number = Integer.toString(numberOfArrows);
		JTextArea text_numberOfArrow = new JTextArea("Number of arrows generated: " + number);
		text_numberOfArrow.setLocation(450,400);
		text_numberOfArrow.setSize(300,20);
				
		JTextArea text_songPlaying = new JTextArea("Now playing: " + filename.substring(filename.lastIndexOf("\\")+1, filename.lastIndexOf(".")).trim());
		text_songPlaying.setLocation(450,440);
		text_songPlaying.setSize(300,20);
		
		panel = new JLayeredPane();
		panel.setFocusable(false);
		panel.setSize(800, 600);
		panel.add(text_combo);
		panel.add(text_highscore);
		panel.add(text_numberOfArrow);
		panel.add(text_songPlaying);
		
		Runner.getPanel().add(panel);
		Runner.getPanel().revalidate();
	}
}
