import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scope here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scope extends Actor
{
    private int shotDelay = 80;
    private int shotDelayCount = 0;
    /**
     * Act - do whatever the Scope wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("left")==true)    
        {
            move(-5);
        }
        if(Greenfoot.isKeyDown("right")==true)
        {
            move(5);
        }
        shotSniper();
        
    }
    /**
     * shotSniper is the method for checking if the spacebar is clicked and also delaying the bullet, when the spacebar is clicked the bullet shoots.
     * 
     * @params - there are no parameters.
     * @returns - there are no return types.
     */
        public void shotSniper()
    {
        
        if(Greenfoot.isKeyDown("space") && shotDelayCount == shotDelay)
        {
            getWorld().addObject(new Bullet(), getX(), getY() +700);
            shotDelayCount = 0;
        }
        if(shotDelayCount != shotDelay)
        {
            shotDelayCount++;
        }
    }
}
