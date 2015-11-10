import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* James coded this class   
**/
public class MoneyBag extends Actor
{
    public int money = 0;
    //James
    public MoneyBag(int a){
           money = a;
    }
    //James
    public void act() 
    {  
        update();
        Variables.money = money;
    }    
    //James
    private void update(){
        String moneyAmount=("= "+ money);
        World w = getWorld();
        w.showText(moneyAmount,getX() + 55, getY());
    }
    //James
    public void addMoney(int a){
        money = money + a;
    }
    //James
    public void subtractMoney(int a){
        money = money - a;
    }
}