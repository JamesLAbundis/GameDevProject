import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Heart extends Actor
{
    public int health;
    //Arya
    public Heart(int health){
        this.health = health;
    }
    //Arya
    public void act(){  
        update();
    }    
    //Arya
    private void update(){
        String healthAmount=("= "+ health);
        World w = getWorld();
        w.showText(healthAmount,getX() + 55, getY());
    }  
    //Arya
    public void addHealth(){
        health += 2;
    }
}
