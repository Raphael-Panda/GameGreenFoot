import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bcomojogar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bcomojogar extends botao
{
    /**
     * Act - do whatever the Bcomojogar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    protected void acao(){
        Greenfoot.setWorld(new comojogar());
    }
    public Bcomojogar(){
        super("COMO JOGAR", 240, 55);
    }
}
