import java.io.FileNotFoundException;
import java.util.List;


public class GenerateArrowPattern extends Runner {

	public GenerateArrowPattern(String filename) throws FileNotFoundException, Exception{
		List<Float> peaks = new Threshold(filename).getPeaks();
		System.out.println("KOMMER DU HIT KJÆRE COMPILER?");
		System.out.println(peaks.size());
		System.out.println(peaks.get(2));
		for( int i = 0; i < peaks.size() - 1; i++ ){
			if(peaks.get(i)>5){ //her skal jeg bestemme hvor mange piler som kommer. det er passe random
				float f = peaks.get(i);
				Runner.getPanel().add(new Arrow((int)f%4, i*3));
				Runner.getPanel().revalidate();
			}
		}
	}
}
