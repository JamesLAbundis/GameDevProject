import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Nick coded this class   
**/
public class GameOver extends World
{
    //Nick
    public GameOver(){    
        super(800, 600, 1); 
        prepare();
    }
    //Nick
    public void prepare(){
        MenuNav retry = new MenuNav("button", "Retry", null); 
        addObject(retry, 414, 418);
    }
}
