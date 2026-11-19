import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class botao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class botao extends Actor
{
    /**
     * Act - do whatever the botao wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected String texto;
    protected int largura;
    protected int altura;
    public botao(String texto, int largura, int altura){
        this.texto = texto;
        this.largura = largura;
        this.altura = altura;
        GreenfootImage botao = new GreenfootImage(largura, altura);
        botao.setColor(new Color(20, 15, 25, 220));
        botao.fillRect(0, 0, largura, altura);
        botao.setColor(new Color(212, 175, 55));
        botao.drawRect(0, 0, largura - 1, altura - 1);
        GreenfootImage rotulo = new GreenfootImage(texto, 24, Color.WHITE, new Color(0, 0, 0, 0));
        botao.drawImage(rotulo, (largura - rotulo.getWidth()) / 2, (altura - rotulo.getHeight()) / 2);
        setImage(botao);
    }
    protected void acao(){ }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)){
            acao();
        }
    }

    
}
