import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Arya coded this class   
**/
public class Magic extends NPC
{
    int counter = 0;
    int xPos, yPos;
    //Arya
    public void act() 
    {
        move();
        catchOnFire();
    }
    //Arya
    public void hit()
    {
        Overworld World = (Overworld) getWorld();
        Player Player = World.getPlayer();
    }
    //Arya
    public void move()
    {
        xPos = getX();
        yPos = getY();
        if(counter !=30)
        {
            xPos = xPos + 2;
            yPos = yPos - 1;
            setLocation(xPos, yPos);
            counter++;
        }
        else
        {
            xPos = xPos + 2;
            yPos = yPos + 1;
            setLocation(xPos, yPos);
        }
    }
    //Arya
    public void catchOnFire()
    {
        if (yPos == 380)
        {
            Overworld world = (Overworld) getWorld();
            MagicFire fire = new MagicFire();
            world.addObject(fire, xPos, yPos+30);
            world.removeObject(this); 
        }
    }
}