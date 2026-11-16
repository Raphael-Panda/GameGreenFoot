import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class inimigo2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class inimigo2 extends inimigo
{
    /**
     * Act - do whatever the inimigo2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int vida = 30;
    public void act()
    {
        if(isTouching(projetil.class)){
            vida -= 15;
            if(vida <= 0){
                removeTouching(inimigo.class);
            }
        }
    }
}
