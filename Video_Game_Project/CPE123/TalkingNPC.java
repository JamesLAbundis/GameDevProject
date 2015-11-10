import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** 
* Sean coded this class   
**/
public class TalkingNPC extends NPC
{
  int npcNumber;
  TextBox TextBox;
  public boolean read;
  public String string;
  //Sean
  public TalkingNPC(int number){
    this.npcNumber = number;
  }
  //Sean
  public void act(){
    scrollingMethods();
    readHelpful();
  }    
   //Sean
  public void readHelpful(){
    Overworld World = (Overworld) getWorld();
    Player player = World.getPlayer();
    if(read == false && (getOneObjectAtOffset(50,0,Player.class) != null || getOneObjectAtOffset(-50,0,Player.class) != null)){
        TextBox = new TextBox(npcNumber);
        World.addObject(TextBox,400,110);
        read = true;
    } 
    if(TextBox != null && read == true && (getOneObjectAtOffset(125,0,Player.class) != null || getOneObjectAtOffset(-125,0,Player.class) != null)){ 
            World.removeObject(TextBox);
            read = false;
    }
    if(getX() - player.getX() > 100 || player.getX() - getX() > 100){
            World.removeObject(TextBox);
            read = false;
        }
  }
}