import greenfoot.*;  

/** 
* Arya coded this class   
**/
public class Scorpion extends MeleeEnemy
{
   private GreenfootImage[] animate = new GreenfootImage[2];
   //Arya
   public Scorpion(int health){
       super(health, "Scorpion");
       animate[0] = new GreenfootImage("Scorpion0.png");
       animate[1] = new GreenfootImage("Scorpion1.png");
   
   }
   //Arya 
   public void act(){
        scrollingMethods();
        move();
        attack();
        takeDamage();
        animate();
    }
    //Arya
   public void animate(){
       if(speed == -1) setImage("Scorpion0.png");
       else if(speed == 1) setImage("Scorpion1.png");
   } 
}