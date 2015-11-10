import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends NPC
{
    public int health;
    //Vincy
    public Enemy(int health){
        this.health = health;
    }   
    //Nick + Vincy
    public void takeDamage(){
        Overworld w = (Overworld) getWorld();
        Player p = w.getPlayer();
        if(p.attack && (getOneIntersectingObject(Player.class) != null)){
            health--;
        }
        
        if(getOneIntersectingObject(DaliaArrow.class) != null){
            health -= 5;
        }
        
        if(getOneIntersectingObject(MagicFire.class) != null)
        {   
            health--;
        }
        
        if(health == 0){
            dropGems(5);
            if(Variables.hasBow) dropArrows(10);
            w.removeObject(this);
        }
    }
    //James
    public void dropGems(int prob){ 
        if(Greenfoot.getRandomNumber(10)+prob>5){
            Ruby r =  new Ruby();
            getWorld().addObject(r,getX()+10,getY());
        }
        else if(Greenfoot.getRandomNumber(20)+prob>15){
            Sapphire s=new Sapphire();
            getWorld().addObject(s,getX(),getY());
        }
        else if(Greenfoot.getRandomNumber(40)+prob>35){
             Emerald e= new Emerald();
             getWorld().addObject(e,getX()+20,getY());
        }
        else if(Greenfoot.getRandomNumber(50)+prob>46){
            Diamond d = new Diamond();
            getWorld().addObject(d,getX()-10,getY());
        }
    }
    //Arya
    public void dropArrows(int prob){
        if(Greenfoot.getRandomNumber(40)+prob>30){
            ArrowAmmo f = new ArrowAmmo();
            getWorld().addObject(f,getX()+30, getY());
        }
    }
}
