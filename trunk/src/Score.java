import java.io.IOException;

import javax.swing.JLayeredPane;
import javax.swing.JTextArea;

/**
 * Class for the score and combo calculations. Two static variables holds these values. 
 * 
 * @author Tor Marius Jensen
 */

public class Score{

	JLayeredPane panel = new JLayeredPane();
	JTextArea text_score;
	
	public static int combo;
	public static int score;
	
	/**
	 * Constructor to initialize the score and the combo to 0 and adding the textarea with
	 * the score to a panel to further be added on the main gui.
	 */
	public Score(){
		this.score = 0;
		this.combo = 0;
		this.text_score = new JTextArea(Integer.toString(score));
	
		text_score.setLocation(500,340);
		text_score.setSize(200,20);
		
		panel.setFocusable(false);
		panel.setSize(800, 600);
		panel.add(text_score);
	}
	
	/**
	 * Adding a value to the score and updating the score in the textarea on the screen. 
	 * @param s the value added to the score
	 */
	public void setScore(int s){
		score += s;
		GenerateArrowPattern.text_highscore.setText("Score: " + Integer.toString(score));
	}
	
	
	/**
	 * Return the current score
	 * @return the score
	 */
	public int getScore(){
		return score;
	}
	
	
	
	/**
	 * Sets the combo score and updates the combo-pciture in the lower right corner.
	 * @param c the number of combos right now
	 */
	public void setCombo(int c){
		combo = c;
		GenerateArrowPattern.text_combo.setText("Combo: " + Integer.toString(combo));
		Runner.getPanel().add(CreateGUI.combo, new Integer(400));

		/*The use of the name CreatGUI.combo is not good. This refers to the image that's being painted
		 * and not an int or an other data type.
		 */
	}
	
	/**
	 * Returns the curren combo.
	 * @return the combo score
	 */
	public int getCombo(){
		return combo;
	}
}
