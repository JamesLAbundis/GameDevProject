import greenfoot.*;
/** 
* John coded this class   
**/
public class FallingPlatform extends Tile
{
    private int timer = 0;
    private int fallSpeed = 0;
    private int acceleration = 1;
    private int touching;
    private static final int stepTime = 50;
    public Level2 level2 = (Level2) getWorld();
    public Overworld world = (Overworld) getWorld();
    private boolean fall;
    public FallingPlatform fp;
    
    //John
    public FallingPlatform(){
        fall = false;
    }
    //John
    public void act() 
    {
        scrollingMethods();
        fallCountDown();
        activeGravity();
        touching();
    }    
    //John
    public void touching(){
        if(getOneObjectAtOffset(0 , -26, Player.class) != null){
            fall = true;
        }
    }
    //John
    public void fallCountDown(){
        if (fall == true){
            timer++;
            if (timer == stepTime){
                touching = 1;
            }
        }
    }
    //John
    public void gravity(){
        fallSpeed += acceleration;
        setLocation(getX(), getY() + (fallSpeed/4));
    }
    //John
    public void gravity2(){
        fallSpeed -= acceleration;
        setLocation(getX(), getY() + (fallSpeed/4));
    }
    //John
    public void activeGravity(){
        if (touching == 1){
            gravity();
        }
        if (touching == -1){
            gravity2();
        }
    }
    //John
    FallingPlatform getFallingPlatform()
    {
        return fp;
    }
}