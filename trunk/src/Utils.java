import java.io.File;

/**
 * The class that finds the extension to a file a checks if it's an mp3 file.
 * 
 * @author Tor Marius Jensen
 */
public class Utils {

    public final static String mp3 = "mp3";

    /**  
     * Get the extension to a file.
     * @param f the file that have an extension
     * @return the extension of the file
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
}