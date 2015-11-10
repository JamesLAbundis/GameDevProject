import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/** 
* James coded this class   
**/
public class FinalBoss extends Boss
{   private int numShots=0;
    public boolean swap;
    public boolean stop=false;
    public boolean touchDown=false;
    public boolean reset=false;
    public boolean movetoAttack=false;
    public boolean spawned=false;
    public int sideshotCounter=0;
    public int count=0;
    public int fireCount;
    public int coyoteCount;
    //James
   public FinalBoss(int health){
       super(health);
    }
    //James
    public void act() {
        scrollingMethods();
        Overworld w=(Overworld)getWorld();
        if(w.bossBattle){        
            spawnSkeletons();
            fire();
            movetoStop();
            sideToSide();
            comeDown();
            restart();
            takeDamage();
        }     
   }
   //James
   private void sideToSide(){
        int yPos=getY();
        int xPos=getX();
        if(checkForSkeletons()){   
          if(count<200){
            xPos=xPos+1;
            setLocation(xPos,yPos);
            count++;
            }
            
          else if(count<300 ){ 
            yPos=yPos+1;
            setLocation(xPos,yPos);
            count++;
               }
          else if(count<500){
            xPos=xPos-1;
            setLocation(xPos,yPos);
            count++;
            }
            
          else if(count<600)  {
            yPos=yPos-1;
            setLocation(xPos,yPos);
            count++;
            }
          else{
              count=0;
            }
        
       }
       
       else{
           movetoAttack=true;
       }
   }
    //Arya
    private void spawnSkeletons(){
     if(spawned==false){   
      Overworld g=(Overworld)getWorld();
      for(int i=0;i<3;i++){
          g.addObject(new Skeleton(20), (i*70),355);
        }
      for(int i=0;i<3;i++){
          g.addObject(new Skeleton(20), 650 + (i*70),355);
        }  
        spawned=true;
    }
   }
    //John
       private void movetoStop(){
       if(getY()<120)
       {setLocation(getX(),getY()+1); 
        }
        else{
           stop=true; 
        }
    }
    //James
    private void fire(){
        Overworld world=(Overworld)getWorld();   
        if(touchDown != true){  
            if(fireCount==230){
               FinalBossWeapons z= new FinalBossWeapons(false);
               world.addObject(z,getX(),getY());
               numShots++;
               fireCount=0;
            }
            fireCount++;
       }
       if(touchDown == true){
            if(sideshotCounter < 10){  
                if(fireCount >= 250){
                    FinalBossWeapons f = new FinalBossWeapons(true);
                    f.setDirection(true);
                    world.addObject(f,getX(),getY());
                    sideshotCounter++;
                    
                    FinalBossWeapons g = new FinalBossWeapons(true);  
                    g.setDirection(false);
                    world.addObject(g,getX(),getY());
                    fireCount=0;
                    sideshotCounter++;   
                }
                fireCount++;
            }  
            else{
                reset = true;
          }
       }
    }
    //James
    public boolean checkForSkeletons(){
        Overworld w = (Overworld)getWorld();
        List<Skeleton>myList = w.getObjects(Skeleton.class);
        if (myList.isEmpty()){
            return false;
        }
        return true;    
        //Returns true if there are no more skeletons in the world.
    }
    //James
    private void comeDown(){
        int xpos = getX();
        int ypos = getY();
        if(movetoAttack == true){ 
            if(ypos<356){
                setLocation(xpos,ypos+1);
            }
            else{
                touchDown = true;
            }
        }
    }
  //John
    public void restart(){
    if(reset==true){
        int yPos = getY();
        int xPos = getX();
        if(yPos>3){
            yPos=yPos-3;
            setLocation(xPos,yPos);
        }
        else{
             reset=false;
             spawned=false;
             movetoAttack=false;
             numShots=0;
             stop=false;
             touchDown=false;
             sideshotCounter=0;
             count=0;
        }
     }
  }
  //Sean + Vincy
  public void takeDamage(){
        Overworld w = (Overworld) getWorld();
        Player p = w.getPlayer();
        if(p.attack && isTouching(Player.class)){
            health--;
            Greenfoot.playSound("pain.mp3");
        }
        if(getOneIntersectingObject(DaliaArrow.class) != null){
            health -= 5;
            Greenfoot.playSound("punch.mp3");
        }
        if(health == 0){
            TextBox tb = new TextBox(102);
            w.addObject(tb,400,110);
            SoulStone ss = new SoulStone();
            w.addObject(ss, 397, 360);
            w.removeObject(this);
            
        }
    }
} 