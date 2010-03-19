import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

/**
 * This class generates an arrow pattern from the loaded mp3. 
 * @author tormariu
 */

/**
 * Generates an arrow pattern from a loaded mp3. This is being called static, so once the mp3 is loaded,
 * text areas with information about score, combo and the song being played are also added.
 * 
 * @author Tor Marius Jensen
 */
public class GenerateArrowPattern extends Runner {

	private static JLayeredPane panel;
	public static JTextArea text_highscore;
	public static JTextArea text_combo;
	
	/**
	 * Constructur that generates the arrows from the mp3-file and adds the to the panel.
	 * 
	 * @param filename the name of the mp3-file
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	public GenerateArrowPattern(String filename) throws FileNotFoundException, Exception{
		List<Float> peaks = new Threshold(filename).getPeaks(); //imports all the samples from the threshold function
		float mean = 0;
		float numberOfPeaks = 0;
		float maxPeak = 0;
		//adds every peak that is not 0 to the peaks list.
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
		mean = (maxPeak + mean)/2; //initializes a temporary mean
		
		int howMany = 1000;
		float temp = 0;
		
		/*This is not a very good way to determine how many arrow that will be generated, but for
		 * now this is how it's done. I should rather pass a variable in the constructor that is
		 * either easy, medium or hard, and then have a loop generating the number of arrow from that.
		 * In addition to such a variable, the length of the song should also be taken in
		 * consideration. A song of 30 seconds should not have as many arrow as a song of 3 minutes. 
		 */
		if(numberOfPeaks > 200){
			while(howMany > 200){ // upper limit for number of arrows
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
		
		//Adding each arrow to the panel made in Runner, together with counting the number of arrows.
		int numberOfArrows = 0;
		for( int i = 1; i < peaks.size() - 1; i++ ){
			if(peaks.get(i)>mean && i > 200){
				numberOfArrows++;
				float f = peaks.get(i);
				Runner.getPanel().add(new Arrow((int)f%4, i), 5); //adding to different position with modulo
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
		
		/////////////////////////////////////////	
		//////////////////OBS!///////////////////
		/////////////////////////////////////////
		
		//Haven't added the opportunity for not having the absolute path in others os's then windows
		
		if (System.getProperty("os.name").toLowerCase().matches("(?i).*windows.*"))
			filename = filename.substring(filename.lastIndexOf("\\")+1, filename.lastIndexOf(".")).trim();
		
		JTextArea text_songPlaying = new JTextArea("Now playing: " + filename);
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
