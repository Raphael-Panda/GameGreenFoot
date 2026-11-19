import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class projetil_inimigo3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class projetil_inimigo3 extends projetil_inimigo
{
    /**
     * Act - do whatever the projetil_inimigo3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public projetil_inimigo3(){
        dano = 10;
        velocidade = 8;
        GreenfootImage img = getImage();
        img.scale(115, 70);
        setImage(img);
    }
}
