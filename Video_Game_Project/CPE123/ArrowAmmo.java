import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* James coded this class   
**/
public class ArrowAmmo extends Gems
{
    public ArrowAmmo(){
        super(0);
    }
    
    public void act() 
    {   move();
        scrollingMethods();
        remove();
    }    
    
     public void remove(){
        Overworld World = (Overworld) getWorld();
        Player Player = World.getPlayer();
        if (getOneIntersectingObject(Player.class) != null){
             ArrowCounter c= World.getArrowCounter();
             c.addArrow(5);
            
            getWorld().removeObject(this);
        }
    }
}