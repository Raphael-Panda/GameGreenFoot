import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BOSS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BOSS extends inimigo
{
    /**
     * Act - do whatever the BOSS wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    protected projetil_inimigo criarProjetil(){
        return new projetil_boss();
    }
    @Override
    protected void criarBarra(World mundo){
        mundo.addObject(new BarraVida(this, 500, 18, false, 0, "Lich, O Último Sábio de GOLB"),
                                        mundo.getWidth() / 2, 40);
    }
    public BOSS() {
        vida = 600;
        vidaMax = 600;
        danoContato = 15;
        intervaloTiro = 90;
        setImage(new GreenfootImage("bossm.png"));
    }
}
