import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class comojogar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class comojogar extends World
{

    /**
     * Constructor for objects of class comojogar.
     * 
     */
    public void started() { 
        Musica.tocarMenu(); 
    }      
    public void stopped() { 
        Musica.pararTudo(); 
    }
    public comojogar()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1300, 690, 1);
        setBackground("comoJogar.png");
        GreenfootImage fundo = getBackground(); 
        Musica.tocarMenu();
        fundo.setColor(Color.WHITE);
        fundo.setFont(new Font("Arial", false, false, 30));
        fundo.drawString("W A S D  -  mover o personagem", 360, 220);
        fundo.drawString("ESPAÇO  -  dash (impulso rápido, tem tempo de recarga)", 360, 290);
        fundo.drawString("R  -  atirar na direção do mouse", 360, 360);
        fundo.drawString("Objetivo: sobreviva a 5 waves e derrote o chefe", 360, 460);

        addObject(new voltar(), 170, 620);
    }
}
