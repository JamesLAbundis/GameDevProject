import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* James coded this class   
**/
public class HealthPotion extends Gems
{
    public HealthPotion(){
        super(0);
    }
    
    public void act(){
       move();
       scrollingMethods();
       addHealth();
    }    
    
    private void addHealth(){
        Overworld World = (Overworld) getWorld();
        Player Player = World.getPlayer(); 
        HealthBar bar=World.getHealthBar();
        if(getOneIntersectingObject(Player.class)!=null){  
            bar.gainHealth();
            World.removeObject(this);
        }
    }

}