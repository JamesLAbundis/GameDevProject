import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* John coded this class   
**/
/*
 * -1 direction is left
 * +1 direction is right
 */
public class Mummy extends MeleeEnemy
{

    public Player player;
    public Overworld world;
    private int timer = 0;
    private int direction;
    private static final int damageDist = 350;
    private static final int walkLength = 150;
    private int movement = 0;
    //John
    public Mummy(int health, int i){
        super(health, "Mummy");
        if(i == 1){
            movement = 1;
            paceTimer();
        }
        if(i == 2){
            direction = -1;
            movement = 2;
            paceTimer();
        }
    }
    //John
    public void act() 
    {
        scrollingMethods();       
        //attack();
        //doDamage();
        movement1();
        movement2();
        takeDamage();
    }    
    //John
    public void movement1(){
        if(movement == 1){
            pace();
            countDown();
            checkLook();
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
    //John
    public void checkLook()
    {
        looking();
        if(!getObjectsInRange(damageDist, Player.class).isEmpty() && this != null){ 
            if(player.getY() >= getY()){
                doDamage();
            }
        }
    }
    //John
    public void looking(){
        world = (Overworld) getWorld();
        player = world.getPlayer();
        if(this != null){
            if(speed == -1){
                setImage("MummyLeft1.png");
                direction = -1;
            }
            if(speed == 1){
                setImage("MummyRight1.png");
                direction = 1;
            }
        }
    }
    //John
    public void doDamage(){
        HealthBar playerHealthBar = world.getHealthBar();
        if(player.getX() < getX() && direction == -1 && player.playerSpeed == 3)
        {
            playerHealthBar.normalHit();
        }
        if(player.getX() > getX() && direction == 1 && player.playerSpeed == -3)
        {
            playerHealthBar.normalHit();
        }
    }
    //John
    public void countDown2(){
        if(timer > 0){
            timer--;    
            if(timer == 0){
                direction = -direction;
                paceTimer();
            }
        }   
    }
    //John
    public void bodyDirection(){
        world = (Overworld) getWorld();
        player = world.getPlayer();
        if (direction == -1){
            setImage("MummyLeft1.png");
        }
        if (direction == 1){
            setImage("MummyRight1.png");
        }
    }
    //John
    public void checkLook2(){
        bodyDirection();
        if(!getObjectsInRange(damageDist, Player.class).isEmpty() && this != null){ 
            if(player.getY() >= getY()){
                doDamage();
            }
        }
    }
    //John
    public void movement2(){
        if (movement == 2){
            countDown2();
            checkLook2();
        }
    }
}

