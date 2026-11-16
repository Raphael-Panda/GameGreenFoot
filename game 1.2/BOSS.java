import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BOSS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BOSS extends inimigo
{
    /**
     * Act - do whatever the BOSS wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int vida = 600;
    public BOSS() {
            GreenfootImage img = getImage();
            img.scale(425, 405);
            setImage(img);
    }
    public void act()
    {
        
    }
}
