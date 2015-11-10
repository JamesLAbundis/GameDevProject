import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Nick coded this class   
**/
public class Pyramid extends Overworld
{
    //Nick
    public Pyramid()
    {
        Variables.Level = "Trans";
        prepare();
        levelMusic = new GreenfootSound("level1.mp3");
        levelMusic.playLoop();
    }
    //Nick
    public void prepare(){
        Player = new Player();
        Scroller = new Scroller(); addObject(Scroller, 400, -10);
        InfoBar = new InfoBar();
        playerHealthBar= new HealthBar(Variables.health);
        moneybag = new MoneyBag(Variables.money);
        arrowCounter = new ArrowCounter(Variables.arrows);
        addTiles();
        Sign s1 = new Sign(13); addObject(s1, 250, 362);
        PyramidScenery ps = new PyramidScenery(); addObject(ps, 612, 200);
        addObject(Player, 200, 362);
        addObject(InfoBar, 400, 530);
        addObject(playerHealthBar,210,530);
        addObject(moneybag,400,530);
        if(Variables.hasBow){
            addObject(arrowCounter, 532, 536);
        }
    }
}
