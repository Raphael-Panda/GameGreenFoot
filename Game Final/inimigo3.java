import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class inimigo3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class inimigo3 extends inimigo
{
    /**
     * Act - do whatever the inimigo3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    @Override
    protected projetil_inimigo criarProjetil(){
        return new projetil_inimigo3();
    }
    public inimigo3() {
        vida = 30;
        vidaMax = 30;
        intervaloTiro = 180;
        setImage(new GreenfootImage("inimigo3.png"));
        GreenfootImage img = getImage();
        img.scale(290, 225);
        setImage(img);
    }
}