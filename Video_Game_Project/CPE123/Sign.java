import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Nick coded this class   
**/
public class Sign extends NPC
{
    int signNumber; 
    TextBox TextBox;
    public boolean read;
    public String string;
    //Nick
    public Sign(int number){
        signNumber = number;
    }
    //Nick
    public void act(){
        scrollingMethods();
        readSign();
    }
    //Nick
    public void readSign(){
        Overworld World = (Overworld) getWorld();
        Player player = World.getPlayer();       
        if(read == false && (getOneObjectAtOffset(50,0,Player.class) != null || getOneObjectAtOffset(-50,0,Player.class) != null)){
            TextBox = new TextBox(signNumber);
            World.addObject(TextBox,400,110);
            read = true;
        }
        if(getX() - player.getX() > 100 || player.getX() - getX() > 100){
            World.removeObject(TextBox);
            read = false;
        }
    }
}
