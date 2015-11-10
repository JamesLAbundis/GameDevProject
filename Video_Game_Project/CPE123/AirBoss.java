import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Sean coded this class   
**/
public class AirBoss extends Boss
{   private int numShots;
    private int diagShots;
    public boolean swap;
    public boolean landed=false;
    public boolean reset=false;
    public int count;
    public int animCounter;
    public int attackTimer;
    public int diagonalTimer;
    //Sean
    public AirBoss(int health){
       super(health);
    }
    //Sean
    public void act(){
        scrollingMethods();
        Overworld w = (Overworld) getWorld();
        if(w.bossBattle){
           animate();
           movetoStop();
           fire();
           comeDown();
           sideToSide();
           restart();
           takeDamage();
       }
    }    
    //Sean
     private void movetoStop(){
       if(getY() < 120){
           setLocation(getX(),getY()+1); 
        }
        else{
           landed=true; 
        }
    } 
    //Sean
    private void sideToSide(){
        int yPos=getY();
        int xPos=getX();
        if(numShots<50&&landed==true){
           if(swap==true){    
               if(yPos>0&& (xPos<getWorld().getWidth()-1)){
                    xPos=xPos+2;
                    setLocation(xPos,yPos);
                    count++;
               }
               if(count==150){
                     swap=false;
                     count=0; 
               }
           }
             else{ 
                    if(yPos>0&& (xPos>-1)){
                        xPos=xPos-2;
                        setLocation(xPos,yPos);
                        count++;
                        }
                    if(count==150){
                        swap=true;
                        count=0; 
                    }
                }
            }
    }
    //Vincy
    private void fire(){
       if(getY() <= 360){  
           if(attackTimer >= 60){
            BossProjectile e=new BossProjectile();
            getWorld().addObject(e,getX(),getY()+5);
            e.selectShot(true);
            numShots++;
            attackTimer = 0;
           }
           attackTimer++;
       }
    }
     //Sean
     private void comeDown(){
        if(numShots >= 10){
            if(getY() < 330){
                setLocation(getX(),getY()+1); 
            }
            if(diagShots <= 10){
                if(diagonalTimer >= 50){  
                    BossProjectile x=new BossProjectile();
                    getWorld().addObject(x,getX()+15,getY()-10);
                    x.selectShot(false);
                    x.diagShot(false);
                    BossProjectile y=new BossProjectile();
                    getWorld().addObject(y,getX()-15,getY()-10);
                    y.selectShot(false);
                    y.diagShot(true);
                    diagShots++;
                    diagonalTimer = 0;    
                }
                diagonalTimer++;
            }
            else{
                reset=true;
            }   
        }
     }
     //Sean
    private void restart(){
        if(reset==true){
            int yPos=getY();
            int xPos=getX();
            if(yPos>3){ //move back up screen
                yPos=yPos-3;
                setLocation(xPos,yPos);
            }
            else{
                reset=false;
                numShots=0;
                landed=false;
                diagShots=0;
            }
        }
    }
    //Vincy
    public void takeDamage()
    {
        // Coded by Sean and Vincy
        Overworld w = (Overworld) getWorld();
        Player p = w.getPlayer();
        if(p.attack && isTouching(Player.class)){
            health--;
            Greenfoot.playSound("neck-snap.mp3");
        }

        if(getOneIntersectingObject(DaliaArrow.class) != null){
            health -= 5;
            Greenfoot.playSound("punch.mp3");
        }
        
        if(health == 0){
            TextBox tb = new TextBox(101);
            w.addObject(tb,400,110);
            SoulStone ss = new SoulStone();
            w.addObject(ss, 397, 360);
            w.removeObject(this);
        }
    }
    //Sean
    public void animate(){
        if(animCounter >= 0 && animCounter < 10){
            setImage("fb0.png");
        }
        else if(animCounter >= 10 && animCounter < 20){
            setImage("fb1.png");
        }
        else if(animCounter >= 20 && animCounter < 30){
            setImage("fb2.png");
        }
        else if(animCounter >= 30 && animCounter < 40){
            setImage("fb3.png");
        }
        else if(animCounter >= 40 && animCounter < 50){
            setImage("fb4.png");
        }
        if(animCounter >= 50){
            animCounter = 0;
        }
        animCounter++;
    }
}