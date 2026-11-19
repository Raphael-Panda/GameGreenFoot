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
    private int vida = 2000;
    private int vidaMax = 2000;
    private int contato = 0;
    private int speed = 3;
    private int cooldownTiro = 0;
    private int intervaloTiro = 20;
    private int tempoDash = 0;
    private int cooldownDash = 0;
    private int dirX = 0, dirY = 0;
    private int velocidadeDash = 8;
    private int mouseX, mouseY;
    private GreenfootSound somTiro = new GreenfootSound("tiroefeito.wav");
    public heroi() {
            GreenfootImage img = getImage();
            img.scale(145, 155);
            setImage(img);
    }
    public int getVida(){ 
        return vida;
    }    
    public int getVidaMax(){ 
        return vidaMax;
    }    
    private void verificarMorte(){
        if(vida <= 0){
            vida = 0;
            World mundo = getWorld();
            mundo.showText("VOCÊ FOI MASSACRADO PELAS CRIATURAS", 
                           mundo.getWidth() / 2, mundo.getHeight() / 2);
            Greenfoot.stop();
        }
    }
    public void receberDano(int dano){
        vida -= dano;
        verificarMorte();
    }
    public void receberDanoContato(int dano){
        if(contato > 0) return;
        
        vida -= dano;
        contato = 30;
        verificarMorte();
    }
    public void act()
    {
        if(contato > 0) contato--;
        
        if(cooldownDash > 0) cooldownDash--;
        
        mover();
        atirar();
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
            somTiro.play();
            somTiro.setVolume(70);
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