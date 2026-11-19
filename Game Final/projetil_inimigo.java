import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class projetil_inimigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class projetil_inimigo extends Actor
{
    /**
     * Act - do whatever the projetil_inimigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int dano = 10;
    protected int velocidade = 7;
    public projetil_inimigo(){
        GreenfootImage img = getImage();
        img.scale(50, 50);
        setImage(img);
    }
    public void act()
    {
        move(velocidade);
        heroi alvo = (heroi) getOneIntersectingObject(heroi.class);
        if( alvo != null){
            alvo.receberDano(dano);
            getWorld().removeObject(this);
            return;
        }
        if(getX() <= 0 || getX() >= getWorld().getWidth() - 1 ){
            getWorld().removeObject(this);
            return;
        }
        if(getY() <= 0 || getY() >= getWorld().getHeight() - 1){
            getWorld().removeObject(this);
            return;
        }
    }
}
