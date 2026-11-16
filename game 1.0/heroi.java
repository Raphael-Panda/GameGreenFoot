import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class heroi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class heroi extends Actor
{
    /**
     * Act - do whatever the heroi wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean olhandoDireita = true;
    int vida = 350;
    int speed = 3;    
    public heroi() {
            GreenfootImage img = getImage();
            img.scale(145, 155);
            setImage(img);
    }
    public void act()
    {        
        mover();
        if(Greenfoot.isKeyDown("space")){
            move(10);
        }
        if(isTouching(projetil_inimigo.class)){
            vida -= 15;
        }
    }
    public void mover(){
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY());
            olhar(false);
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());
            olhar(true);
        }
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
        }        
    }
    private void olhar(boolean direita)
    {
        if (direita != olhandoDireita) {
            getImage().mirrorHorizontally();
            olhandoDireita = direita;
        }
    }
}