import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * Class that will filter the file types so that only mp3 is shown.
 * 
 * @author Tor Marius Jensen + example fra java.sun 
 */
public class FilterFiles extends FileFilter {

	/**
	 * Checks if file is a directory. If so, return true. Otherwise false.
	 */
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		
		String extension = Utils.getExtension(f);
		if (extension != null) {
			if (extension.equals(Utils.mp3))
				return true;
			else
			    return false;
		}
		return false;
	}

	public String getDescription() {
		return null;
	}
}
