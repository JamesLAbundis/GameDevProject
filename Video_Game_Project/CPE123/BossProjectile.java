import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* James coded this class   
**/
public class BossProjectile extends NPC
{   
    private boolean playerHit;
    public boolean typeShot;
    private boolean shotDirection;
    public boolean removed=false;
    
    //James
    public void act(){ 
        shoot();
        remove();
        hit();
    }    
    //James
    public void shoot(){
        if(typeShot==true){
            int yPos=getY();
            if(yPos>0){
                yPos=yPos+5;
                setLocation(getX(),yPos);
            }
        }
        
        if(typeShot==false){
            int xPos= getX();
            int yPos1=getY();
            if(shotDirection==true){
                this.setRotation(45);   
                if(xPos>-1&&(yPos1>0)){
                    xPos=xPos-5;
                    yPos1=yPos1+2;
                    setLocation(xPos,yPos1);
                }
            }
                
            if(shotDirection==false){
                this.setRotation(-45);   
                if(xPos>0){   
                    xPos=xPos+5;
                    yPos1=yPos1+2;
                    setLocation(xPos,yPos1);
                }
            }
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
    public void selectShot(boolean b){    
        typeShot=b;
    }
    //James
    public void diagShot(boolean c){
        shotDirection= c;
    }
    //James   
    private void remove(){
        if( this.getY()>437||getX()<1||getX()>getWorld().getWidth()-1){
            getWorld().removeObject(this); 
            removed=true;
        }
    }
    
}