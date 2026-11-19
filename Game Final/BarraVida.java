import greenfoot.*;

public class BarraVida extends Actor
{
    private Actor dono;
    private int largura, altura, deslocamentoY;
    private boolean seguir;
    private String nome;

    public BarraVida(Actor dono, int largura, int altura,
                     boolean seguir, int deslocamentoY, String nome)
    {
        this.dono = dono;
        this.largura = largura;
        this.altura = altura;
        this.seguir = seguir;
        this.deslocamentoY = deslocamentoY;
        this.nome = nome;
        desenhar();
    }

    public void act()
    {
        if (dono.getWorld() == null) {          // dono morreu: a barra some junto
            if (getWorld() != null) getWorld().removeObject(this);
            return;
        }
        if (seguir) {
            setLocation(dono.getX(), dono.getY() + deslocamentoY);
        }
        desenhar();
    }

    private void desenhar()
    {
        int vida = 0;
        int vidaMax = 1;
        if (dono instanceof heroi) {
            vida = ((heroi) dono).getVida();
            vidaMax = ((heroi) dono).getVidaMax();
        } else if (dono instanceof inimigo) {
            vida = ((inimigo) dono).getVida();
            vidaMax = ((inimigo) dono).getVidaMax();
        }

        double proporcao = (double) vida / vidaMax;   // double, senão a divisão dá 0 ou 1
        if (proporcao < 0) proporcao = 0;

        int alturaNome = (nome != null) ? 22 : 0;
        GreenfootImage img = new GreenfootImage(largura, altura + alturaNome);

        if (nome != null) {
            img.setColor(Color.WHITE);
            img.setFont(new Font("Arial", true, false, 16));
            img.drawString(nome, 0, 16);
        }
        img.setColor(new Color(60, 0, 0));                         // fundo
        img.fillRect(0, alturaNome, largura, altura);
        img.setColor(Color.GREEN);                                 // vida atual
        img.fillRect(0, alturaNome, (int) (largura * proporcao), altura);
        img.setColor(Color.BLACK);                                 // borda
        img.drawRect(0, alturaNome, largura - 1, altura - 1);
        setImage(img);
    }
}