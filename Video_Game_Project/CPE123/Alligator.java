import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Vincy coded this class   
**/
public class Alligator extends Tile
{
    public int leftParameter;
    public int rightParameter;
    public int aliSpeed;
    public int crocAtkProb;
    public boolean attack = false;
    public int animateCounter = 0;
    public int atkCounter = 0;
    public int moveCount = 0;
    //Vincy
    public void act(){
        move();
        atkTime();
        //attack();
        scrollingMethods();
    }    
    //Vincy
    public void move(){
        Overworld world = (Overworld) getWorld();
        move(aliSpeed);
        if (moveCount >= 0 && moveCount <= 100){
            setImage("alligator.png");
            aliSpeed = 1;
            moveCount++;
        }
        else if (moveCount > 100 && moveCount <= 201){
            setImage("alligator2.png");
            aliSpeed = -1;
            moveCount++;
        } 

        if (moveCount > 201){
            moveCount = 0;
        }

        // if player is on top of the platform, move with the platform
        // needs change to getOneObjectAtOffset + prevent player from moving when
        // on side
        Player p = world.getPlayer();
        if (getOneIntersectingObject(Player.class) != null){
            
                p.move(aliSpeed);
            
        }
    }
    //Vincy
    public void atkAnimate()
    {
        if (attack == true)
        {
            animateCounter++;
            if (animateCounter == 10)
            {
                //setImage("player1.png");
            } else if (animateCounter == 20)
            {
                //setImage("player2.png");
            } else if (animateCounter == 30)
            {
                //setImage("player3.png");
                animateCounter = 0;
            } else
            {
               // setImage("croc.png");
            }
        }

        Overworld world = (Overworld) getWorld();
        Player player = world.getPlayer();
    }
    //Vincy
    public boolean playerStand(){
        Overworld world = (Overworld) getWorld();
        Player player = world.getPlayer();        
        if (getOneIntersectingObject(Player.class) != null){
            return true;
        } 
        else{
            return false;
        }
    }
    //Vincy
    public void attack(){
        attack = true;
        if (playerStand() == true)
        {
            Overworld world = (Overworld) getWorld();
            Player player = world.getPlayer();
            atkAnimate();
            HealthBar playerHealthBar = world.getHealthBar();
            playerHealthBar.normalHit();
        }
    }
    //Vincy
    public void atkTime()
    {
        // atk timer for the alligator; attack every 2 1/2 seconds
        if (getOneIntersectingObject(Player.class) != null){
            atkCounter++;
            if (atkCounter == 120){
                attack();
                atkCounter = 0;
            }
        }
    }
}