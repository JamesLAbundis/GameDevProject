import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Vincy coded this class   
**/
public class DissappearingPlat extends Tile
{
    private int timer = 0;
    //Vincy
    public void act() 
    {
        scrollingMethods();
        dissappear();
    }   
    //Vincy
    public void dissappear()
    {
        Overworld world = (Overworld) getWorld();
        Player Player = world.getPlayer();
        timer++;
        if ( getOneIntersectingObject(Player.class) != null && timer == 50)
        {
            world.removeObject(this);
        } else if ( getOneIntersectingObject(Player.class) == null)
        {
            timer = 0;
        }
    }
}