import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* James coded this class   
**/
public class Gems extends NPC
{
    public boolean swap=false;
    public int count=0;
    public int value;
    //James
    public Gems(int value){
        this.value = value;
    }
    //James
    public void act() 
    {
        move();
        scrollingMethods();
        remove();
    }   
    //James
    public void move(){
        int xPos=getX();
        int yPos=getY();
        
        if(swap==false){
          yPos=yPos-1;  
          setLocation(xPos,yPos);
          count++;
          if(count>4){
              swap=true;
              count=0;
          }
        }
        else{ 
            yPos=yPos+1;
            setLocation(xPos,yPos);
            count++;
            if(count>4){
                swap=false;
                count=0;
            }
        }
    }
    //James
    public void remove(){
        Overworld World = (Overworld) getWorld();
        Player Player = World.getPlayer();
        if (getOneIntersectingObject(Player.class) != null){
            MoneyBag m = World.getMoneyBag();
            m.addMoney(value);
            
            getWorld().removeObject(this);
        }
    }
}