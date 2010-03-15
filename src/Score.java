
public class Score extends Runner{

	public static int score;
	
	int setScore(int s){
		score += s;
		return 0;
	}
	
	public int getScore(){
		return score;
	}
	
	public void run(){
		while(true){
			getScore();
		}
	}
}
