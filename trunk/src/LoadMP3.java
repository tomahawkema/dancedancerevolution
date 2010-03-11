import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.*;

public class LoadMP3 extends JPanel implements ActionListener {
   
	static private final String newline = "\n";
    JButton openButton;
    JTextArea log;
    JFileChooser fc;

    public LoadMP3() {
        super(new BorderLayout());
      
        fc = new JFileChooser();

        //Uncomment one of the following lines to try a different
        //file selection mode.  The first allows just directories
        //to be selected (and, at least in the Java look and feel,
        //shown).  The second allows both files and directories
        //to be selected.  If you leave these lines commented out,
        //then the default mode (FILES_ONLY) will be used.
        //
        //fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        //fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

      
        openButton = new JButton("Find mp3...");
        openButton.addActionListener(this);


        //For layout purposes, put the buttons in a separate panel
        JPanel buttonPanel = new JPanel(); //use FlowLayout
        buttonPanel.add(openButton);

        //Add the buttons and the log to this panel.
        add(buttonPanel, BorderLayout.PAGE_START);
     
    }

    public void actionPerformed(ActionEvent e) {

        //Handle open button action.
        if (e.getSource() == openButton) {
            int returnVal = fc.showOpenDialog(LoadMP3.this);
        }
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = LoadMP3.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FileChooserDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new LoadMP3());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //Turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE); 
                createAndShowGUI();
            }
        });
    }
}
