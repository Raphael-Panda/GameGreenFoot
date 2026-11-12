import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int wave = 0;
    private int spawn = 0;
    private boolean proxWave = true;
    private int[] qtdEnemy = {14, 18, 26, 30, 5};
    int waveAtual;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1200, 900, 1);
        heroi boneco = new heroi(); 
        addObject(boneco, 600, 400);
        arena bg = new arena();
        setBackground("91a2005da755e37357fa71f9354d82f2.jpg");
        
    }
    public void act(){
            if(proxWave == true){
                proxWave = false;
                wave += 1;
                spawn = 0;
                showText("Wave " + wave, 60, 20);
                waveAtual = qtdEnemy[wave - 1];
                int i = 0;
                while(i < waveAtual / 2){
                    inimigo cobra1 = new inimigo();
                    addObject(cobra1, Greenfoot.getRandomNumber(1200),Greenfoot.getRandomNumber(900));
                    spawn += 1;
                    i++;
                }    
            }
            if(spawn < waveAtual && getObjects(inimigo.class).size() <= 2){
                int faltam = waveAtual - spawn;
                int j = 0;
                while(j < faltam){
                    inimigo cobra2 = new inimigo();
                    addObject(cobra2, Greenfoot.getRandomNumber(1200),Greenfoot.getRandomNumber(900));
                    spawn += 1;
                    j++;
                }
            }
            if(spawn == waveAtual && getObjects(inimigo.class).isEmpty()){
                proxWave = true;
            }
        }
}
