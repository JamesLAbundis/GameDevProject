import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* James coded this class   
**/
class DaliaArrow extends NPC
{   private int count=0;
    private boolean removed=false;
    private boolean direction;
    
    //James
    public DaliaArrow(boolean a){
        direction=a;
        if(direction) setRotation(-90);
        else setRotation(90);
    }
    //James
    public void act(){  
        scrollingMethods();
        move();
        remove();
    }    
    //James
      private void move(){
       if(direction==true)
           {     
               int xPos=getX();
               int yPos=getY();
               if(count!=30){
                   xPos=xPos+7;
                   yPos=yPos-1;
                   setLocation(xPos,yPos);
                   count++;
                }
                else{
                    xPos=xPos+7;
                    yPos=yPos+1;
                    setLocation(xPos,yPos);    
                }
            
        }
        
       if(direction==false){
               int xPos=getX();
               int yPos=getY();
               if(count!=30){
                   xPos=xPos-7;
                   yPos=yPos-1;
                   setLocation(xPos,yPos);
                   count++;
                }
                else{
                    xPos=xPos-7;
                    yPos=yPos+1;
                    setLocation(xPos,yPos);    
                }    
        }

    }
    //James
    private void remove(){
        Overworld w = (Overworld) getWorld();
        if( this.getY()>437||getX()<1||getX()>getWorld().getWidth()-1){
           w.removeObject(this); 
            removed=true;
        }
        
        if(removed==false&&(getOneObjectAtOffset(0,0,Enemy.class)!=null)){
            w.removeObject(this);
            removed=true;
        }
    }    
        
}