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
    private int cooldownTiro = 0;
    private int intervaloTiro = 30;
    private int tempoDash = 0;
    private int cooldownDash = 0;
    private int dirX = 0, dirY = 0;
    private int velocidadeDash = 8;
    private int mouseX, mouseY;
    public heroi() {
            GreenfootImage img = getImage();
            img.scale(145, 155);
            setImage(img);
    }
    public void act()
    {
        if(cooldownDash > 0){
            cooldownDash--;
        }
        mover();
        atirar();
        if(isTouching(projetil_inimigo.class)){
            vida -= 15;
        }
    }
    public void atirar(){
        if(cooldownTiro > 0){
            cooldownTiro--;
        }
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            mouseX = mouse.getX();
            mouseY = mouse.getY(); 
        }
        if(Greenfoot.isKeyDown("r") && cooldownTiro == 0){
            projetil bala = new projetil();
            getWorld().addObject(bala, getX(), getY());
            bala.turnTowards(mouseX, mouseY);
            cooldownTiro = intervaloTiro; 
        }
    }
    public void mover(){
        dirX = 0;
        dirY = 0;
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY());
            olhar(false);
            dirX = -1;
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());
            olhar(true);
            dirX = 1;
        }
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed);
            dirY = -1;
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
            dirY = 1;
        }
        
        if(Greenfoot.isKeyDown("space") && cooldownDash == 0 && tempoDash == 0){
            cooldownDash = 100;
            tempoDash = 10;
        }
        if(dirX == 0 && dirY == 0){
            if(olhandoDireita){
                dirX = 1;
            }else{
                dirX = -1;
            }   
        }
        if(tempoDash > 0){
            tempoDash -= 1;
            setLocation(getX() + dirX * velocidadeDash, getY() + dirY * velocidadeDash);
            return;
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