package fft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Simple example that shows how to decode an mp3 file.
 * 
 * @author mzechner and Tor Marius Jensen
 *
 */
public class MP3Output extends Thread
{
	private String filename;
	
	public MP3Output(String filename) throws Exception{	
		this.filename = filename;
	}

	public void run() {
		AudioDevice device = null;
		MP3Decoder decoder = null;
		try {
			device = new AudioDevice( );
			decoder = new MP3Decoder( new FileInputStream( filename ) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		float[] samples = new float[1024];
		
		while( decoder.readSamples( samples ) > 0 ){
			device.writeSamples( samples );
		}
	}
}
