import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* James coded this class   
**/
public class ArrowCounter extends Actor
{
    private int arrows;
    //James
    public ArrowCounter(int arrows){
        this.arrows = arrows;
    }
    //James
    public void act() 
    {
        update(); 
    }    
    //James
    private void update(){
        String arrowAmount=("= "+arrows);
        Overworld w= (Overworld)getWorld();
        w.showText(arrowAmount,getX()+55, getY());
    }    
    //James
    public void addArrow(int a){
        arrows=arrows+a;
    }
    //James
    public void subtractArrow(int b){
      if(arrows>0)
      {
          arrows=arrows-1;
        }
    }
    //James
    public int getArrows(){
        return arrows;
    }
}