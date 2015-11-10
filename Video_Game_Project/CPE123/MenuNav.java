import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Nick coded this class   
**/
public class MenuNav extends Actor
{
    public String general;
    public String type;
    public String item;
    public boolean clickable;
    //Nick
    public MenuNav(String general, String type, String item){
        this.general = general;
        this.type = type;
        this.item = item;
        draw();
        
    }
    //Nick
    public void act(){
        clicked();
    }
    //Nick
    public void draw(){
        if(general == "button"){
            clickable = true;
            if(type == "Continue"){
                setImage("buttons/continue.png");
            }
            if(type == "Retry"){
                setImage("buttons/retry.png");
            }
            if(type == "Start"){
                setImage("buttons/start.png");
            }
            if(type == "Buy"){
                if(item == "Sword"){
                    setImage("buttons/sword.png");
                }
                if(item == "Bow" && !Variables.hasBow){
                    setImage("buttons/bow0.png");
                }
                else if(item == "Bow" && Variables.hasBow){
                    setImage("buttons/bow1.png");
                }
                if(item == "Magic" && !Variables.hasMagic){
                    setImage("buttons/staff0.png");
                }
                else if(item == "Magic" && Variables.hasMagic){
                    setImage("buttons/staff1.png");
                }
                if(item == "Potion"){
                    setImage("buttons/pot.png");
                }
                if(item == "Arrow"){
                    setImage("buttons/arrowbutton.png");
                }
            }
        }
        else if(general == "text"){
            if(type == "Welcome"){
                setImage("buttons/welcometoshop.png");
            }
            if(type == "Money"){
                setImage("buttons/storemoney.png");
            }
        }
    }
    //Nick
    public void clicked(){
        if(clickable){
            if(type == "Continue"){
                if(Greenfoot.mouseClicked(this) && Variables.Level == "Level 1"){
                    Shop s = (Shop)getWorld();
                    s.storeTheme.stop();
                    Level2 level2 = new Level2();
                    Greenfoot.setWorld(level2);
                }
                else if(Greenfoot.mouseClicked(this) && Variables.Level == "Level 2"){
                    Shop s = (Shop)getWorld();
                    s.storeTheme.stop();
                    Pyramid p = new Pyramid();
                    Greenfoot.setWorld(p);
                }
            }
            if(type == "Retry"){
                if(Greenfoot.mouseClicked(this)){
                     if(Variables.Level == "Level 1"){
                         Variables.health = 10;
                         Level1 level1 = new Level1();
                         Greenfoot.setWorld(level1);
                     }
                     if(Variables.Level == "Level 2"){
                         Variables.health = 10;
                         Level2 level2 = new Level2();
                         Greenfoot.setWorld(level2);
                     }
                     if(Variables.Level == "Level 3"){
                         Variables.health = 10;
                         Level3 level3 = new Level3();
                         Greenfoot.setWorld(level3);
                     }
                }
            }
            if(type == "Start"){
                if(Greenfoot.mouseClicked(this)){
                    IntroScreen i = (IntroScreen)getWorld();
                    i.introTheme.stop();
                    Level1 level1 = new Level1();
                     Greenfoot.setWorld(level1);
                }
            }
            if(type == "Buy"){
                if(item == "Bow" && !Variables.hasBow){
                    if(Variables.money >= 50){
                        if(Greenfoot.mouseClicked(this)){
                            Shop s = (Shop) getWorld();
                            MoneyBag mb = s.getMoney();
                            setImage("buttons/bow1.png");
                            Variables.hasBow = true;
                            Variables.arrows = 10;
                            mb.subtractMoney(50);
                            Variables.money -= 50;
                        }
                    }
                }
                if(item == "Magic" && !Variables.hasMagic){
                    if(Variables.money >= 140){
                        if(Greenfoot.mouseClicked(this)){
                            Shop s = (Shop) getWorld();
                            MoneyBag mb = s.getMoney();
                            setImage("buttons/staff1.png");
                            Variables.hasMagic = true;
                            mb.subtractMoney(140);
                            Variables.money -= 140;
                        }
                    }
                }
                if(item == "Potion"){
                    if(Variables.money >= 20){
                        if(Greenfoot.mouseClicked(this)){
                            if(Variables.health < 10){
                                Shop s = (Shop) getWorld();
                                MoneyBag mb = s.getMoney();
                                Heart h = s.getHeart();
                                mb.subtractMoney(20);
                                if(h.health <= 8){
                                    h.addHealth();
                                }
                                else{
                                    h.health += 1;
                                }
                                Variables.money -= 20;
                                Variables.health += 2;
                            }
                        }
                    }
                }
                if(item == "Arrow" && Variables.hasBow){
                    if(Variables.money >= 20){
                        if(Greenfoot.mouseClicked(this)){
                            Shop s = (Shop) getWorld();
                            MoneyBag mb = s.getMoney();
                            mb.subtractMoney(20);
                            Variables.money -= 20;
                            Variables.arrows += 10;
                        }
                    }
                }
            }
        }
    }
}