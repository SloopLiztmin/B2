package gameWindow;

public class Collision extends Thread{
	private int start;
	private int end;


	public Collision(int START, int END){
		this.start = START;
		this.end = END;
	}

	public void run() {
		for(int i = this.start; i < this.end; i++) {
			if(!GameWindow.notBullets.get(i).isBullet()){
				for(int b = i + 1; b < this.end; b++) {
					//System.out.println(GameWindow.objList.get(i) + " " + GameWindow.objList.get(b));
					if(GameWindow.notBullets.get(i).getDistance(GameWindow.notBullets.get(b)) < GameWindow.notBullets.get(i).getR() + GameWindow.notBullets.get(b).getR()) {
						System.out.println( i + " and " + b);
						if(GameWindow.notBullets.get(b).isBullet()) {
							
						}
					}
				}
			}
		}
	}
}
