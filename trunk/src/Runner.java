
public class Runner extends Thread {

	public static void main(String[] args) {
		(new Thread(new Runner())).start();
		(new Thread(new Runner())).start();
		(new Thread(new Runner())).start();
	}

	public void run(){
		try {
			CreateGUI.createArrows(Arrow.Direction.LEFT);
			CreateGUI.createArrows(Arrow.Direction.RIGHT);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
