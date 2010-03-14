import java.io.FileNotFoundException;
import java.util.List;


public class GenerateArrowPattern extends Runner {

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
		System.out.println("MAXPEAK is: " + maxPeak);
		System.out.println("MEAN is: " + mean);
		
		
		float weight = 0.01f;
		mean = (maxPeak + mean)/2;
		
		int howMany = 100;
		float temp = 0;
		
		System.out.println("NUMBEROFPEAKS: " + numberOfPeaks);
		if(numberOfPeaks > 80){
			while(howMany > 80){
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
			if(peaks.get(i)>mean && i > 200){ //her skal jeg bestemme hvor mange piler som kommer. det er passe random
				numberOfArrows++;
				float f = peaks.get(i);
				Runner.getPanel().add(new Arrow((int)f%4, i*3));
				Runner.getPanel().revalidate();
			}
		}
		System.out.println(numberOfArrows);
	}
}
