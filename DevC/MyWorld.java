import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int waves = 0;
    private int spawn = 0;
    private boolean proxWave = true;
    private int[] qtdEnemy = {14, 18, 26, 30, 5};
    int waveAtual = qtdEnemy[waves - 1];
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        
        super(1200, 900, 1);
        heroi boneco = new heroi(); 
        addObject(boneco, 600, 400);
        arena bg = new arena();
        setBackground("91a2005da755e37357fa71f9354d82f2.jpg");
        inimigo cobra = new inimigo();
        addObject(cobra, Greenfoot.getRandomNumber(1200),Greenfoot.getRandomNumber(900));
    }
}
