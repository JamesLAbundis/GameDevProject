import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* James coded this class   
**/
public class Arrow extends NPC
{
   private int count=0;
   private boolean removed=false;
    //James
   public void act(){
       scrollingMethods(); 
       setRotation(90);
        move();
        remove();
        hit();
   }    
    //James
   private void move(){
       int xPos=getX();
       int yPos=getY();
       if(count!=60){
           xPos=xPos-5;
           yPos=yPos-1;
           setLocation(xPos,yPos);
           count++;
       }
       else{
           xPos=xPos-5;
           yPos=yPos+2;
           setLocation(xPos,yPos);    
       }
   }
   //James
   public void hit(){
        if(removed==false){
            Overworld World = (Overworld) getWorld();
            Player Player = World.getPlayer();
            if (getOneIntersectingObject(Player.class) != null){
                HealthBar playerHealthBar = World.getHealthBar();
                playerHealthBar.normalHit();
                World.removeObject(this);
            }
        }
   }
   //James
   private void remove(){
        if( this.getY()>437||getX()<1||getX()>getWorld().getWidth()-1){
            getWorld().removeObject(this); 
            removed=true;
        }
   }
}