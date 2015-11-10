import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Father extends Scenery
{
  public int incTransp = 0;
  
  public void act() {
      spawnT();
      scrollingMethods();
    }
 
  public void spawnT(){
      GreenfootImage image = getImage();
      image.setTransparency(incTransp);  
      if (incTransp < 255){
            incTransp += 1;
        }
    }
}
