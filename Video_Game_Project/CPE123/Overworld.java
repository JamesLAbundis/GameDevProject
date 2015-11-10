import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** 
* Nick coded this class   
**/
public class Overworld extends World
{ 
    public Player Player;
    public Scroller Scroller;
    public InfoBar InfoBar;
    public HealthBar playerHealthBar;
    public MoneyBag moneybag;
    public GameOver GameOver;
    public boolean bossBattle;
    public ArrowCounter arrowCounter;
    
    public GreenfootSound levelMusic;
    //Nick
    public Overworld(){
        super(800, 600, 1, false);
    }
    //Nick
    public void addTiles(){
        for (int n=1;n<200;n++){
            addObject(new Ground(), n*100-300, 437);}
    }
    //Nick
    public void addWater(){
        for (int n=1;n<200;n++){
            addObject(new Water(), n*100-400, 431);}
    }
    //Nick
    public void gameOver(){
        GameOver = new GameOver();
        Greenfoot.setWorld(GameOver);
    }
    //Nick
    public Player getPlayer(){
        return Player;
    }
    //Nick
    public Scroller getScroller(){
        return Scroller;
    }
    //Nick
    public HealthBar getHealthBar(){
        return playerHealthBar;
    }
    //Nick
    public MoneyBag getMoneyBag(){
        return moneybag;
    }
    //Nick
    public ArrowCounter getArrowCounter(){
        return arrowCounter;
    }
    //Nick
    public void setBossBattle(int x){
        if(x == 1){ 
            bossBattle = true;
        }
        else bossBattle = false;    
    }
}
