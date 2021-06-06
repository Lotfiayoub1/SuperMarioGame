package com.TETOSOFT.test;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import com.TETOSOFT.graphics.ScreenManager;
import com.TETOSOFT.input.GameAction;
import com.TETOSOFT.input.InputManager;
import com.TETOSOFT.tilegame.GameEngine;

public class EndMenu extends GameCore {

	private InputManager inputManager;
	private boolean isWaiting;
	private GameAction exit;
	private GameAction restart;
	private GameAction change;
	private GameEngine game;

	public EndMenu(int collectedStars, ScreenManager screen) {
		this.collectedStars = collectedStars;
		this.screen = screen;
		// set up input manager
		initInput();
	}

	public void run() {

		isWaiting = true;

		Graphics2D g = screen.getGraphics();

		draw(g);

		while (isWaiting) {
			checkInput();
		}

	}

	private void initInput() {

		exit = new GameAction("exit", GameAction.DETECT_INITAL_PRESS_ONLY);
		restart = new GameAction("restart", GameAction.DETECT_INITAL_PRESS_ONLY);
		change = new GameAction("restart", GameAction.DETECT_INITAL_PRESS_ONLY);

		inputManager = new InputManager(screen.getFullScreenWindow());
		inputManager.setCursor(InputManager.INVISIBLE_CURSOR);

		inputManager.mapToKey(exit, KeyEvent.VK_ESCAPE);
		inputManager.mapToKey(restart, KeyEvent.VK_R);
		inputManager.mapToKey(change, KeyEvent.VK_C);

	}

	private void checkInput() {

		if (exit.isPressed()) {
			isWaiting = false;
			stop();
		}

		if (restart.isPressed()) {
			isWaiting = false;
			game = new GameEngine(screen);
			game.run();
		}

		if (change.isPressed()) {
			isWaiting = false;
			new StartMenu(screen).run();
		}
	}

	public void draw(Graphics2D g) {

		int screenHeight = screen.getHeight();
		int screenWidth = screen.getWidth();
		// draw black background
		g.setColor(Color.black);
		g.fillRect(0, 0, screenWidth, screenHeight);
		g.setColor(Color.WHITE);
		g.drawString("Press ESC for EXIT.", 50.0f, screenHeight - 100);
		g.setColor(Color.YELLOW);
		g.drawString("Coins: " + collectedStars, screenWidth / 2, screenHeight / 2);
		g.setColor(Color.GREEN);
		g.drawString("Press C to change avatar.", 2 * screenWidth / 5 + 10, screenHeight - 100);
		g.setColor(Color.BLUE);
		g.drawString("Press R to restart.", 4 * screenWidth / 5, screenHeight - 100);

		screen.update();

	}

	public GameAction getExit() {
		return exit;
	}

	public GameAction getRestart() {
		return restart;
	}

	public GameEngine getGame() {
		return game;
	}

	public boolean isWaiting() {
		return isWaiting;
	}

	public GameAction getChange() {
		return change;
	}

}
