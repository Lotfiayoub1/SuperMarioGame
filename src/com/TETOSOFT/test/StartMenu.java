package com.TETOSOFT.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import com.TETOSOFT.graphics.ScreenManager;
import com.TETOSOFT.input.GameAction;
import com.TETOSOFT.input.InputManager;
import com.TETOSOFT.tilegame.GameEngine;
import com.TETOSOFT.tilegame.MapLoader;

public class StartMenu extends GameCore {
	
	private InputManager inputManager;
	private GameAction exit;
	private GameAction player1;
	private GameAction player2;
	private GameAction player3;
	private GameAction player4;
	private boolean isWaiting;


	
	   public static void main(String[] args) 
	    {
	        new StartMenu().run();
	    }
	   
	   
	  public StartMenu() {
	   	
	  } 
	  
	  public StartMenu(ScreenManager screen) {
	    	this.screen = screen;
	  }

	
	 public void run()
	    {
		 
		 	if(screen==null) {
		 		super.init();
		 	}
	        
	        // set up input manager
	        initInput();
	        
	        isWaiting = true;
			
			Graphics2D g = screen.getGraphics();

			draw(g);
			
			while (isWaiting) {
				checkInput();
			}

	        
	
	   }
	 
	  private void initInput() {

  		exit = new GameAction("exit", GameAction.DETECT_INITAL_PRESS_ONLY);
  		player1 = new GameAction("exit", GameAction.DETECT_INITAL_PRESS_ONLY);
  		player2 = new GameAction("exit", GameAction.DETECT_INITAL_PRESS_ONLY);
  		player3 = new GameAction("exit", GameAction.DETECT_INITAL_PRESS_ONLY);
  		player4 = new GameAction("exit", GameAction.DETECT_INITAL_PRESS_ONLY);

  		inputManager = new InputManager(screen.getFullScreenWindow());
  		inputManager.setCursor(InputManager.INVISIBLE_CURSOR);

  		inputManager.mapToKey(exit, KeyEvent.VK_ESCAPE);
  		inputManager.mapToKey(player1, KeyEvent.VK_A);
  		inputManager.mapToKey(player2, KeyEvent.VK_B);
  		inputManager.mapToKey(player3, KeyEvent.VK_C);
  		inputManager.mapToKey(player4, KeyEvent.VK_D);

  	}


	  private void checkInput() {

			if (exit.isPressed()) {
				isWaiting = false;
				stop();
			}
			
			if (player1.isPressed()) {
				isWaiting = false;
				MapLoader.setPlayerChoice(1);
				new GameEngine(screen).run();
			}
			
			if (player2.isPressed()) {
				isWaiting = false;
				MapLoader.setPlayerChoice(2);
				new GameEngine(screen).run();
			}
			
			if (player3.isPressed()) {
				isWaiting = false;
				MapLoader.setPlayerChoice(3);
				new GameEngine(screen).run();
			}
			
			if (player4.isPressed()) {
				isWaiting = false;
				MapLoader.setPlayerChoice(4);
				new GameEngine(screen).run();
			}

		}
	 
	 public void draw(Graphics2D g) {

			int screenHeight = screen.getHeight();
			int screenWidth = screen.getWidth();
			
			
			// draw black background
			g.setColor(Color.black);
			g.fillRect(0, 0, screenWidth, screenHeight);
			g.setColor(Color.YELLOW);
			g.drawString("CHOOSE YOUR AVATAR", screenWidth/3+60, 100);
			g.setColor(Color.WHITE);
			g.drawString("Press ESC for EXIT.", screenWidth/3+60, screenHeight - 100);
			g.drawImage(new ImageIcon("images/player11.png").getImage(),screenWidth/5, 200 , null);
			g.setColor(Color.GREEN);
			g.drawString("Press A", screenWidth/5,300);
			g.drawImage(new ImageIcon("images/megaman.png").getImage(),2*screenWidth/5, 200 , null);
			g.setColor(Color.GREEN);
			g.drawString("Press B", 2*screenWidth/5,300);
			g.drawImage(new ImageIcon("images/zelda.png").getImage(),3*screenWidth/5, 200 , null);
			g.setColor(Color.GREEN);
			g.drawString("Press C", 3*screenWidth/5,300);
			g.drawImage(new ImageIcon("images/player.png").getImage(),4*screenWidth/5, 200 , null);
			g.setColor(Color.GREEN);
			g.drawString("Press D", 4*screenWidth/5,300);
			
			screen.update();

		}

}
