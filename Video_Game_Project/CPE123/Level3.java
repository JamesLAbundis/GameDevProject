import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Level3 extends Overworld
{
    public Portal portal;
    public Player player;
    public FallingPlatform fallingPlatform;
    public Portal p1 = new Portal();
    public Portal p2 = new Portal();
    public Portal p3 = new Portal();
    public Portal p4 = new Portal();
    public Portal p5 = new Portal();
    public Portal p6 = new Portal();
    public Portal p7 = new Portal();
    public Portal p8 = new Portal();
    public Portal p9 = new Portal();
    public Portal p10 = new Portal();
    public Portal p11 = new Portal();
    public Portal p12 = new Portal();
    public Portal p13 = new Portal();
    public Portal p14 = new Portal();
    public Portal p15 = new Portal();
    public Portal p16 = new Portal();
    public Portal p17 = new Portal();
    public Portal p18 = new Portal();
    public Portal p19 = new Portal();
    public Portal p20 = new Portal();
    public Portal p21 = new Portal();
    public Portal p22 = new Portal();
    public Portal p23 = new Portal();
    public Portal p50 = new Portal();
    public Portal p51 = new Portal();
    public Portal p52 = new Portal();
    public Portal p53 = new Portal();
    public Portal p54 = new Portal();
    public Portal p55 = new Portal();
    public Portal p56 = new Portal();
    public Portal p57 = new Portal();
    public Portal p58 = new Portal();
    public Portal p59 = new Portal();
    public Portal p60 = new Portal();
    public Portal p61 = new Portal();

    public FallingPlatform f1 = new FallingPlatform();
    public FallingPlatform f2 = new FallingPlatform();
    public FallingPlatform f3 = new FallingPlatform();
    public FallingPlatform f4 = new FallingPlatform();
    public FallingPlatform f5 = new FallingPlatform();
    public FallingPlatform f6 = new FallingPlatform();
    public FallingPlatform f7 = new FallingPlatform();
    public FallingPlatform f8 = new FallingPlatform();

    public int xPos1 = -1045;
    public int xPos2 = -1125;
    public int xPos3 = -1055;
    public int xPos4 = -125;
    public int xPos5 = 967;
    public int xPos6 = 875;
    public int xPos7 = 820;
    public int yPos1 = 175;
    public int yPos2 = 263;
    public int yPos3 = 363;
    public int yPos4 = 260;
    public int yPos5 = 180;
    public int yPos6 = 320;
    public int yPos7 = 230;
    //John
    public Level3()
    {
        addNew1();
        addNew2();
        addNew3();
        addPlatform2();
        createPortal();
        preLevel2();
        prepare();
        addTallPlat2();
        Variables.Level = "Level 3";
        levelMusic = new GreenfootSound("level1.mp3");
        levelMusic.playLoop();
    }
    //John
    public void preLevel2(){
        Scroller = new Scroller(); addObject(Scroller, 400, -10);
        Player = new Player(); addObject(Player, 200, 364);
        InfoBar = new InfoBar(); addObject(InfoBar, 400, 535);
        playerHealthBar= new HealthBar(Variables.health); addObject(playerHealthBar,210,530);
        moneybag = new MoneyBag(Variables.money); addObject(moneybag,400,530);
        arrowCounter = new ArrowCounter(Variables.arrows); addObject(arrowCounter, 532, 536);

        Sign s1 = new Sign(14); addObject(s1, 282, 362);
        Sign s2 = new Sign(15); addObject(s2, 66, 213);
    }
    //John
    public void addPlatform2(){
        addObject(new Platform2(), 406, 119);
        addObject(new Platform2(), 195, 119);
        addObject(new Platform2(), 800, 100);
        addObject(new Platform2(), 810, 220);
        addObject(new Platform2(), 855, 320);
        addObject(new Platform2(), 967, 180);
        for (int n = 1; n < 6; n++){
            addObject(new Platform2(), n*100+ 1080, 263);}
        for (int n = 1; n < 6; n++){
            addObject(new Platform2(), n*100+ 1080, 119);}
    }
    //John
    public void createPortal(){
        p1.setNextPortal(p2);
        addObject(p1, 384, 350);
        p2.setNextPortal(p3);
        addObject(p2, 205, 202);
        p3.setNextPortal(p1);
        addObject(p3, 530, 350);
        p4.setNextPortal(p8);
        addObject(p4, 1180, 350);
        p5.setNextPortal(p9);
        addObject(p5, 1380, 350);
        p6.setNextPortal(p7);
        addObject(p6, 1580, 350);
        p7.setNextPortal(p12);
        addObject(p7, 1180, 202);
        p8.setNextPortal(p10);
        addObject(p8, 1380, 202);
        p9.setNextPortal(p11);
        addObject(p9, 1580, 202);
        p10.setNextPortal(p5);
        addObject(p10, 1180, 57);
        p11.setNextPortal(p6);
        addObject(p11, 1380, 57);
        p12.setNextPortal(p12);
        addObject(p12, 1580, 57);
        p13.setNextPortal(p13);
        addObject(p13, -187, 57);
        p14.setNextPortal(p13);
        addObject(p14, -320, 202);
        p15.setNextPortal(p16);
        addObject(p15, -680, 57);
        p16.setNextPortal(p15);
        addObject(p16, -680, 202);
    }
    //John
    private void prepare()
    {
        addObject(new Mummy(30, 1), -500, 352);
        addObject(new Mummy(30, 2), 985, 351);
        addObject(new Mage(25),791, 43); 
    }
    //John
    private void addTallPlat2(){
        for (int n = 1; n < 4; n++){
            addObject(new TallPlat2(), 1025, n*100 + 50);
        }
        for (int n = 1; n < 4; n++){
            addObject(new TallPlat2(), 1642, n*96 + 62);
        }
        addObject(new TallPlat2(), 1480, 57);
        for (int n = 0; n < 3; n++){
            addObject(new TallPlat2(), 1117, n*88 + 50);
        }
    }
    //John
    private void addNew1(){
        addObject(new Platform2(), -15, 119);
        addObject(new Mummy(30, 2), 0, 351);
        for (int n = 1; n < 4; n++){
            addObject(new TallPlat2(), 604, n*96 + 62);
        }
        for (int n = 1; n < 4; n++){
            addObject(new TallPlat2(), 457, n*96 + 62);
        }
        for (int n = 2; n < 4; n++){
            addObject(new TallPlat2(), -63, n*55 + 190);
        }
        for (int n = 0; n < 3; n++){
            addObject(new TallPlat2(), -250, n*88 + 50);
        }        
        for (int n = 1; n < 18; n++){
            addObject(new Ground2(), n*100-1000, 437);
        }       
        for (int n = 1; n < 8; n++){
            addObject(new Platform2(), n*100-1000, 263);
        }
        for (int n = 10; n < 13; n++){
            addObject(new Platform2(), n*100-1000, 263);
        }
        addObject(f4, -125, 263);
        addObject(new Platform2(), -1085, 363);
        addObject(f2, -1125, 263);
        addObject(new Platform2(), -1325, 263);
        addObject(f1, -1065, 175);
        addObject(new RedScorpion(4), -750, 212);
        addObject(new Platform2(), -187, 119);
        addObject(new Platform2(), -487, 119);
        addObject(new Platform2(), -687, 119);
        addObject(new TallPlat2(), 1280, 202);
        addObject(new TallPlat2(), 1480, 350);
        addObject(new Mage(25),-484, 63);
        addObject(new Mage(25),-1325, 206);
        for (int n = 1; n < 3; n++){
            addObject(new TallPlat2(), -395, n*88 + 50);
        }
    }

    //Arya
    public void addNew2(){
        for (int n = 1; n < 3; n++){
            addObject(new Platform2(), n*100+ 1700, 300);}
        for (int n = 1; n < 2; n++){
            addObject(new Platform2(), n*100+ 1860, 200);}
        for (int n = 1; n < 3; n++){
            addObject(new Platform2(), n*100+ 1960, 155);}
        addObject(new Mage(25),1960, 155 );
        RedScorpion ss1 = new RedScorpion(1); addObject( ss1, 1940, 370);
        RedScorpion ss2 = new RedScorpion(1); addObject( ss2, 1980, 370);
        for (int n = 1; n < 3; n++){
            addObject(new Platform2(), n*100+ 2150, 290);}
        for (int n = 1; n < 4; n++){
            addObject(new TallPlat2(), 2640, n*95 + 60);
        }
        for (int n = 1; n < 3; n++){
            addObject(new Platform2(), n*100+ 2750, 310);}
        p50.setNextPortal(p51);
        addObject(p50, 2100, 350);
        p51.setNextPortal(p50);
        addObject(p51, 2360, 228);
        p52.setNextPortal(p53);
        addObject(p52, 2580, 350);
        p53.setNextPortal(p52);
        addObject(p53, 2705, 350);
        addObject(new Mage(25),2970, 265 );
        RedScorpion ss3 = new RedScorpion(1); addObject( ss3, 3050, 370);
        addObject(new FallingPlatform(), 3300, 320);
        addObject(new FallingPlatform(), 3100, 250);
        addObject(new FallingPlatform(), 3300, 180);
        for (int n = 1; n < 3; n++){
            addObject(new Platform2(), n*100+ 3350, 110);}       
        for (int n = 1; n < 4; n++){
            addObject(new TallPlat2(), 3600, n*100 + 50);
        }
        for (int n = 1; n < 4; n++){
            addObject(new TallPlat2(), 3900, n*100 + 50);
        }
        addObject(new FallingPlatform(), 4170, 320);
        addObject(new FallingPlatform(), 4300, 250);
        addObject(new FallingPlatform(), 4170, 160);
        addObject(new Mummy(30,1),3520, 360 );
        addObject(new Mage(25),3640, 360 );
        p54.setNextPortal(p55);
        addObject(p54, 3820, 350);
        p55.setNextPortal(p54);
        addObject(p55, 3990, 350);
        p56.setNextPortal(p57);
        addObject(p56, 4300, 350);
        p57.setNextPortal(p56);
        addObject(p57, 4500, 350);
        for (int n = 1; n < 36; n++){
            addObject(new Ground2(), n*100 + 800, 437);
        }
        for (int n = 37; n < 400; n++){
            addObject(new Ground2(), n*100 + 800, 437);
        }
        for (int n = 1; n < 2; n++){
            addObject(new Platform2(), n*100+ 4600, 300);}
        for (int n = 1; n < 2; n++){
            addObject(new Platform2(), n*100+ 4740, 190);}   
        addObject(new Mummy(30,1),4700, 360 );     
        for (int n = 1; n < 6; n++){
            addObject(new TallPlat2(), 5150, n*100 - 60);
        }
        for (int n = 1; n < 3; n++){
            addObject(new Platform2(), n*100+ 4900, 120);}
        for (int n = 1; n < 3; n++){
            addObject(new Platform2(), n*100+ 4900, 265);}   
        for (int n = 1; n < 3; n++){
            addObject(new Platform2(), n*100+ 4900, 390);}   
        p58.setNextPortal(p59);
        addObject(p58, 5000, 60);
        p59.setNextPortal(p58);
        addObject(p59, 5000, 332);
        p60.setNextPortal(p61);
        addObject(p60, 5000, 206);
        p61.setNextPortal(p60);
        addObject(p61, 5250, 350);
        FinalBoss fb = new FinalBoss(500); addObject(fb, 6100, 20);
        BossBattleInit bbi = new BossBattleInit(); addObject(bbi, 6500, -10);
    }

    //John
    public void addNew3(){
        addObject(new HealthPotion(), 1000, 350);
        addObject(new HealthPotion(), 762, 55);
        addObject(new FallingPlatform(), -1420, 155);
        addObject(new FallingPlatform(), -1250, 75);
        addObject(new HealthPotion(), -1275, 210);
        addObject(new HealthPotion(), -100, 350);
        addObject(new HealthPotion(), 4170, 130);
        addObject(new HealthPotion(), 5200, 350);
    }
}