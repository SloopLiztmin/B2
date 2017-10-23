package gameWindow.Entities;

import java.awt.Color;
import java.awt.Graphics;

import gameWindow.GameWindow;

public abstract class Entity {
	
	
	//HARMLESS is only for the player
	protected enum eTYPE{
		CRTL, HOSTILE, HARMLESS
	}
	
	protected eTYPE entityType;
	public boolean CtrlCheck(){
		if(this.entityType.equals(eTYPE.CRTL)) {
			return true;
			}return false;	
	}
	
	protected double height;
	
	protected double width;
	
	protected double hitX;
	protected double hitY;
	protected double hitR;
	
	protected int size;
	
	protected double angle;
	public double getAngle() {return this.angle;}
	
	protected double acceleration;
	public void setSpeed(double newSpeed) {this.acceleration = newSpeed;}
	public double getSpeed() {return this.acceleration;}
	
	
	protected int direction;
	public void setDirection(int i) {
		if(i <= 4&&i >= 0) {
			this.direction = i;
		}
		else {
			this.direction = 1;
		}
	}
	
	protected int Score;
	protected int Health;
	protected double xLocation;
	protected double xVelocity;
	protected double yLocation;
	protected double yVelocity;
  
	public void sudoku() {
		if(this.xLocation > 1500||this.xLocation < -220||this.yLocation > 940||this.yLocation < -220) {
			GameWindow.objList.remove(this);
		}
	}
	
	
	public double toXVelocity(double theta, double acceleration) {
		theta = Math.cos(theta);
		return(theta * acceleration);
	}
	
	public double toYVelocity(double theta, double acceleration) {
		theta = Math.sin(theta);
		return(-1 * theta * acceleration);
	}
	
	public void updateOnAngle(double angle, double acceleration) {
		this.xLocation += this.toXVelocity(angle, acceleration);
		this.yLocation += this.toYVelocity(angle, acceleration);
	}
	
	private int bombs;
	public void bombsArithmetic(int deltaValue) {this.bombs += deltaValue;}
	public int getBombs() {return this.bombs;}
	
	private int lives;
	public void setLives(int i) {this.lives = i;}
	public void livesArithmetic(int deltaValue) {this.lives += deltaValue;}
	public int getLives() {return this.lives;}
	
	protected boolean isRight;
	public void setRight(boolean input) {this.isRight = input;}
	
	protected boolean isLeft;
	public void setLeft(boolean input) {this.isLeft = input;}
	
	protected boolean isUp;
	public void setUp(boolean input) {this.isUp = input;}
	
	protected boolean isDown;
	public void setDown(boolean input) {this.isDown = input;}
	
	private boolean isFiring;
	public void setFiring(boolean input) {this.isFiring = input;}
	public boolean isFiring() {return this.isFiring;}
	
	protected boolean isFocus;
	public void setFocus(boolean input) {this.isFocus = input;}
	public boolean isFocused() {return this.isFocus;}
	
	
	public Entity(double xLocation, double yLocation, int Health, double yVelocity, double xVelocity) {
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.Health = Health;
		this.yVelocity = yVelocity;
		this.xVelocity = xVelocity;
	}
	
	public void TargetedBullet(Entity target) {
		double tempX = this.xLocation - target.xLocation;
		double tempY = this.yLocation - target.yLocation;
		
		float angleTo = (float) Math.toDegrees(Math.atan2(tempY,tempX));
		new targetedBullet(this.xLocation, this.yLocation, angleTo, 1, 5, false, Color.RED);
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics g);
}
