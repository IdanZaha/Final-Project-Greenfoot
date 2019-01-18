import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Medium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Medium extends Actor
{
    /**
     * Act - do whatever the Medium wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        clickDetection();
    }
        /**
     * clickDetection is the method used for checking if the Medium button has been clicked and if it has it starts the game as "Medium" mode.
     * 
     * @params - there are no parameters.
     * @returns - there are no return types.
     */
        private void clickDetection()
    {
        if(Greenfoot.mouseClicked(this))
        {
            ((MyWorld)getWorld()).start("Medium");
        }
    }
}

