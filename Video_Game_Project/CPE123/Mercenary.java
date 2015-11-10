import greenfoot.*; 
 
/** 
* Arya coded this class   
**/
public class Mercenary extends Enemy
{
   private int health;
   private int fallSpeed = 0;
   private int attackCounter = 0;
   private int animCounter = 0;
   private String direction;
   boolean turn = false;
   int counter = 0;
   
   public GreenfootImage[] Animation = new GreenfootImage[12];
   //Arya
   public Mercenary(int health){
       super(health);
       for(int i=0; i < 12; i++) {
            Animation[i] = new GreenfootImage("merc" + i + ".png");
        }
   }
   //Arya
   public void act(){
        scrollingMethods();
        move();
        checkGround();
        takeDamage();
   }
   //Arya
   public void move(){   
       Overworld World = (Overworld) getWorld();
       Player player = World.getPlayer();
       int dist = 200;
       if(!getObjectsInRange(dist, Player.class).isEmpty())
       {
           if (getX()>= player.getX() + 40)
           {
               if (direction == "right")
               {
                   turn = true;
               }
               if (turn == true)
               {
                   counter++;
                   if(counter == 50)
                   {
                     turn = false;
                     counter = 0;
                   }
               }
               if (turn == false)
               {
                   direction = "left";
                   move(-2);
                   animCounter++;
                   
                   if(animCounter > 0 && animCounter <= 5)
                   {
                    setImage(Animation[4]);
                   }
                   if(animCounter > 5 && animCounter <= 10){
                       setImage(Animation[5]);
                    }
                   if(animCounter > 10 && animCounter <= 15){
                       setImage(Animation[4]);
                   }
                   if(animCounter > 15 && animCounter <= 20){
                       setImage(Animation[5]);
                   }
                   if(animCounter > 20){
                       animCounter = 0;
                   }
               }
           }
           else if (getX() <= player.getX() - 40)
           {
               if (direction == "left")
               {
                   turn = true;
               }
               if (turn == true)
               {
                   counter++;
                   if(counter == 50)
                   {
                     turn = false;
                     counter = 0;
                   }
               }
               if (turn == false)
               {
                  direction = "right";
                  move(2);
                  animCounter++;
                    if(animCounter > 0 && animCounter <= 5)
                    {
                      setImage(Animation[10]);
                    }
                    if(animCounter > 5 && animCounter <= 10){
                        setImage(Animation[11]);
                    }
                    if(animCounter > 10 && animCounter <= 15){
                        setImage(Animation[10]);
                    }
                    if(animCounter > 15 && animCounter <= 20){
                        setImage(Animation[11]);
                    }
                    if(animCounter > 20){
                        animCounter = 0;
                    }
               }
           }
           else if (getX() - player.getX() <= 40)
           {
               move(0);
               attack();
           }
       }
       else{
               if(direction == "left") setImage(Animation[0]);
               else if(direction == "right") setImage(Animation[6]);
       }
   }
   //Arya
   public void attack(){
        attackCounter++;
        if(direction == "left"){
            if(attackCounter > 0 && attackCounter <= 5){ 
                setImage(Animation[1]);
                Greenfoot.playSound("sounds/sword3.mp3");
            }
            else if(attackCounter > 5 && attackCounter <= 10){
                setImage(Animation[2]);
            }
            else if(attackCounter > 10 && attackCounter <= 15){
                setImage(Animation[3]);
            }
            else if(attackCounter >= 20){
                attackCounter = 0;
            }
            checkHit();
        }
        else if(direction == "right"){
            if(attackCounter > 0 && attackCounter <= 5){ 
                setImage(Animation[7]);
                Greenfoot.playSound("sounds/sword3.mp3");
            }
            else if(attackCounter > 5 && attackCounter <= 10){
                setImage(Animation[8]); 
            }
            else if(attackCounter > 10 && attackCounter <= 15){
                setImage(Animation[9]);
            }
            else if(attackCounter >= 20){
                attackCounter = 0;
            }
            checkHit();
        }
   }   
   //Arya
   public void checkHit(){
       if(getOneObjectAtOffset(40, 0, Player.class) != null || getOneObjectAtOffset(-40, 0, Player.class) != null){
           Overworld World = (Overworld) getWorld();
           HealthBar playerHealthBar = World.getHealthBar();
           playerHealthBar.normalHit();
       }
    }
   //Arya
   public void checkGround(){
       if(onGround()){
           fallSpeed = 0;
       }
       else{
           gravity();
       }
       if(getY() >= 360){
           setLocation(getX(), 358);
       }
   }
   //Arya
   public boolean onGround(){
       Actor under = getOneObjectAtOffset(0 , 26, Tile.class); 
       return under != null; 
   }
   //Arya
   public void gravity(){
       fallSpeed += 1;
       setLocation(getX(), getY() + (fallSpeed/2));
   }
}