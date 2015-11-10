import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* John coded this class   
**/
public class Portal extends NPC
{
    public Player player;
    public Portal next;
    public Portal spawn;
    //John
    public Portal(){
        setImage("Door.png");
    }
    //John
    public void act() 
    {
        scrollingMethods();
    }    
    //John
    Portal getNextPortal()
    {
        return next;
    }
    //John
    public void setNextPortal(Portal p)
    {
        next = p;
    }
}
