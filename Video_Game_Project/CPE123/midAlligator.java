import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Sean coded this class   
**/
public class midAlligator extends Tile
{
    public int leftParameter;
    public int rightParameter;
    public int aliSpeed;
    public int crocAtkProb;
    public boolean attack = false;
    public int animateCounter = 0;
    public int atkCounter = 0;
    public int moveCount = 0;
    //Sean
    public void act(){
        move();
        atkTime();
        //attack();
        scrollingMethods();
    }    
    //Sean
    public void move(){
        Overworld world = (Overworld) getWorld();
        move(aliSpeed);
        if (moveCount >= 0 && moveCount <= 50){
            setImage("alligator.png");
            aliSpeed = 1;
            moveCount++;
        }
        else if (moveCount > 50 && moveCount <= 150){
            setImage("alligator2.png");
            aliSpeed = -1;
            moveCount++;
        } 
        else if (moveCount >= 150 && moveCount <= 201){
            setImage("alligator.png");
            aliSpeed = 1;
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
    //Sean
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
    //Sean
    public void attack(){
        attack = true;
        if (playerStand() == true)
        {
            Overworld world = (Overworld) getWorld();
            Player player = world.getPlayer();
            HealthBar playerHealthBar = world.getHealthBar();
            playerHealthBar.normalHit();
        }
    }
    //Sean
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