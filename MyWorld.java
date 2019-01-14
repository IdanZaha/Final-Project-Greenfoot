import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends greenfoot.World
{
    private long highscores[] = {0,0,0,0,0};
    private long systemTimeOffset = System.currentTimeMillis();
    private Scoreboard score = new Scoreboard();
    private boolean start = false;
    private boolean objectsAdded = false;
    private String difficulty;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(700, 700, 1);
        displayText(getBackground(),"USE LEFT AND RIGHT TO MOVE SCOPE! \n USE SPACEBAR TO SHOOT!",Color.WHITE,40, getWidth()/2, 650);
        displayText(getBackground(),"Made by Idan!",Color.RED, 50, getWidth()/2,116);
        displayText(getBackground(),"GET 25 POINTS TO WIN A PRIZE!:)",Color.GREEN,50, getWidth()/2, 575);
        Greenfoot.start();
        addObject(new Easy(),getWidth()/2, 233);
        addObject(new Medium(),getWidth()/2, getHeight()/2);
        addObject(new Hard(),getWidth()/2, 466);
        getData();
    }

    public String getDifficulty()
    {
        return difficulty;
    }

    public void act()
    {
        if(start == true)

        
        {
            if(objectsAdded == false)
            {

                setBackground("rivets.jpg");
                addObject(new BlueBalloon(),Greenfoot.getRandomNumber(700),getHeight()/2);
                addObject(new RedBalloon(),Greenfoot.getRandomNumber(700),getHeight()/2);
                addObject(new YellowBalloon(),Greenfoot.getRandomNumber(700),getHeight()/2);
                addObject(new BlueBalloon(),Greenfoot.getRandomNumber(700),getHeight()/2);
                addObject(new FairStand(),getWidth()/2,getHeight()/2);
                addObject(new Scope(),getWidth()/2,getHeight()/2);
                addObject(new YellowBalloon(),Greenfoot.getRandomNumber(700), getHeight()/2);
                addObject(new RedBalloon(), Greenfoot.getRandomNumber(700), getHeight()/2);
                addObject( score, 100, 25);
                showText(Long.toString(highscores[0]/1000)+Long.toString(highscores[1]/1000)+Long.toString(highscores[2]/1000)+Long.toString(highscores[3]/1000)+Long.toString(highscores[4]/1000),100,75);
                systemTimeOffset = System.currentTimeMillis();
                objectsAdded = true;
            }
            if(getObjects(BlueBalloon.class).size()==0)
            {
                addBlueBalloon(2);
            }
            if(getObjects(RedBalloon.class).size()==0)
            {
                addRedBalloon(2);
            }
            if(getObjects(YellowBalloon.class).size()==0)
            {
                addYellowBalloon(2);
            }
            if(score.points == 25)
            {
                removeObjects(getObjects(null));
                displayText(getBackground(),"YOU HAVE WON\n THE POP THE BALLOON GAME!\n YOU WON \nAN AWESOME PRIZE!",Color.YELLOW, 50, getWidth()/2, 600);
                Greenfoot.playSound("MONEY.wav");
                score.points++;
                timerHighscore();
                if(Greenfoot.getRandomNumber(100) < 20)
                {
                    addObject(new Five(),getWidth()/2,getHeight()/2);
                }
                else if(Greenfoot.getRandomNumber(100) < 20)                
                {
                    addObject(new Ten(),getWidth()/2,getHeight()/2);
                }
                else if(Greenfoot.getRandomNumber(100) < 20)
                {
                    addObject(new Twenty(),getWidth()/2,getHeight()/2);
                }
                else if(Greenfoot.getRandomNumber(100) < 20)
                {
                    addObject(new Fifty(),getWidth()/2,getHeight()/2);
                }
                else
                {
                    addObject(new OneHundred(),getWidth()/2,getHeight()/2);
                }
                Greenfoot.delay(500);
                Greenfoot.setWorld(new MyWorld());
            }
        }   
    }

    private void displayText(GreenfootImage background, String display, Color color, int size, int x, int y)
    {
        GreenfootImage imgScore = new GreenfootImage(display,size, color, new Color(0,0,0,0));
        x = x - imgScore.getWidth()/2;
        y = y - imgScore.getHeight()/2;
        background.drawImage(imgScore, x, y);
        setBackground(background);
    }

    public void update()
    {
        score.addToScore();
    }

    public void addBlueBalloon(int a)
    {
        for(int f=0; f<a; f++) 
        {
            int x = Greenfoot.getRandomNumber(700); 
            int y = getHeight()/2;
            addObject(new BlueBalloon(), x, y); 
        }
    }

    public void addRedBalloon(int c)
    {
        for(int f=0; f<c; f++)
        {
            int x2 = Greenfoot.getRandomNumber(700);
            int y2 = getHeight()/2;
            addObject(new RedBalloon(), x2, y2);
        }
    }

    public void addYellowBalloon(int e)
    {
        for(int f=0; f<e; f++)
        {
            int x4 = Greenfoot.getRandomNumber(700);
            int y4 = getHeight()/2;
            addObject(new YellowBalloon(), x4, y4);
        }
    }

    public void start(String d)
    {
        start = true;
        difficulty = d;
        removeObjects(getObjects(null));
    }

    public void timerHighscore()
    {
        long time = System.currentTimeMillis()-systemTimeOffset;
        if(time > highscores[0])
        {
            highscores[4] = highscores[3];
            highscores[3] = highscores[2];
            highscores[2] = highscores[1];
            highscores[1] = highscores[0];
            highscores[0] = time;
        }
        else if(time > highscores[1])
        {
            highscores[4] = highscores[3];
            highscores[3] = highscores[2];
            highscores[2] = highscores[1];
            highscores[1] = time;
        }
        else if( time > highscores[2])
        {
            highscores[4] = highscores[3];
            highscores[3] = highscores[2];
            highscores[2] = time;
        }
        else if(time > highscores[3])
        {
            highscores[4] = highscores[3];
            highscores[3] = time;
        }
        else if(time > highscores[4])
        { 
            highscores[4] = time;
        }
        try
        {
            FileWriter writer = null;
            writer = new FileWriter("game.txt");
            writer.write(Long.toString(highscores[0]));
            writer.write(System.getProperty("line.separator"));
            writer.write(Long.toString(highscores[1]));
            writer.write(System.getProperty("line.separator"));
            writer.write(Long.toString(highscores[2]));
            writer.write(System.getProperty("line.separator"));
            writer.write(Long.toString(highscores[3]));
            writer.write(System.getProperty("line.separator"));
            writer.write(Long.toString(highscores[4]));
            writer.write(System.getProperty("line.separator"));
            writer.close();
        }
        catch( IOException e )
        {
            e.printStackTrace();    
        }
    }
    private void getData()
    {
        FileInputStream fis;
        BufferedReader r = null;
        try
        {
            fis = new FileInputStream("game.txt");
            r = new BufferedReader(new InputStreamReader(fis));
            String line;
            highscores[0] = Long.parseLong(r.readLine());
            highscores[1] = Long.parseLong(r.readLine());
            highscores[2] = Long.parseLong(r.readLine());
            highscores[3] = Long.parseLong(r.readLine());
            highscores[4] = Long.parseLong(r.readLine());
        }
        catch(FileNotFoundException e1)
        {
            e1.printStackTrace();
        }
        catch( IOException e2)
        {
            e2.printStackTrace();
        }
    }
}