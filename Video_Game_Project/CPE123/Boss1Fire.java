import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Sean coded this class   
**/
public class Boss1Fire extends NPC
{
    //Sean
    public void act() 
    {
        mover();
        hite();
    }    
    //Sean
    public void mover()
    {
        setRotation(155);
        move(9);
    }
    //Sean
    public void hite()
    {
        Overworld World = (Overworld) getWorld();
        Player Player = World.getPlayer();
        if (getOneIntersectingObject(Player.class) != null){
            HealthBar playerHealthBar = World.getHealthBar();
            playerHealthBar.normalHit();
            World.removeObject(this);
        }
        else if(getY() > 440) World.removeObject(this);
    }
}