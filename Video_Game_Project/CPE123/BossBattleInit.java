import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Nick coded this class   
**/
public class BossBattleInit extends NPC
{
    private boolean initiated;
    private boolean musicPlayed;
    //Nick
    public void act(){
        bossBattle();
        scrollingMethods();
    }
    //Nick
    public void bossBattle(){
        Overworld w = (Overworld) getWorld();
        Player p = w.getPlayer();
        if(getX() - p.getX() <= 400){
            w.setBossBattle(1);
            if(!musicPlayed){
                w.levelMusic.stop();
                w.levelMusic = new GreenfootSound("level2.mp3");
                w.levelMusic.playLoop();
                musicPlayed = true;
            }
        }
    }
}
