import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class PyramidScenery extends Scenery
{
   //Nick
   public void act(){
       scrollingMethods();
       if(getOneIntersectingObject(Player.class) != null){
           Overworld w = (Overworld)getWorld();
           w.levelMusic.stop();
           Greenfoot.delay(60);
           Level3 level3 = new Level3();
           Greenfoot.setWorld(level3);
       }
    }
}
