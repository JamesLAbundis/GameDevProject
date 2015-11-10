import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Nick coded this class   
**/
public class NPC extends Scroller
{
    public int scrollX = 0;
    //Nick
    public void setLocation(){
        setLocation(getX() + scrollX, getY());
    }
    //Nick
    public void Scroll(int speed){
        Overworld w = (Overworld) getWorld();
        Scroller s = w.getScroller();
        if (Greenfoot.isKeyDown("left") && s.shouldScroll == true){
            scrollX = speed;
        }
        else if (Greenfoot.isKeyDown("right") && s.shouldScroll == true){
            scrollX = -speed;
        }
        else{
            scrollX = 0;
        }
        
        if (Greenfoot.isKeyDown("j")){
            scrollX = speed + 8;
        }
        else if (Greenfoot.isKeyDown("k")){
            scrollX = -speed - 8;
        }
        
    }
    //Nick
    public void scrollingMethods(){
        Scroll(3);
        setLocation();
    }
}
