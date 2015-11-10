import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Arya coded this class   
**/
public class Water extends Tile
{
    int counter = 10;
    //Arya
    public void act() 
    {
        scrollingMethods();
        hit();
    }
    //Arya
    public void hit()
    {
        Overworld World = (Overworld) getWorld();
        Player Player = World.getPlayer();
        Scroller s = World.getScroller();

        if (getOneIntersectingObject(Player.class) != null || getOneObjectAtOffset(0,-50,Player.class) != null)
        {
            Overworld world = (Overworld) getWorld();
            Player p =world.getPlayer();
            p.stuck = true;
            s.stuck = true;
            
            HealthBar playerHealthBar = World.getHealthBar();
            playerHealthBar.normalHit();
                
            if(counter >= 10)
            {
                p.acceleration = 0;
                p.setLocation(p.getX(), p.getY() + 1);
                counter = 0;
            }
            counter++;
        }
    }
}