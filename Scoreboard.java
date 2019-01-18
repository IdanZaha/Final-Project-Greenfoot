import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Scoreboard extends Actor
{
    public int points; // Edits the point amount on the scoreboard.
    private Font myFont = new Font("Comic Sans MS", true, false, 24); // This is the font of the text.

    /**
     * This is the setup of the scoreboard.
     * 
     * @params - there are no parameters.
     * @returns - there are no return types.
     */
    public Scoreboard()
    {
        points = 0; 
        GreenfootImage img = new GreenfootImage(150,30); 
        img.setFont( myFont ); 
        img.setColor(Color.WHITE);
        img.drawString("Balloons: " + points, 5,25); 
        setImage(img); 
    }

    /**
     * addToScore updates the score of the scoreboard when a the bullet hits the balloon.
     * 
     * @params - there are no parameters
     * @returns - there are no return types
     */
    public void addToScore() 
    {
        points++; 
        GreenfootImage img = getImage(); 
        img.clear(); 
        img.drawString("Balloons: " + points, 5,25);
    }    
}
