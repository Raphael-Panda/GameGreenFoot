import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 900, 1);
        heroi boneco = new heroi(); 
        addObject(boneco, 600, 400);
        arena bg = new arena();
        setBackground("91a2005da755e37357fa71f9354d82f2.jpg");
        inimigo cobra = new inimigo();
        addObject(cobra, Greenfoot.getRandomNumber(1200),Greenfoot.getRandomNumber(900));
        
    }
}
