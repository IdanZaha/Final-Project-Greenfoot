import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hard extends Actor
{
    /**
     * Act - do whatever the Hard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        clickDetection();
    }
        /**
     * clickDetection is the method used for checking if the Hard button has been clicked and if it has it starts the game as "Hard" mode.
     * 
     * @params - there are no parameters.
     * @returns - there are no return types.
     */
        private void clickDetection()
    {
        if(Greenfoot.mouseClicked(this))
        {
            ((MyWorld)getWorld()).start("Hard");
        }
    }
}

