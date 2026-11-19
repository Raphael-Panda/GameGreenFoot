import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class inimigo4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class inimigo4 extends inimigo
{
    /**
     * Act - do whatever the inimigo4 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public inimigo4(){
        vida = 45;
        vidaMax = 45;
        intervaloTiro = 210;
        setImage(new GreenfootImage("inimigo4.png"));
        GreenfootImage img = getImage();
        img.scale(220,220);
        setImage(img);
    }
    
    @Override
    protected projetil_inimigo criarProjetil(){
        return new projetil_inimigo4();
    }
}
