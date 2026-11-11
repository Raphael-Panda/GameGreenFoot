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
    public void act()
    {
        int vida = 350;
        int speed = 3;
        if (Greenfoot.isKeyDown("left")) {
        move(speed);
        setRotation(180);
        }
    
        if (Greenfoot.isKeyDown("right")) {
        move(speed);
        setRotation(0);
        }
        
        if(Greenfoot.isKeyDown("up")){
            move(speed);
            setRotation(-90);
        }
        if(Greenfoot.isKeyDown("down")){
            move(speed);
            setRotation(90);
        }
        
        if(Greenfoot.isKeyDown("r")){
            projetil bala = new projetil();
            getWorld().addObject(bala, getX(), getY());
            bala.setRotation(this.getRotation());
        }
    }
}
