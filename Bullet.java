import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private int speed;
    private GreenfootImage img = getImage();
    public Bullet()
    {
        img.scale(50,50);
    }

    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MyWorld world = (MyWorld) getWorld();
        speed = 8;
        setLocation(getX(),getY()-speed);
        if(getY() <= 0)
        {
            getWorld().removeObject(this);
        }
        else if(isTouching(BlueBalloon.class)==true)
        {
            removeTouching(BlueBalloon.class);
            world.update();
            //getWorld().removeObject(this);
            Greenfoot.playSound("BALLOONPOP.wav");
        }
        else if(isTouching(RedBalloon.class)==true)
        {
            removeTouching(RedBalloon.class);
            world.update();
            //getWorld().removeObject(this);
            Greenfoot.playSound("BALLOONPOP.wav");
        }
        else if(isTouching(YellowBalloon.class)==true)
        {
            removeTouching(YellowBalloon.class);
            world.update();
            //getWorld().removeObject(this);
            Greenfoot.playSound("BALLOONPOP.wav");
        }
    }
}
