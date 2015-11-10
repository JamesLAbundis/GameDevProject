import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/** 
* James coded this class   
**/
public class HealthBar extends Actor
{
    public int TotalHealth;
    public static boolean isGameOver;
    public int counter;
    //James
    public HealthBar(int health){
        TotalHealth = health;
    }
    //James
    public void act() 
    {
        Variables.health = TotalHealth;
        updateImage();
        gameOver();
        if(counter > 0){
            counter--;
        }
    }    
    //Nick
    public void normalHit(){
        if(counter == 0){
            TotalHealth -= 1;
            Variables.health -= 1;
            counter = 30;
            Overworld w = (Overworld) getWorld();
            Player p = w.getPlayer();
            p.wasHit();
        }
    }
    //Nick
    public void bossHit(){
        if(counter == 0){
            TotalHealth -= 2;
            Variables.health -= 2;
            counter = 30;
            Overworld w = (Overworld) getWorld();
            Player p = w.getPlayer();
            p.wasHit();
        }
    }
    //James
    public void gainHealth(){
        if(TotalHealth<10){
            if(TotalHealth == 9){
                TotalHealth = 10;
            }
            else{
                TotalHealth += 2;
                Variables.health += 2;
            }
        }
    }
    //Nick
    private void updateImage(){
        if (TotalHealth == 10){
            setImage("healthbar0.png");
        }
        
        if (TotalHealth == 9) {
            setImage("healthbar1.png");
        }
        
        if (TotalHealth == 8) {
            setImage("healthbar2.png");
        }
        
        if (TotalHealth == 7) {
            setImage("healthbar3.png");
        }
        
        if (TotalHealth == 6) {
            setImage("healthbar4.png");
        }
        
        if (TotalHealth == 5) {
            setImage("healthbar5.png");
        }
        
        if (TotalHealth == 4) {
            setImage("healthbar6.png");
        }
        
        if (TotalHealth == 3) {
            setImage("healthbar7.png");
        }
        
        if (TotalHealth == 2) {
            setImage("healthbar8.png");
        }
        
        if (TotalHealth == 1) {
            setImage("healthbar9.png");
        }
        
        if (TotalHealth == 0) {
            setImage("healthbar10.png");
        }
    }
    //James
    public void gameOver(){
        Overworld w = (Overworld)getWorld();
        if (TotalHealth <= 0){
            w.levelMusic.stop();
            w.gameOver();
        }
    }
}
