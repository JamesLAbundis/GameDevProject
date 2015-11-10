import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Vincy coded this class   
**/
public class VerticalPlat extends Tile
{
    public int counter = 0;
    public int speed;
    public int playerOffset;
    public int height = 1;
    //Vincy
    public void act() 
    {
        scrollingMethods();
        move();
    }    
    //Vincy
    public void move()
    {
        counter++;
        if (counter >= 0 && counter <= 100)
        {
            setLocation(getX(), getY() + height);
        } else if (counter > 100 && counter < 200)
        {
            setLocation(getX(), getY() - height);
        }
        if (counter == 200)
        {
            counter = 0;
        }
        Overworld world = (Overworld) getWorld();
        Player p = world.getPlayer();
        playerOffset = 48;
        if (getOneIntersectingObject(Player.class) != null){
            if (getOneObjectAtOffset((getImage().getWidth()/2),(getImage().getHeight()/2), Player.class) != null){
                 //p.move(0);
            } 
            else if (getOneObjectAtOffset((getImage().getWidth()/-2),(getImage().getHeight()/-2), Player.class) != null){
                 // p.move(0);
            }
            else{
                 p.setLocation(p.getX(), getY() + height - playerOffset);
            }
        }
    }
}