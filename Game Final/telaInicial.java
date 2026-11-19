import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class telaInicial here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class telaInicial extends World
{

    /**
     * Constructor for objects of class telaInicial.
     * 
     */
    public void started() { 
        Musica.tocarMenu(); 
    }      
    public void stopped() { 
        Musica.pararTudo(); 
    }
    public telaInicial()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1300, 690, 1);
        setBackground("telaInicial.png");
        addObject(new play(), 170, 350);
        addObject(new Bcomojogar(),170, 420);
        Musica.tocarMenu();

    }
}
