import java.util.ArrayList;
import java.util.List;


/**
 * Adds arrows to a list. This class have functions to manipulate the list depending on
 * the user input.
 * 
 * @author Tor Marius Jensen
 */
public class ArrowListener{

	public List<Integer> arrowList = new ArrayList<Integer>();

	/**
	 * Adding the arrows direction to an arraylist
	 * @param direction the direction of the arrow
	 */
	public void addArrow(int direction){
		arrowList.add(direction);
	}
	
	/**
	 * Removes the arrow from the list
	 * @param direction the direction of the arrow which is to be removed
	 */
	public void removeArrow(int direction){
		arrowList.remove(direction);
	}
	
	/**
	 * Checks if the given direction is to be find in the arrowlist.
	 * 
	 * @param direction the direction of the arrow which potentially is in the arrowlist.
	 * @return the first position in the arrowlist where the arrow is found. -1 otherwise.
	 */
	public int findArrow(int direction){
		for(int i=0;i<arrowList.size();i++)
			if(arrowList.get(i) == direction)
				return i;
		return -1;
	}
	
}
