import greenfoot.*;  

/** 
* John coded this class   
**/
public class RedScorpion extends MeleeEnemy
{
   public Player player;
   public Overworld world;
   private int timer = 0;
   private int direction;
   private static final int damageDist = 350;
   private static final int walkLength = 150;
   private int movement = 0;
   private GreenfootImage[] animate = new GreenfootImage[2];
   //John
   public RedScorpion(int health){
       super(health, "Scorpion");
       animate[0] = new GreenfootImage("Scorpion0.png");
       animate[1] = new GreenfootImage("Scorpion1.png");
       paceTimer();
   }
   //John  
   public void act(){
        scrollingMethods();
        animate();
        collide();
        attack();
        takeDamage();
        pace();
        countDown();
    }
   //John
   public void animate(){
       if(speed == -1) setImage("Crab0.png");
       else if(speed == 1) setImage("Crab1.png");
   } 
   //John
   public void collide(){
       if(getOneIntersectingObject(TallPlat2.class) != null){
           speed= -speed;
        }
   }
   //John
   public void pace()
    {
        move(speed);

    }
    //John
    public void paceTimer(){
        timer = walkLength;
    }
//John
    public void countDown(){
        if(timer > 0){
            timer--;    
            if(timer == 0){
                speed = -speed;
                paceTimer();
            }
        }
    }
}