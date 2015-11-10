import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Vincy coded this class   
**/
public class Coyote extends MeleeEnemy
{
    private int animationCounter;
    //Vincy
    public Coyote(int health){
        super(health, "Coyote");
    }
    //Vincy
    public void act(){
        scrollingMethods();
        animateCoyote();
        move();
        attack();
        takeDamage();
    }
    //Vincy
    public void animateCoyote()
    {
        if (speed == -2){
            animationCounter++;
            if (animationCounter <= 5){ 
                setImage("coyote0.gif");
            } 
            else if (animationCounter > 5 &&  animationCounter <= 10){
                setImage("coyote1.gif"); 
            }
            
            if(animationCounter == 10) animationCounter = 0;
        }
        if (speed == 2){
            animationCounter++;
            if (animationCounter <= 5){ 
                setImage("coyote2.gif");
            } 
            else if (animationCounter > 5 &&  animationCounter <= 10){
                setImage("coyote3.gif"); 
            }
            
            if(animationCounter == 10) animationCounter = 0;
        }
    }
    
}