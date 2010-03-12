import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

import fft.AudioDevice;
import fft.MP3Decoder;

public class LoadMP3 extends JPanel implements ActionListener {
   
	static private final String newline = "\n";
    JButton openButton;
    JFileChooser fc;
    String filename;

    public LoadMP3() {
        super(new BorderLayout());
      
        fc = new JFileChooser();
        openButton = new JButton("Find mp3...");
        openButton.addActionListener(this);

        JLayeredPane mp3panel = new JLayeredPane(); //use FlowLayout
        mp3panel.add(openButton);

        add(openButton);
    }

    public void actionPerformed(ActionEvent e) {
        int returnVal = fc.showOpenDialog(LoadMP3.this);
        File file = fc.getSelectedFile();
        try {
			filename = fc.getCurrentDirectory().getCanonicalPath();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        filename = filename + "\\" + file.getName();
        System.out.println(filename);
        AudioDevice device = null;
        MP3Decoder decoder = null;
        try {
			device = new AudioDevice();
			decoder = new MP3Decoder(new FileInputStream( filename /*"mp3s/jazz.mp3"*/ ) );
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		float[] samples = new float[1024];
		
		while( decoder.readSamples( samples ) > 0 )
		{
			device.writeSamples( samples );
		}
    }
    
    public String getFileName(){
    	return filename;
    }
}
