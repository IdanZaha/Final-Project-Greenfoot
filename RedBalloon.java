import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RedBalloon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedBalloon extends Actor
{
    private boolean moveLeft = true;
    /**
     * Act - do whatever the RedBalloon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        balloonIsMoving();
    } 
    /**
     * balloonIsMoving is the method used for checking wich button is clicked and then changing the speed setting of the balloons.
     * 
     * @params - there are no parameters.
     * @returns - there are no return types.
     */    private void balloonIsMoving()
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
        setLocation(getX()+Speed,getY());
        if(getX() >= 695)
        {
            setLocation(10, getY());
        }
    }
}
