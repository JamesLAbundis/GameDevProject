import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Test extends Overworld
{
    
    public Test(){
        prepare();
    }
    
    public void prepare(){
        addTiles();
        Scroller = new Scroller();
        addObject(Scroller, 400, -10);
        Player = new Player();
        addObject(Player, 200, 361);
        InfoBar = new InfoBar();
        addObject(InfoBar, 400, 535);
        playerHealthBar= new HealthBar(10);
        addObject(playerHealthBar,210,530);
        moneybag = new MoneyBag(0);
        addObject(moneybag,400,530);

        Ruby ruby = new Ruby();
        addObject(ruby, 386, 384);
        Sapphire sapphire = new Sapphire();
        addObject(sapphire, 479, 390);
        sapphire.setLocation(478, 387);
        Emerald emerald = new Emerald();
        addObject(emerald, 568, 391);
        emerald.setLocation(568, 387);
        Diamond diamond = new Diamond();
        addObject(diamond, 642, 387);
        diamond.setLocation(649, 387);
        HealthPotion healthpotion = new HealthPotion();
        addObject(healthpotion, 729, 382);
    }
    
}
