import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Nick coded this class   
**/
public class Scroller extends Actor
{
    public boolean shouldScroll;
    public int playerXCoord; 
    public boolean stuck;
    //Nick
    public void act(){
        updateShouldScroll(200, 400);
    }    
    //Nick
    public void updateShouldScroll(int leftX, int rightX){
        Overworld w = (Overworld) getWorld();
        Player p = (Player) w.getPlayer();
        playerXCoord = p.getX();
        if(!w.bossBattle && !stuck){
            if (playerXCoord <= leftX || playerXCoord >= rightX){
                shouldScroll = true;
            }
            else{
                shouldScroll = false;
            }
            if (shouldScroll == true && (playerXCoord >= rightX && Greenfoot.isKeyDown("left")) || (playerXCoord <= leftX && Greenfoot.isKeyDown("right"))){
                shouldScroll = false;
            }
        }
        else shouldScroll = false;
    }
    
}
