import greenfoot.*;

public class Musica
{
    private static GreenfootSound menu = new GreenfootSound("telaInicialMusica.wav");
    private static GreenfootSound batalha = new GreenfootSound("ingame.mp3");

    public static void tocarMenu()
    {
        batalha.stop();
        if (!menu.isPlaying()) menu.playLoop();
    }

    public static void tocarBatalha()
    {
        menu.stop();
        if (!batalha.isPlaying()) batalha.playLoop();
    }

    public static void pararTudo()
    {
        menu.stop();
        batalha.stop();
    }
}