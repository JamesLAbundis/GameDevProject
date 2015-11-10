import greenfoot.*;  
/** 
* Arya coded this class   
**/
public class Skeleton extends MeleeEnemy
{
   private GreenfootImage[] animate = new GreenfootImage[2];
   //Arya
   public Skeleton(int health){
       super(health, "Skeleton");
       animate[0] = new GreenfootImage("skeletonleft.png");
       animate[1] = new GreenfootImage("skeletonright.png");
   
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
       if(speed == -1) setImage("skeletonleft.png");
       else if(speed == 1) setImage("skeletonright.png");
   } 
}