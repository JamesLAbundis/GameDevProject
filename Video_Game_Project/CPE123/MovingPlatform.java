import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Vincy coded this class   
**/
public class MovingPlatform extends Tile
{
    public int speed;
    public int moveCounter;
    //Vincy
    public void act(){
        move();
        scrollingMethods();
    }
    //Vincy
    public void move(){
        // controls movement of the platform
        move(speed);
        if ( moveCounter >= 0 && moveCounter <= 100){
            speed = 1;
            moveCounter++;
        }
        else if (moveCounter > 100 && moveCounter <= 201){
            speed = -1;
            moveCounter++;
        }
        
        if (moveCounter > 201){
            moveCounter = 0;
        }
        Overworld world = (Overworld) getWorld();
        Player p = world.getPlayer();
        
        // move the player when the player is on top of the platform
        // need to fix so that player doesn't move when on side
        if (getOneIntersectingObject(Player.class) != null){
            if (getOneObjectAtOffset((getImage().getWidth()/2),(getImage().getHeight()/2), Player.class) != null){
                 //p.move(0);
            } 
            else if (getOneObjectAtOffset((getImage().getWidth()/-2),(getImage().getHeight()/-2), Player.class) != null){
                 // p.move(0);
            }
            else{
                 p.move(speed);
            }
        }
    }
}