import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Nick coded this class   
**/
public class IntroScreen extends World
{
    public GreenfootSound introTheme;
    //Nick
    public IntroScreen(){    
        super(800, 600, 1); 
        prepare();
        introTheme = new GreenfootSound("intro.wav");
        introTheme.playLoop();
    }
    //Nick
    public void prepare(){
        MenuNav start = new MenuNav("button", "Start", null);
        addObject(start, 400, 418);
    }
}
