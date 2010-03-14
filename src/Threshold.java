
import java.awt.Color;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import fft.FFT;
import fft.MP3Decoder;
import fft.PlaybackVisualizer;
import fft.Plot;

public class Threshold 
{
   private String filename;	
   public static final int THRESHOLD_WINDOW_SIZE = 10;
   public static final float MULTIPLIER = 1.5f;
   static List<Float> peaks = new ArrayList<Float>( ); //denne er nå plutselig public
   
   public Threshold(String filename) throws FileNotFoundException, Exception{
	  this.filename = filename;
	  MP3Decoder decoder = new MP3Decoder( new FileInputStream( filename ) );							
      FFT fft = new FFT( 1024, 44100 );
      fft.window( FFT.HAMMING );
      float[] samples = new float[1024];
      float[] spectrum = new float[1024 / 2 + 1];
      float[] lastSpectrum = new float[1024 / 2 + 1];
      
      List<Float> spectralFlux = new ArrayList<Float>( );
      List<Float> threshold = new ArrayList<Float>( );
      List<Float> prunnedSpectralFlux = new ArrayList<Float>( );
      //peaks stod her
 
      while( decoder.readSamples( samples ) > 0 )
      {			
         fft.forward( samples );
         System.arraycopy( spectrum, 0, lastSpectrum, 0, spectrum.length ); 
         System.arraycopy( fft.getSpectrum(), 0, spectrum, 0, spectrum.length );
 
         float flux = 0;
         for( int i = 0; i < spectrum.length; i++ )	
         {
            float value = (spectrum[i] - lastSpectrum[i]);
            flux += value < 0? 0: value;
         }
         spectralFlux.add( flux );					
      }		
 
      for( int i = 0; i < spectralFlux.size(); i++ )
      {
         int start = Math.max( 0, i - THRESHOLD_WINDOW_SIZE );
         int end = Math.min( spectralFlux.size() - 1, i + THRESHOLD_WINDOW_SIZE );
         float mean = 0;
         for( int j = start; j <= end; j++ )
            mean += spectralFlux.get(j);
         mean /= (end - start);
         threshold.add( mean * MULTIPLIER );
      }
      
      for( int i = 0; i < threshold.size(); i++ )
      {
         if( threshold.get(i) <= spectralFlux.get(i) )
            prunnedSpectralFlux.add( spectralFlux.get(i) - threshold.get(i) );
         else
            prunnedSpectralFlux.add( (float)0 );
      }
      
      for( int i = 0; i < prunnedSpectralFlux.size() - 1; i++ )
      {
         if( prunnedSpectralFlux.get(i) > prunnedSpectralFlux.get(i+1) )
            peaks.add( prunnedSpectralFlux.get(i) );
         else
            peaks.add( (float)0 );
         System.out.println("PEAKS FRA THRESHOLD: " + peaks.get(i));
      }
      System.out.println("PEAKS SIZE I RUNNER: " + peaks.size());
   
//      Plot plot = new Plot( "Spectral Flux", 1024, 512 );
//      plot.plot( spectralFlux, 1, Color.red );		
//      plot.plot( threshold, 1, Color.green ) ;
      
//      for( int i = 0; i < prunnedSpectralFlux.size() - 1; i++ )
//    	  System.out.println(peaks.get(i));
      
//      plot.plot( prunnedSpectralFlux, 1, Color.blue );
//      plot.plot( peaks, 1, Color.yellow );
//      new PlaybackVisualizer( plot, 1024, new MP3Decoder( new FileInputStream( FILE ) ) );
   }
   
   public static List<Float> getPeaks(){
	   return peaks;	   
   }
}