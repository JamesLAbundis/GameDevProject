import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Player extends Scroller
{
    private GreenfootImage[] rightAnim = new GreenfootImage[4];
    private GreenfootImage[] leftAnim = new GreenfootImage[4];;
    private GreenfootImage[] jumpAnim = new GreenfootImage[2];
    private GreenfootImage[] rightAttackAnim = new GreenfootImage[3];
    private GreenfootImage[] leftAttackAnim = new GreenfootImage[3];
    private GreenfootImage[] Animation = new GreenfootImage[2];
    private GreenfootImage[] bowRightAttack = new GreenfootImage[1];
    private GreenfootImage[] magicRightAttack = new GreenfootImage[1];
    private GreenfootImage[] bowLeftAttack = new GreenfootImage[1];
    private GreenfootImage[] magicLeftAttack = new GreenfootImage[1];
    private int currentImage = 0;
    private int direction; //0 is right, 1 is left
    private int animCounter = 0;
    public int playerSpeed = 0;
    private int fallSpeed = 0;
    public int acceleration = 1;
    private int jumpHeight = -22;
    private int attackCounter;
    private int hitCounter;
    public boolean wasHit;
    public int zCount = 0;
    public boolean pickUp;
    public boolean attack;
    public boolean stuck;
    public int magicCounter = 60;
    public boolean teleported;
    public Portal portal;
    private int teleTimer = 0;
    public boolean faceDirection;
    
    //Vincy
    public void act(){
        checkKeyPress();
        animate();
        checkGround();
        collisions();
        if(Variables.Level == "Level 3"){
            spawnE();
        }
    }
    //Nick
    public Player(){
        Animation[0] = new GreenfootImage("dalia-r.png");
        Animation[1] = new GreenfootImage("dalia-left.png");
        rightAnim[0] = new GreenfootImage("dalia-r2.png");
        rightAnim[1] = new GreenfootImage("dalia-r3.png");
        rightAnim[2] = new GreenfootImage("dalia-r4.png");
        rightAnim[3] = new GreenfootImage("dalia-r5.png");
        leftAnim[0] = new GreenfootImage("dalia-left2.png");
        leftAnim[1] = new GreenfootImage("dalia-left3.png");
        leftAnim[2] = new GreenfootImage("dalia-left4.png");
        leftAnim[3] = new GreenfootImage("dalia-left5.png");
        jumpAnim[0] = new GreenfootImage("dalia-r_jump.png");
        jumpAnim[1] = new GreenfootImage("dalia-left_jump.png");
        rightAttackAnim[0] = new GreenfootImage("dalia-r_attack.png");
        rightAttackAnim[1] = new GreenfootImage("dalia-r_attack.png");
        rightAttackAnim[2] = new GreenfootImage("dalia-r_attack.png");
        leftAttackAnim[0] = new GreenfootImage("dalia-left_attack.png");
        leftAttackAnim[1] = new GreenfootImage("dalia-left_attack.png");
        leftAttackAnim[2] = new GreenfootImage("dalia-left_attack.png");
        bowRightAttack[0] = new GreenfootImage("dalia-r_attack_bow.png");
        bowLeftAttack[0] = new GreenfootImage("dalia-l_attack_bow.png");
        magicLeftAttack[0] = new GreenfootImage("dalia-l_attack_magic.png");
        magicRightAttack[0] = new GreenfootImage("dalia-r_attack_magic.png");
    }
    //Nick + Arya + John
    public void checkKeyPress(){
        Overworld w = (Overworld) getWorld();
        Scroller s = (Scroller) w.getScroller();
        if(Greenfoot.isKeyDown("left") && s.shouldScroll == false && !stuck){
            playerSpeed = -3;
            move(playerSpeed);
        }

        if(Greenfoot.isKeyDown("right") && s.shouldScroll == false && !stuck){
            playerSpeed = 3;
            move(playerSpeed);
        }

        if(direction == 0) faceDirection = true;
        else faceDirection = false;
        
        if(Greenfoot.isKeyDown("up") && onGround() == true && !stuck){
            jump();
        }

        if(w.bossBattle){
            if(getX() < 10){
                setLocation(getX() + 3, getY());
            }
            if(getX() > w.getWidth() - 5){
                setLocation(getX() - 3, getY());
            }
        }

        String key = Greenfoot.getKey();  
        if(zCount > 0){
            zCount = zCount - 1;
        }
        else if("z".equals(key)){
            attack = true;
            Greenfoot.playSound("sounds/sword1.mp3");
            zCount = 30;
        }

        if(attack){
            if(attackCounter == 21){
                attack = false;
                attackCounter = 0;
            }
            attackCounter++;

        }

        if(Variables.hasBow){
            ArrowCounter b = w.getArrowCounter();
            int arrow=b.getArrows();
            if(Greenfoot.isKeyDown("x") && checkForArrow() && arrow != 0){ 
                Greenfoot.playSound("sounds/ShootArrow.wav");
                DaliaArrow a = new DaliaArrow(faceDirection);
                getWorld().addObject(a,getX()+10,getY());  
                b.subtractArrow(1);

            }
        }

        if(Variables.hasMagic){
            if("c".equals(key)){ 
                if(magicCounter >= 200){
                    Magic m = new Magic();
                    w.addObject(m, getX(), getY());
                    magicCounter = 0; 
                }
            }
            magicCounter++;
        }

        Portal portal = (Portal)getOneIntersectingObject(Portal.class);
        if(teleTimer > 0){
            teleported = false;
            teleTimer -= 1;
        }
        else if(Greenfoot.isKeyDown("v") && portal != null){
            Portal next = portal.getNextPortal();
            setLocation(next.getX(), next.getY());
            teleported = true;
            teleTimer = 50;
        }   

        if("v".equals(key)){
            pickUp = true;
        }
        else{
            pickUp = false;
        }
    }   
    //Vincy + Sean
    public void animate(){
        String key = Greenfoot.getKey();

        //animates the player when running
        if (Greenfoot.isKeyDown("right") && onGround()){
            if(animCounter == 5){
                currentImage = (currentImage + 1) % rightAnim.length;
                /*if (currentImage == 0){
                currentImage++;
                }*/
                setImage(rightAnim[currentImage]);
                animCounter = 0;
            }
            animCounter++;
        }

        if (Greenfoot.isKeyDown("left") && onGround()){
            if (animCounter == 5){
                currentImage = (currentImage + 1) % leftAnim.length;
                /*if (currentImage == 0){
                currentImage++;
                }*/
                setImage(leftAnim[currentImage]);
                animCounter = 0;
            }
            animCounter++;
        }

        //sets the direction the player is facing
        if(Greenfoot.isKeyDown("right")) direction = 0;
        if(Greenfoot.isKeyDown("left")) direction = 1;

        //jumping animation setters
        if(Greenfoot.isKeyDown("up") && fallSpeed < 0 && direction == 0){
            setImage(jumpAnim[0]);
            if (onGround() != true) setImage(jumpAnim[0]);
        }

        if(fallSpeed > 0 && direction == 0){
            setImage(jumpAnim[0]);
        }

        if(Greenfoot.isKeyDown("up") && fallSpeed < 0 && direction == 1){
            setImage(jumpAnim[1]);
        }

        if(fallSpeed > 0 && direction == 1){
            //setImage(jumpAnim[3]);
            if(onGround()) setImage(leftAnim[0]);
        }

        //sets the player back to a static image after running
        if ((Greenfoot.isKeyDown("right") != true) && direction == 0 && onGround()){
            setImage(Animation[0]);
        }

        if ((Greenfoot.isKeyDown("left") != true) && direction == 1 && onGround()){
            setImage(Animation[1]);
        }

        //attack animations
        if(attack){
            if(direction == 0){
                setImage(rightAttackAnim[0]);
                if (attackCounter >= 7 && attackCounter < 14){
                    setImage(rightAttackAnim[1]);
                }
                else if(attackCounter >= 14){
                    setImage(rightAttackAnim[2]);
                }
            }
            else if(direction == 1){
                setImage(leftAttackAnim[0]);
                if (attackCounter >= 7 && attackCounter < 14){
                    setImage(leftAttackAnim[1]);
                }
                else if(attackCounter >= 14){
                    setImage(leftAttackAnim[2]);
                }
            }
        }

        //bow attack animation
        if (Greenfoot.isKeyDown("x") && direction == 0 && Variables.hasBow)
        {
            setImage(bowRightAttack[0]);
        } else if (Greenfoot.isKeyDown("x") && direction == 1 && Variables.hasMagic)
        {
            setImage(bowLeftAttack[0]);
        }

        // magic attack animation
        if(Variables.hasMagic){
            if (Greenfoot.isKeyDown("c") && direction == 0){
                setImage(magicRightAttack[0]);
            } 
            else if (Greenfoot.isKeyDown("c") && direction == 1){
                setImage(magicLeftAttack[0]);
            }
        }

        //ensures the player's animation won't bug out when both left and right are pressed
        if(Greenfoot.isKeyDown("right") && Greenfoot.isKeyDown("left")){
            setImage(rightAnim[0]);
        }

        if(wasHit){
            hitCounter++;
            GreenfootImage i = getImage();
            if(hitCounter > 0 && hitCounter < 10) i.setTransparency(100);
            else if(hitCounter >= 10 && hitCounter < 20) i.setTransparency(255);
            else if(hitCounter >= 20 && hitCounter < 30) i.setTransparency(100);
            else{
                i.setTransparency(255);
                wasHit = false;
                hitCounter = 0;
                for(int n = 0; n <= 1; n++){
                    GreenfootImage rimg = rightAnim[n];
                    GreenfootImage limg = leftAnim[n];
                    GreenfootImage simg = Animation[n];
                    GreenfootImage jimg = jumpAnim[n];
                    jimg.setTransparency(255);
                    rimg.setTransparency(255);
                    limg.setTransparency(255);
                    simg.setTransparency(255);
                }
                for(int n = 0; n <= 3; n++){
                    GreenfootImage rimg = rightAnim[n];
                    GreenfootImage limg = leftAnim[n];
                    rimg.setTransparency(255);
                    limg.setTransparency(255);
                }
                for(int x = 0; x <= 2; x++){
                    GreenfootImage ratk = rightAttackAnim[x];
                    GreenfootImage latk = leftAttackAnim[x];
                    ratk.setTransparency(255);
                    latk.setTransparency(255);
                }
            }
        }

    }
    //Vincy
    public void collisions(){
        Actor rcollide = getOneObjectAtOffset(20, 0, Tile.class);
        Actor lcollide = getOneObjectAtOffset(-20, 0, Tile.class);
        Actor tcollide = getOneObjectAtOffset(0, -20, Tile.class);
        if(rcollide != null){
            setLocation(getX() - 3, getY());
        }
        if(lcollide != null){
            setLocation(getX() + 3, getY());
        }
        if(tcollide != null){
            setLocation(getX(), getY() + 10);
            fallSpeed = 0;
        }
    }
    //Vincy
    public void checkGround(){
        if(onGround()){
            fallSpeed = 0;
        }
        else{
            gravity();
        }
        if(getY() > 800){
            Overworld World = (Overworld) getWorld();
            World.gameOver();
        }
    }
    //Vincy
    public boolean onGround(){
        Actor under = getOneObjectAtOffset(0 , 38, Tile.class); 
        return under != null; 
    }
    //Vincy
    public void gravity(){
        fallSpeed += acceleration;
        setLocation(getX(), getY() + (fallSpeed/2));
    }
    //Vincy
    public void jump(){
        fallSpeed = jumpHeight;
        gravity();
    }
    //Vincy
    public void wasHit(){
        wasHit = true;
    }
    //Vincy
    public boolean checkForArrow(){
        List<DaliaArrow>myList=getObjectsInRange(120,DaliaArrow.class);
        int amount=myList.size();
        if(amount>0){
            return false;
        }

        return true;
    }
    //John
        public void spawnE(){
        Overworld world = (Overworld) getWorld();
        Portal portal = (Portal) getOneIntersectingObject(Portal.class);
        Portal next;
        Level3 level2 = (Level3) getWorld();
        
        if (teleported == true){
            next = portal.getNextPortal();
            
            if(next == level2.p3){
              Portal portaltemp = level2.p3;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            
            if(next == level2.p16){
                Portal portaltemp = level2.p16;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            
            if(next == level2.p4){
                Portal portaltemp = level2.p8;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            
            if(next == level2.p9){
                Portal portaltemp = level2.p4;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            
            if(next == level2.p10){
                Portal portaltemp = level2.p9;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            
            if(next == level2.p11){
                Portal portaltemp = level2.p8;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            
            if(next == level2.p13){
                Portal portaltemp = level2.p14;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            
            if(next == level2.p15){
                Portal portaltemp = level2.p16;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p51)
            {
                Portal portaltemp = level2.p53;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p50)
            {
                Portal portaltemp = level2.p52;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p52)
            {
                Portal portaltemp = level2.p50;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p53)
            {
                Portal portaltemp = level2.p51;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p54)
            {
                Portal portaltemp = level2.p56;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p55)
            {
                Portal portaltemp = level2.p57;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p56)
            {
                Portal portaltemp = level2.p54;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p57)
            {
                Portal portaltemp = level2.p55;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p58)
            {
                Portal portaltemp = level2.p60;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p59)
            {
                Portal portaltemp = level2.p61;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p60)
            {
                Portal portaltemp = level2.p58;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
            if (next == level2.p61)
            {
                Portal portaltemp = level2.p59;
                world.addObject(new RedScorpion(40), portaltemp.getX(), portaltemp.getY());
            }
        }
    }
}
