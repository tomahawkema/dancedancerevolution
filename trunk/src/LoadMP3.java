import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import fft.MP3Output;

/**
 * This class creates the add-mp3 button and calls GenerateArrowPattern and MP3Output once called.
 * 
 * 
 * @author Tor Marius Jensen and Damien Di Fede
 */

public class LoadMP3 extends JPanel implements ActionListener{
   
    JButton openButton;
    JFileChooser fc;
    String filename;

    /**
     * Constructor creates the "select mp3 and play" button and adds actionlistern to it. 
     */
    public LoadMP3() {
        super(new BorderLayout());
      
        fc = new JFileChooser();
        fc.setFileFilter(new FilterFiles());
        openButton = new JButton("Select mp3 and Play");
        openButton.addActionListener(this);

        JLayeredPane mp3panel = new JLayeredPane();
        mp3panel.add(openButton);

        add(openButton);
    }

    /**
     * Action performed as a result of the output from the chosen mp3. Calling GenerateArrowPattern
     * to generate a pattern from the mp3. It also invokes a new thread so that the music, generated
     * by MP3output, can be played as painting of arrow and listing to keys are being done.
     * 
     * Haven't taken care of the situation where the player opens the filechooser, but cancels his/her
     * action. Should also add a flag that makes it impossible to start the filechooser once you've
     * loaded a song.
     */
    public void actionPerformed(ActionEvent e) {
    	int returnVal = fc.showOpenDialog(LoadMP3.this);
        File file = fc.getSelectedFile();
        try {
			filename = fc.getCurrentDirectory().getCanonicalPath();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
        filename = filename + "\\" + file.getName();
        try {
			new GenerateArrowPattern(filename);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
		try {
			(new MP3Output(filename)).start(); //multithreading 
		} catch (Exception e1) {
			e1.printStackTrace();
		}
    }
    
    /**
     * Return the filename of the mp3.
     * @return the filename of the mp3
     */
    public String getFileName(){
    	return filename;
    }
}
