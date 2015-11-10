import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** 
* Vincy and Sean coded this class   
**/
public class LevelOneBoss extends Boss
{
    private int hitCounter;
    private int animateAtkCount = 0;
    private int aniPincer = 0;
    public int atkTimer = 0;
    public int atkCount = 0;
    public int maxAtkCount = atkCount;
    public boolean attacked;
    public int shootCounter;
    public int BossMoveCount = 0;
    public int attackCount = 200;
    public boolean attacking;
//Vincy + Sean 
    public LevelOneBoss(int health){
        super(health);
    }
    //Vincy + Sean 
    public void act(){
        Overworld w = (Overworld) getWorld();
        scrollingMethods();
        if(w.bossBattle){
            attack();
            if(attacking){
                pincerAttack();
            }
            fireThing();
            takeDamage();
        }

    }
    //Vincy + Sean 
    public void attack(){
        if(attackCount >= 200){
            attacking = true;
            if(BossMoveCount >= 0 && BossMoveCount < 45)
            {
                move(-4);
                BossMoveCount ++;
            }
            else if(BossMoveCount >= 45 && BossMoveCount <= 90)
            {
                move(4);
                BossMoveCount ++;
            }
            else if(BossMoveCount >= 90 && BossMoveCount <= 135)
            {
                move(-4);
                BossMoveCount ++;
            }
            else if(BossMoveCount >= 135 && BossMoveCount <= 180)
            {
                move(4);
                BossMoveCount ++;
            }
            if(BossMoveCount >= 180)
            {
                BossMoveCount = 0;
                attackCount = 0;
            }
        }
        else{
            attackCount++;
            attacking = false;
        }
    }
      //Vincy + Sean                               
    public void pincerAttack(){
        Overworld w = (Overworld) getWorld();
        HealthBar hb = w.getHealthBar();

        if (getOneIntersectingObject(Player.class) != null){
            hb.bossHit();
        }  
    }
    //Vincy + Sean 
    public void takeDamage()
    {
        // Coded by Sean and Vincy
        Overworld w = (Overworld) getWorld();
        Player p = w.getPlayer();
        if(p.attack && isTouching(Player.class)){
            health--;
            Greenfoot.playSound("neck-snap.mp3");
        }

        if(health == 0){
            TextBox tb = new TextBox(100);
            w.addObject(tb,400,110);
            SoulStone ss = new SoulStone();
            w.addObject(ss, 698, 380);
            w.removeObject(this);
        }
    }
    //Vincy + Sean 
    public void fireThing()
    {
        Overworld w = (Overworld) getWorld();

        if (w != null){
            Player p = w.getPlayer();
            if(LevelOneBoss.class != null){

                if(getX() - p.getX() <= 600){
                    shootCounter++;

                    if (shootCounter == 90){
                        Overworld World = (Overworld) getWorld();
                        Boss1Fire bf = new Boss1Fire();
                        World.addObject(bf, this.getX() - 30, this.getY() - 10);
                    }

                    if (shootCounter == 180)    
                    {
                        shootCounter = 0;
                    }
                }
            }
        }
    }
}