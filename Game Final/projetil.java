import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class projetil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class projetil extends Actor
{
    /**
     * Act - do whatever the projetil wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int velocidade = 4;
    private int dano = 15;
    public projetil() {
            GreenfootImage img = getImage();
            img.scale(175, 130);
            setImage(img);
    }
    public void act()
    {
        move(velocidade);
        inimigo inimigoTocado = (inimigo) getOneIntersectingObject(inimigo.class);
        if(inimigoTocado != null){
            inimigoTocado.receberDano(dano);
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
