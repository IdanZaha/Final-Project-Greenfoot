import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlueBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueBalloon extends Actor

{
    private boolean moveLeft = false;

    /**
     * Act - do whatever the BlueBalloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        balloonIsMoving();
    }

    private void balloonIsMoving()
    {
        int Speed = 0;
        if(((MyWorld)getWorld()).getDifficulty().equalsIgnoreCase("Easy"))
        {
            Speed = 32;
        }
        else if(((MyWorld)getWorld()).getDifficulty().equalsIgnoreCase("Medium"))
        {
            Speed = 16;
        }
        else if(((MyWorld)getWorld()).getDifficulty().equalsIgnoreCase("Hard"))
        {
            Speed = 8;
        }
        if(moveLeft == true)
        {
            setLocation(getX()-Speed, getY());
        }
        else
        {
            setLocation(getX()+Speed, getY());
        }
        if(moveLeft == false && getX() >= 690)
        {
            moveLeft = true;
        }
        if(moveLeft == true && getX() <= 10)
        {
            moveLeft = false;
        }
    }
}
