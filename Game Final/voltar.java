import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class voltar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class voltar extends botao
{
    /**
     * Act - do whatever the voltar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public voltar(){
        super("VOLTAR", 240, 55);
    }
    @Override
    protected void acao(){
        Greenfoot.setWorld(new telaInicial());
    }
}
