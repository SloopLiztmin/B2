package gameWindow;

public class Collision extends Thread{

	
	public void run() {

		for(int i = 0; i < GameWindow.objList.size() - 1; i++) {
			for(int b = i + 1; b < GameWindow.objList.size(); b++) {

				System.out.println(GameWindow.objList.get(i) + " " + GameWindow.objList.get(b));


		}
	}

	}
}
