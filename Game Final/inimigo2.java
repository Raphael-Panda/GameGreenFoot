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
    public inimigo2(){
        vida = 30;
        vidaMax = 30;
        intervaloTiro = 180;
        olhandoDireita  = true;
        velocidade = 1;
    }
    
    @Override
    protected projetil_inimigo criarProjetil(){
        return new projetil_inimigo2();
    }
}
