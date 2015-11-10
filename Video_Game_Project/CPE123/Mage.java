import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Nick coded this class   
**/
public class Mage extends Enemy
{
    private int counter;
    private GreenfootImage[] Animation = new GreenfootImage[6];
    private int health;
    private String direction;
    
    public Mage(int health){
        super(health);
  
        for (int i=0; i < 6; i++){
            Animation[i] = new GreenfootImage("jafar" + i + ".png");
        }
    }
    //Nick
    public void act() 
    {
        scrollingMethods();
        setDirection();
        shoot();
        takeDamage();
    }
    //Nick
    public void shoot(){
        Overworld w = (Overworld) getWorld();
        Player p = w.getPlayer();
        if(getX() - p.getX() <= 600 && direction == "left"){
            counter++;
            if (counter == 100){ 
                setImage(Animation[1]);
            }
            if (counter == 150){ 
                setImage(Animation[2]);
                Fireball f = new Fireball();
                Greenfoot.playSound("sounds/mageFire.wav");
                w.addObject(f, getX(), getY());
            }
            if (counter == 175){
                setImage(Animation[0]);
                counter = 0;
            }
        }
        if(getX() - p.getX() >= -600 && direction == "right"){
            counter++;
            if (counter == 100){ 
                setImage(Animation[4]);
            }
            if (counter == 150){
                setImage(Animation[5]);
                Fireball f = new Fireball();
                Greenfoot.playSound("sounds/mageFire.wav");
                w.addObject(f, getX(), getY());
                f.turn(180);
            }
            if (counter == 175){
                setImage(Animation[3]);
                counter = 0;
            }
        }
    }
    //Nick
    public void setDirection(){
        Overworld w = (Overworld) getWorld();
        Player p = w.getPlayer();
        if(getX() - p.getX() > 0){
            direction = "left";
        }
        else if(getX() - p.getX() < 0){
            direction = "right";
        }
    }
}
