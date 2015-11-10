import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* James coded this class   
**/
public class Archer extends Enemy
{
    public int counter;
    //James
    public Archer(int health){
        super(health);
        
    }
    //James
    public void act() 
    {
        scrollingMethods();
        shoot();
        takeDamage();
    }
    //James
    public void shoot(){
        if(counter >= 100){
            Arrow a=new Arrow();
            getWorld().addObject(a,getX()-5,getY());  
            counter = 0;
        }
        counter++;
    }
}