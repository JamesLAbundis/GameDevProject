import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* James coded this class   
**/
public class FinalBossWeapons extends NPC
{
  
   public  boolean selectShot;
   public boolean direction;
   public boolean playerChecked=false;
   public boolean removed;
   public static int playerxpos;
   public static int playerypos;
   public int lockshotTimer=0;
   //James
    public FinalBossWeapons(boolean select){
        selectShot = select;
    }
    //James
    public void act() 
    {
      scrollingMethods();
      //true = side shot------false = lockshot
      sideShot();
      lockShot();
      hit();
    
    }    
    //James
    private void sideShot(){
        //true is left false is right
       
        int xPos= getX();
        int yPos=getY();
        if(selectShot == true){
            if(direction == false){
                
                xPos= xPos+3;
               setLocation(xPos, yPos);
            }
            if(direction==true){
              
                xPos=xPos-3;
               setLocation(xPos, yPos);
            }
        }
   }
   //James
   private void lockShot(){
      Overworld World = (Overworld)getWorld();  
      if(selectShot == false){ 
          if(lockshotTimer!=250){
              lockshotTimer++;
          }
          else{
              World.removeObject(this);
              removed=true;
          }
          if(playerChecked!=true){
              checkPlayer();
         
          }
          turnTowards(playerxpos,playerypos);
          move(2); 
    }
}
    //James
    private void hit(){
      Overworld World = (Overworld) getWorld();
        if(removed!=true)
           { Player Player = World.getPlayer();
            if (getOneIntersectingObject(Player.class) != null){
                HealthBar playerHealthBar = World.getHealthBar();
                playerHealthBar.normalHit();
                World.removeObject(this);
            }
        
            else if(getY() > 440/*||getX()>1||getX()>World.getWidth()-2*/) World.removeObject(this);
            }
        }
        //James
  public void checkPlayer(){
  Overworld World = (Overworld) getWorld();
  Player p = World.getPlayer();
  playerxpos= p.getX();
  playerypos=p.getY();
  playerChecked=true;  
    }
    //James
    public void setDirection(boolean b){
      direction=b;  
    }
}