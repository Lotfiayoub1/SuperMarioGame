package com.TETOSOFT.tilegame.sprites;

import com.TETOSOFT.graphics.Animation;
import com.TETOSOFT.tilegame.MapLoader;

/**
    A Fly is a Creature that fly slowly in the air.
*/
public class Fly extends Creature {

    public Fly(Animation left, Animation right,
        Animation deadLeft, Animation deadRight)
    {
        super(left, right, deadLeft, deadRight);
    }


    public float getMaxSpeed() {
    	switch(MapLoader.currentMap)
    	{
    		case 1:
    			return 0.2f;
    		case 2:
    			return 0.2f;
    		case 3:
    			return 0.3f;
    		case 4:
    			return 0.4f;
    			
    	}
        return 0.2f;
    }


    public boolean isFlying() {
        return isAlive();
    }

}
