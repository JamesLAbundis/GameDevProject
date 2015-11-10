import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MeleeEnemy extends Enemy
{
    public int speed;
    public int counter = 50;
    public String direction = "left";
    //Vincy
    public MeleeEnemy(int health, String type){
        super(health);
        enemyType(type);
    }
    //Vincy
    public void attack(){  
        Actor player = getOneObjectAtOffset(0, 0, Player.class);
        Overworld World = (Overworld) getWorld();
        Player Player = World.getPlayer();
        if(counter < 50){
            counter++;
        }
        if (player != null) {
            HealthBar playerHealthBar = World.getHealthBar();
            playerHealthBar.normalHit();
            if(counter >= 50){
                speed = -speed;
                counter = 0;
            }
        }
    } 
    //Vincy
    public void move(){
         move(speed);
         if(getX() < 10 && direction == "left"){
            speed = -speed;
            direction = "right"; 
         }
         if(getX() > getWorld().getWidth() - 10 && direction == "right"){
            speed = -speed;
            direction = "left"; 
         }
         if(getOneIntersectingObject(TallPlat.class) != null || getOneIntersectingObject(TallPlat2.class) != null){
            speed *= -1;
         }
         
    }
    //Vincy
    public void enemyType(String type){
        if(type == "Scorpion"){
            speed = -1;
        }
        else if(type == "Coyote"){
            speed = -2;
        }
        else if(type == "Mummy"){
            speed = -1;
        }
        else if(type == "Skeleton"){
            speed = -1;
        }
    }
}
