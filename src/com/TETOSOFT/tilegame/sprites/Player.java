package com.TETOSOFT.tilegame.sprites;

import com.TETOSOFT.graphics.Animation;
import com.TETOSOFT.tilegame.MapLoader;

/**
    The Player.
*/
public class Player extends Creature 
{

    private static final float JUMP_SPEED = -.95f;

    private boolean onGround;

    public Player(Animation left, Animation right, Animation deadLeft, Animation deadRight)
    {
        super(left, right, deadLeft, deadRight);
    }


    public void collideHorizontal() {
        setVelocityX(0);
    }


    public void collideVertical() {
        // check if collided with ground
        if (getVelocityY() > 0) {
            onGround = true;
        }
        setVelocityY(0);
    }


    public void setY(float y) {
        // check if falling
        if (Math.round(y) > Math.round(getY())) {
            onGround = false;
        }
        super.setY(y);
    }


    public void wakeUp() {
        // do nothing
    }


    /**
        Makes the player jump if the player is on the ground or
        if forceJump is true.
    */
    public void jump(boolean forceJump) {
        if (onGround || forceJump) {
            onGround = false;
            setVelocityY(JUMP_SPEED);
        }
    }


    public float getMaxSpeed() {
    	switch(MapLoader.currentMap)
    	{
    		case 1:
    			return 0.5f;
    		case 2:
    			return 1.0f;
    		case 3:
    			return 1.25f;
    		case 4:
    			return 1.5f;
    			
    	}
        return 0.5f;
    }

}
