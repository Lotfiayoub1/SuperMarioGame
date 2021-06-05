package com.TETOSOFT.test;

import static org.junit.jupiter.api.Assertions.*;
import junit.framework.*;

import org.junit.jupiter.api.Test;

import com.TETOSOFT.graphics.Animation;
import com.TETOSOFT.tilegame.GameEngine;
import com.TETOSOFT.tilegame.MapLoader;
import com.TETOSOFT.tilegame.sprites.Creature;
import com.TETOSOFT.tilegame.sprites.Player;

public class Speed extends GameEngine {
	
	float max_speed;
	Creature player = (Creature)getMap().getPlayer();

	public void testSpeed() throws Exception {
		new GameEngine().run();
		switch(MapLoader.currentMap)
    	{
    		case 1:
    			max_speed = 0.5f;
    		case 2:
    			max_speed = 1.0f;
    		case 3:
    			max_speed = 1.25f;
    		case 4:
    			max_speed = 1.5f;
    			
    	}
	    assertEquals(player.getMaxSpeed(),max_speed);
	  }
	}