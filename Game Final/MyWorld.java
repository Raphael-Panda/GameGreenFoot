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
    private int[] qtdEnemy = {22, 28, 34, 40, 1};
    int waveAtual;
    private int spawnX;
    private int spawnY;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public void started() { 
        Musica.tocarMenu(); 
    }      
    public void stopped() { 
        Musica.pararTudo(); 
    }
    public MyWorld()
    {    
        super(1300, 690, 1);
        Musica.tocarBatalha();
        heroi prota = new heroi(); 
        addObject(prota, 671, 343);
        addObject(new BarraVida(prota, 250, 22, false, 0, null), 140, getHeight() - 30);
        setPaintOrder(BarraVida.class, heroi.class, projetil.class, projetil_inimigo.class, inimigo.class);
        arena bg = new arena();
        setBackground("back.png");
    }
    private void bordaSpawn(){
        heroi prota = getObjects(heroi.class).get(0);
        boolean pertoBorda;
        boolean pertoHeroi;
        do{
            spawnX = Greenfoot.getRandomNumber(1200);
            spawnY = Greenfoot.getRandomNumber(600);
            pertoBorda = spawnX < 100 || spawnX > 1100 || spawnY < 100 || spawnY > 800;
            pertoHeroi = Math.abs(spawnX - prota.getX()) < 250 && Math.abs(spawnY - prota.getY()) < 250;
        }while(!pertoBorda || pertoHeroi); 
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
                    bordaSpawn();
                    if(wave == 1){
                        inimigo ogro = new inimigo();
                        addObject(ogro, spawnX, spawnY);  
                    }
                    else if(wave == 2){
                        inimigo2 peixe = new inimigo2();
                        addObject(peixe, spawnX, spawnY);
                    }
                    else if(wave == 3){
                        inimigo3 jabuti = new inimigo3();
                        addObject(jabuti, spawnX, spawnY);
                    }
                    else if(wave == 4){
                        inimigo4 joaninha = new inimigo4();
                        addObject(joaninha, spawnX, spawnY);
                    }
                    spawn += 1;
                    i++;
                }
                if(wave == 5){
                    BOSS lich = new BOSS();
                    addObject(lich, 1132, 128);
                }
            }
            if(spawn < waveAtual && getObjects(inimigo.class).size() <= 2){
                int faltam = waveAtual - spawn;
                int j = 0;
                while(j < faltam){
                    bordaSpawn();
                    if(wave == 1){
                        inimigo ogro = new inimigo();
                        addObject(ogro, spawnX, spawnY);  
                    }
                    else if(wave == 2){
                        inimigo2 peixe = new inimigo2();
                        addObject(peixe, spawnX, spawnY);
                    }
                    else if(wave == 3){
                        inimigo3 jabuti = new inimigo3();
                        addObject(jabuti, spawnX, spawnY);
                    }
                    else if(wave == 4){
                        inimigo4 joaninha = new inimigo4();
                        addObject(joaninha, Greenfoot.getRandomNumber(spawnX), Greenfoot.getRandomNumber(spawnY));
                    }
                    spawn += 1;
                    j++;
                }
            }
            if(spawn == waveAtual && getObjects(inimigo.class).isEmpty()){
                proxWave = true;
            }
            if(wave == 5 && getObjects(inimigo.class).size() == 0){
                showText("VOCÊ VENCEU AS CRIATUAS MITICAS", 
                            getWidth() / 2, getHeight() / 2);
                Greenfoot.stop();
            }
        }
}
