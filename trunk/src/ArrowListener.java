import java.util.ArrayList;
import java.util.List;

public class ArrowListener{

	public List<Integer> arrowList = new ArrayList<Integer>();

	public void addArrow(int direction){
		arrowList.add(direction);
	}
	
	public void removeArrow(int direction){
		arrowList.remove(direction);
	}
	
	public int findArrow(int direction){
		for(int i=0;i<arrowList.size();i++)
			if(arrowList.get(i) == direction)
				return i;
		return -1;
	}
	
}
