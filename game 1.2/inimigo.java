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
    private int vida = 15;
    private int velocidade = 1;
    private boolean olhandoDireita = true;
    /**
     * Act - do whatever the inimigo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public inimigo() {
        GreenfootImage img = getImage();
        img.scale(115, 115);
        setImage(img);
    }
    public void act()
    {
        if (getWorld() == null) {
            return;   
        }

        List<heroi> herois = getWorld().getObjects(heroi.class);
        if (herois.isEmpty()) {
            return;    
        }

        heroi alvo = herois.get(0);

        turnTowards(alvo.getX(), alvo.getY());   // vira na direção do herói
        move(velocidade);                        // dá um passo nessa direção
        setRotation(0);                          // deixa a imagem em pé

        if (alvo.getX() > getX()) {
            olhar(true);
        } else if (alvo.getX() < getX()) {
            olhar(false);
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
