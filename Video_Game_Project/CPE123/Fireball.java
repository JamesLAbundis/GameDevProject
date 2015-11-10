import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Nick coded this class   
**/
public class Fireball extends NPC
{
    public int speed;
    //Nick
    public void act() 
    {
        move(-6);
        hit();
    }
    //Nick
    public void hit(){
        Overworld World = (Overworld) getWorld();
        Player Player = World.getPlayer();
        if (getOneIntersectingObject(Player.class) != null){
            HealthBar playerHealthBar = World.getHealthBar();
            playerHealthBar.normalHit();
            World.removeObject(this);
        }
        else if (getOneIntersectingObject(TallPlat2.class) != null){
            World.removeObject(this);
        }
    }
}
