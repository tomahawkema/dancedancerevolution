import javax.swing.JLayeredPane;
import javax.swing.JTextArea;


public class Score extends Runner{

	JLayeredPane panel = new JLayeredPane();
	JTextArea text_score;
	
	public static int score = 20;
	
	public Score(){
		this.score = 0;
		this.text_score = new JTextArea(Integer.toString(score));
	
		text_score.setLocation(500,220);
		text_score.setSize(200,20);
		
		panel.setFocusable(false);
		panel.setSize(800, 600);
		panel.add(text_score);
	}
	
	public void setScore(int s){
		score += s;
		GenerateArrowPattern.text_highscore.setText("Score: " + Integer.toString(score));
	}
	
	public int getScore(){
		return score;
	}
	
	
	public void run(){
		while(true){
			this.text_score.setText(Integer.toString(score));
		}
	}
}
