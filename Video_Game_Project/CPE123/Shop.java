import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Nick coded this class   
**/
public class Shop extends World
{
    public MoneyBag mb = new MoneyBag(Variables.money);
    public Heart h = new Heart(Variables.health);
    public GreenfootSound storeTheme;
    //Nick
    public Shop(){    
        super(800, 600, 1);
        prepare();
        storeTheme = new GreenfootSound("store.wav");
        storeTheme.playLoop();
    }
    //Nick
    public void prepare(){
        MenuNav cont = new MenuNav("button", "Continue", null); addObject(cont, 594, 494);
        MenuNav welcome = new MenuNav("text", "Welcome", null);addObject(welcome, 404, 112);
        MenuNav money = new MenuNav("text", "Money", null);addObject(money, 216, 494);
        MenuNav b1 = new MenuNav("button", "Buy", "Sword"); addObject(b1, 157, 247);
        MenuNav b2 = new MenuNav("button", "Buy", "Bow"); addObject(b2, 401, 247); showText("50 gems", 405, 324);
        MenuNav b3 = new MenuNav("button", "Buy", "Magic"); addObject(b3, 641, 247); showText("140 gems", 645, 324);
        MenuNav b4 = new MenuNav("button", "Buy", "Potion"); addObject(b4, 153, 384); showText("20 gems", 265, 372);
        MenuNav b5 = new MenuNav("button", "Buy", "Arrow"); addObject(b5, 400, 384); showText("20 gems", 513, 372);
        addObject(mb, 123, 496);
        addObject(h, 258, 496);
    }
    //Nick
    public MoneyBag getMoney(){
        return mb;
    }
    //Nick
    public Heart getHeart(){
        return h;
    }
}
