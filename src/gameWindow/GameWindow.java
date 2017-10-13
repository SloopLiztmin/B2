package gameWindow;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import gameWindow.Entities.Entity;
import gameWindow.Entities.Player;
import mech.gameCalculate;
import render.gameRender;

public class GameWindow extends JFrame implements Runnable, KeyListener {

	private static final long serialVersionUID = 1L;
	public JFrame mainWindow;
	public static JPanel drawBoard;
	boolean running; 
	public static BufferedImage image;
	public static Graphics2D g;
	public static Player character;
	public static ArrayList<Entity> objList;
	
	private void createAndShowGUI() {
		mainWindow = new JFrame();
		mainWindow.setSize(1280, 720);
		mainWindow.setVisible(true);
		
		drawBoard = new JPanel();
		drawBoard.setSize(1280, 720);
		character = new Player(200,200,0,0,0);
		mainWindow.add(drawBoard);
		drawBoard.setVisible(true);
		
		mainWindow.addKeyListener(this);
		mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainWindow.setFocusable(true);
		mainWindow.requestFocus();
		mainWindow.setVisible(true);
	}
	
	private void ini_Systems() {
		objList = new ArrayList<Entity>();
		objList.add(new Player(100, 100));
		objList.add(new Player(200, 200));
	}
	
	public void keyPressed(KeyEvent Key) {
		int keyCode = Key.getKeyCode();
			if(keyCode == KeyEvent.VK_LEFT){
				for(int i = 0; i < objList.size(); i++) {
					if(objList.get(i).CtrlCheck()) {
						objList.get(i).setLeft(true);
					}
				}
			}
			if(keyCode == KeyEvent.VK_RIGHT) {
				for(int i = 0; i < objList.size(); i++) {
					if(objList.get(i).CtrlCheck()) {
						objList.get(i).setRight(true);
					}
				}
			}
			if(keyCode == KeyEvent.VK_UP){
				for(int i = 0; i < objList.size(); i++) {
					if(objList.get(i).CtrlCheck()) {
						objList.get(i).setUp(true);
					}
				}
			}
			if(keyCode == KeyEvent.VK_DOWN){
				for(int i = 0; i < objList.size(); i++) {
					if(objList.get(i).CtrlCheck()) {
						objList.get(i).setDown(true);
					}
				}
			}
			if(keyCode == KeyEvent.VK_SHIFT){
				character.setFocus(true);
			}
			if(keyCode == KeyEvent.VK_Z){
				character.setFiring(true);
			}
	}

	@Override
	
	public void keyReleased(KeyEvent Key) {
		int keyCode = Key.getKeyCode();
		if(keyCode == KeyEvent.VK_LEFT){
			for(int i = 0; i < objList.size(); i++) {
				if(objList.get(i).CtrlCheck()) {
					objList.get(i).setLeft(false);
				}
			}
		}
		if(keyCode == KeyEvent.VK_RIGHT){
			for(int i = 0; i < objList.size(); i++) {
				if(objList.get(i).CtrlCheck()) {
					objList.get(i).setRight(false);
				}
			}
		}
		if(keyCode == KeyEvent.VK_UP){
			for(int i = 0; i < objList.size(); i++) {
				if(objList.get(i).CtrlCheck()) {
					objList.get(i).setUp(false);
				}
			}
		}
		if(keyCode == KeyEvent.VK_DOWN){
			for(int i = 0; i < objList.size(); i++) {
				if(objList.get(i).CtrlCheck()) {
					objList.get(i).setDown(false);
				}
			}
		}
		if(keyCode == KeyEvent.VK_SHIFT){
			character.setFocus(false);
		}
		if(keyCode == KeyEvent.VK_Z){
			character.setFiring(false);
		}
		
	}
	
	public void run() {
		boolean running = true;
		
		ini_Systems();
		
		while(running) {
			gameCalculate.update();
			gameRender.update();
		}
	}
	
	public GameWindow() {
		createAndShowGUI();
		this.run();
	}
	
	
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
}
