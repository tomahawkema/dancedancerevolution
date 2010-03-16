import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.*;

import fft.AudioDevice;
import fft.MP3Decoder;
import fft.MP3Output;

public class LoadMP3 extends JPanel implements ActionListener{
   
	static private final String newline = "\n";
    JButton openButton;
    JFileChooser fc;
    String filename;

    public LoadMP3() {
        super(new BorderLayout());
      
        fc = new JFileChooser();
        fc.setFileFilter(new FilterFiles());
        openButton = new JButton("Select mp3 and Play");
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
        AudioDevice device = null;
        MP3Decoder decoder = null;
        try {
			device = new AudioDevice();
			new GenerateArrowPattern(filename);
			decoder = new MP3Decoder(new FileInputStream( filename ) );
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
		try {
			(new MP3Output(filename)).start();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }
    
    public String getFileName(){
    	return filename;
    }
}
