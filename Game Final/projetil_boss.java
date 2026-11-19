import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class projetil_inimigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class projetil_boss extends projetil_inimigo
{
    /**
     * Act - do whatever the projetil_inimigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public projetil_boss() {
        dano = 15;
        velocidade = 7;
        GreenfootImage img = getImage();
        img.scale(135, 105);
        setImage(img);
    }
}
