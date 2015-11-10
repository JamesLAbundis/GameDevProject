import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Arya coded this class   
**/
public class MagicFire extends Tile
{
    int counter = 10;
    int counterToRemove = 0;
    //Arya
    public void act() 
    {
        scrollingMethods();
        hit();
        remove();
    }
    //Arya
    public void hit()
    {
        Overworld World = (Overworld) getWorld();
        Player Player = World.getPlayer();
        Scroller s = World.getScroller();
    }
    //Arya
    public void remove()
    {
        if(counterToRemove > 100)
        {
            Overworld world = (Overworld) getWorld();
            world.removeObject(this);
        }
        counterToRemove++;
    }
}