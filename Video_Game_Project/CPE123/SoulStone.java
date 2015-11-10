import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* John coded this class   
**/
public class SoulStone extends NPC
{
    public World world;
    public int incTransp = 0;
    //John
    public SoulStone(){
        GreenfootImage image = getImage();
        setImage(image);
    }
    //John
    public void act() {
      scrollingMethods();
      spawnT();
      pickedUp();
    }
    //John
    public void spawnT(){
        if (incTransp < 255){
            incTransp += 1;
        }
        GreenfootImage image = getImage();
        image.setTransparency(incTransp);
        
    }
    //John
    public void pickedUp(){
        Overworld World = (Overworld) getWorld();
        Player player = World.getPlayer();
        if(incTransp > 200 && player.pickUp == true && (getOneObjectAtOffset(15,0,Player.class) != null || getOneObjectAtOffset(-15,0,Player.class) != null) && Variables.Level == "Level 3"){
            World.removeObject(this); 
            Father f = new Father();
            World.addObject(f, 655, 350);
            Greenfoot.delay(200);
            Win w = new Win();
            Greenfoot.setWorld(w); 
            
        }
        else if(incTransp > 200 && player.pickUp == true && (getOneObjectAtOffset(15,0,Player.class) != null || getOneObjectAtOffset(-15,0,Player.class) != null) ){
            World.levelMusic.stop();
            World.removeObject(this); 
            Greenfoot.delay(100);
            Shop s = new Shop();
            Greenfoot.setWorld(s); 
        }
    }
    
}