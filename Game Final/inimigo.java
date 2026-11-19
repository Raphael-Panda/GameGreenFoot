import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class inimigo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class inimigo extends Actor
{
    protected int vida = 15;
    protected int vidaMax = 15;
    protected int danoContato = 5;
    protected int intervaloTiro = 240;
    protected int cooldownTiro;
    protected int velocidade = 1;
    protected boolean olhandoDireita = true;
    /**
     * Act - do whatever the inimigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    @Override
    protected void addedToWorld(World mundo){
        cooldownTiro = Greenfoot.getRandomNumber(intervaloTiro);
        criarBarra(mundo);
    }
    protected void criarBarra(World mundo){
        int deslocamento = -getImage().getHeight() / 2 - 8;
        mundo.addObject(new BarraVida(this, 60, 6, true, deslocamento, null), getX(), getY() + deslocamento);
    }
    public inimigo() {
        GreenfootImage img = getImage();
        img.scale(115, 115);
        setImage(img);
    }
    public void act()
    {
        if(getWorld() == null) return;
        
        List<heroi> herois = getWorld().getObjects(heroi.class);
        if(herois.isEmpty()) return; 
        heroi alvo = herois.get(0);
        
        turnTowards(alvo.getX(), alvo.getY());
        move(velocidade);
        setRotation(0);
        if(alvo.getX() > getX()) olhar(true);
        else if(alvo.getX() < getX()) olhar(false);
        
        if(isTouching(heroi.class)){
            alvo.receberDanoContato(danoContato);
        }
        
        if(cooldownTiro > 0){
            cooldownTiro--;
        } else{
            atirar(alvo);
            cooldownTiro = intervaloTiro;
        }
        
        if (getWorld() == null) {
            return;   
        }

        
        if (herois.isEmpty()) {
            return;    
        }
        turnTowards(alvo.getX(), alvo.getY());   
        move(velocidade);                        
        setRotation(0);                          

        if (alvo.getX() > getX()) {
            olhar(true);
        } else if (alvo.getX() < getX()) {
            olhar(false);
        }
    }
    protected projetil_inimigo criarProjetil(){
        return new projetil_inimigo();
    }
    
    private void atirar(heroi alvo){
        projetil_inimigo p = criarProjetil();
        getWorld().addObject(p, getX(), getY());
        p.turnTowards(alvo.getX(), getY());
    }

    public void receberDano(int dano){
        vida -= dano;
        if(vida <= 0 && getWorld() != null) {
            getWorld().removeObject(this);
        }
    }
    public int getVida(){
        return vida;
    }
    public int getVidaMax(){
        return vidaMax;
    }
    private void olhar(boolean direita)
    {
        if (direita != olhandoDireita) {
            getImage().mirrorHorizontally();
            olhandoDireita = direita;
        }
    }  
}
