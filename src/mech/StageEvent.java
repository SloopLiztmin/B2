package mech;

import java.util.Timer;
import java.util.TimerTask;

import gameWindow.Entities.BadGuy.Eye;
import gameWindow.Entities.BadGuy.Glitch;

public class StageEvent	{
	
	/**
	 * The type of entity that the event spawns.
	 */
	protected String template;
	
	
	/**
	 * The amount of entities that the event spawns.
	 */
	private int numOfEntities;
	
	
	/**
	 * The delay in milliseconds between each entity spawning.
	 */
	private long delay;
	
	protected int xLoc;
	protected int yLoc;
	
	

	
	/**
	 * Create a new stageEvent
	 * @param toSpawn The type of entity to spawn.
	 * @param numOfEntities The amount of the entity to spawn
	 * @param delay The delay between entity spawns
	 */
	
	public StageEvent(String Type, int numOfEntities, long delay, int x, int y) {
		this.template = Type;
		this.numOfEntities = numOfEntities;
		this.delay = delay;
		this.xLoc = x;
		this.yLoc = y;
		
	
	}

	
	public void start() {

		Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        	int i = 0;
        	
            @Override
            public void run() {
            	
            	if(i < numOfEntities) {
            		switch(template) {
            			case "eye":
            				new Eye(xLoc, yLoc);
            				i++;
            				break;
            			case "glitch":
                			new Glitch(xLoc, yLoc, 100, 1.2, 1.4, 0, 0);
                			i++;	
                			break;
            			default:
            				break;
            		}
            	}
            
            }
        }, this.delay, this.delay);

		
		
	}
}
