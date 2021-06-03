package com.TETOSOFT.tilegame.sprites;

import com.TETOSOFT.graphics.Animation;
import com.TETOSOFT.tilegame.MapLoader;

/**
    A Grub is a Creature that moves slowly on the ground.
*/
public class Grub extends Creature {

    public Grub(Animation left, Animation right,
        Animation deadLeft, Animation deadRight)
    {
        super(left, right, deadLeft, deadRight);
    }


    public float getMaxSpeed() {
    	switch(MapLoader.currentMap)
    	{
    		case 1:
    			return 0.05f;
    		case 2:
    			return 0.05f;
    		case 3:
    			return 0.07f;
    		case 4:
    			return 0.09f;
    			
    	}
        return 0.05f;
    }

}
