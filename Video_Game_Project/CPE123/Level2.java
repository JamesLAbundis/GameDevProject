import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/** 
* Sean coded this class   
**/
public class Level2 extends Overworld
{ 
    //Sean
    public Level2(){
        Variables.Level = "Level 2";
        prepare();
        levelMusic = new GreenfootSound("level1.mp3");
        levelMusic.playLoop();
    }
    //Sean
    public void prepare(){
        Player = new Player();
        Scroller = new Scroller(); addObject(Scroller, 400, -10);
        InfoBar = new InfoBar();
        playerHealthBar= new HealthBar(Variables.health);
        moneybag = new MoneyBag(Variables.money);
        arrowCounter = new ArrowCounter(Variables.arrows);
        addWater();
        Bush b1 = new Bush(); addObject(b1, 200, 346);
        Bush b2 = new Bush(); addObject(b2, 600, 346);
        Bush b3 = new Bush(); addObject(b3, 1520, 346);
        Bush b4 = new Bush(); addObject(b4, 3540, 346);
        Sign s7 = new Sign(7); addObject(s7, 150, 331);
        Sign s8 = new Sign(8); addObject(s8, 670, 331);
        Sign s9 = new Sign(9); addObject(s9, 1200, 331);
        Sign s10 = new Sign(10); addObject(s10, 5520, 331);
        Sign s11 = new Sign(11); addObject(s11, 6300, 331);
        Mage mage1 = new Mage(30); addObject(mage1, 4853, 17);
        Mage mage2 = new Mage(30); addObject(mage2, 1840, 254);
        Mage mage3 = new Mage(30); addObject(mage3, 6100, 325);
        Archer a1 = new Archer(30); addObject(a1, 3640, 329);
        Pioneer p1 = new Pioneer(30); addObject(p1, 5850, 325);
        Pioneer p2 = new Pioneer(30); addObject(p2, 5590, 325);
        Archer a2 = new Archer(30); addObject(a2, 6125, 231);
        Platform p100 = new Platform(); addObject(p100, 30, 380);
        Platform p101 = new Platform(); addObject(p101, 129, 380);
        Platform p102 = new Platform(); addObject(p102, 228, 380);
        Platform p103 = new Platform(); addObject(p103, 529, 380);
        Platform p104 = new Platform(); addObject(p104, 629, 380);
        Platform p105 = new Platform(); addObject(p105, 1200, 380);
        Platform p106 = new Platform(); addObject(p106, 1520, 380);
        Platform p107 = new Platform(); addObject(p107, 1635, 310);
        Platform p108 = new Platform(); addObject(p108, 1840, 310);
        Platform p109 = new Platform(); addObject(p109, 2175, 320);
        Platform p110 = new Platform(); addObject(p110, 2275, 250);
        Platform p111 = new Platform(); addObject(p111, 2370, 170);
        Platform p112 = new Platform(); addObject(p112, 2620, 380);
        Platform p11205 = new Platform(); addObject(p11205, 3180, 380);
        Platform p113 = new Platform(); addObject(p113, 3380, 380);
        Platform p114 = new Platform(); addObject(p114, 2980, 300);
        Platform p115 = new Platform(); addObject(p115, 2800, 350);
        Platform p116 = new Platform(); addObject(p116, 3480, 380);
        Platform p117 = new Platform(); addObject(p117, 3580, 380);
        Platform p118 = new Platform(); addObject(p118, 3680, 380);
        Platform p119 = new Platform(); addObject(p119, 4490, 380);
        Platform p120 = new Platform(); addObject(p120, 4590, 357);
        Platform p121 = new Platform(); addObject(p121, 4688, 334);
        Platform p122 = new Platform(); addObject(p122, 4787, 310);
        Platform p123 = new Platform(); addObject(p123, 4874, 255);
        Platform p124 = new Platform(); addObject(p124, 4730, 207);
        Platform p125 = new Platform(); addObject(p125, 4631, 185);
        Platform p126 = new Platform(); addObject(p126, 4537, 163);
        Platform p127 = new Platform(); addObject(p127, 4479, 101);
        Platform p128 = new Platform(); addObject(p128, 4630, 49);
        Platform p129 = new Platform(); addObject(p129, 4819, 72);
        Platform p130 = new Platform(); addObject(p130, 5500, 380);
        Platform p131 = new Platform(); addObject(p131, 5600, 380);
        Platform p132 = new Platform(); addObject(p132, 5700, 380);
        Platform p133 = new Platform(); addObject(p133, 5800, 380);
        Platform p134 = new Platform(); addObject(p134, 5900, 380);
        Platform p135 = new Platform(); addObject(p135, 6000, 380);
        Platform p136 = new Platform(); addObject(p136, 6100, 380);
        Platform p137 = new Platform(); addObject(p137, 6200, 380);
        Platform p138 = new Platform(); addObject(p138, 6300, 380);
        Platform p139 = new Platform(); addObject(p139, 5700, 283);
        Platform p140 = new Platform(); addObject(p140, 5800, 283);
        Platform p141 = new Platform(); addObject(p141, 5900, 283);
        Platform p142 = new Platform(); addObject(p142, 6000, 283);
        Platform p143 = new Platform(); addObject(p143, 6100, 283);
        Platform p144 = new Platform(); addObject(p144, 6700, 277);
        Platform p145 = new Platform(); addObject(p145, 7100, 177);
        Platform p146 = new Platform(); addObject(p146, 7200, 177);
        Platform p147 = new Platform(); addObject(p147, 7910, 177);
        Platform p148 = new Platform(); addObject(p148, 8010, 177);
        Platform p149 = new Platform(); addObject(p149, 5000, 218);
        Platform p150 = new Platform(); addObject(p150, 8130, 320);
        Platform p151 = new Platform(); addObject(p151, 8330, 381);
        Platform p152 = new Platform(); addObject(p152, 8500, 381);
        Platform p153 = new Platform(); addObject(p153, 8650, 381);
        Platform p154 = new Platform(); addObject(p154, 8800, 381);
        Platform p155 = new Platform(); addObject(p155, 8950, 381);
        Platform p156 = new Platform(); addObject(p156, 9100, 381);
        Platform p157 = new Platform(); addObject(p157, 9250, 381);
        Platform p158 = new Platform(); addObject(p158, 8230, 320);
        Platform p160 = new Platform(); addObject(p160, 8440, 283);
        Platform p161 = new Platform(); addObject(p161, 8300, 210);
        Platform p162 = new Platform(); addObject(p162, 8440, 119);
        Platform p163 = new Platform(); addObject(p163, 8900, 283);
        Platform p164 = new Platform(); addObject(p164, 9000, 210);
        Platform p165 = new Platform(); addObject(p165, 8900, 119);
        HealthPotion hp1 =  new HealthPotion(); addObject(hp1, 8130, 300);
        HealthPotion hp2 =  new HealthPotion(); addObject(hp2, 8230, 300);
        ArrowAmmo aa1 = new ArrowAmmo(); addObject(aa1, 8440, 260);
        ArrowAmmo aa2 = new ArrowAmmo(); addObject(aa2, 8900, 260);
        ArrowAmmo aa3 = new ArrowAmmo(); addObject(aa3, 8440, 100);
        ArrowAmmo aa4 = new ArrowAmmo(); addObject(aa4, 8900, 100);
        DissappearingPlat dp1 = new DissappearingPlat(); addObject(dp1, 7400, 177);
        DissappearingPlat dp2 = new DissappearingPlat(); addObject(dp2, 7575, 177);
        DissappearingPlat dp3 = new DissappearingPlat(); addObject(dp3, 7730, 177);
        TallPlat tp1 = new TallPlat(); addObject(tp1, 4900, 180);
        MovingPlatform mp1 = new MovingPlatform(); addObject(mp1, 325, 380);
        MovingPlatform mp2 = new MovingPlatform(); addObject(mp2, 725, 380);
        MovingPlatform mp3 = new MovingPlatform(); addObject(mp3, 940, 380);
        MovingPlatform mp4 = new MovingPlatform(); addObject(mp4, 6450, 321);
        MovingPlatform mp5 = new MovingPlatform(); addObject(mp5, 6850, 226);        
        Alligator al1 = new Alligator(); addObject(al1, 1305, 387);
        Alligator al2 = new Alligator(); addObject(al2, 1950, 387);
        Alligator al3 = new Alligator(); addObject(al3, 3805, 387);
        Alligator al4 = new Alligator(); addObject(al4, 4200, 387);
        Alligator al5 = new Alligator(); addObject(al5, 5100, 383);
        Alligator al6 = new Alligator(); addObject(al6, 5250, 383);
        Alligator al7 = new Alligator(); addObject(al7, 7400, 387);
        Alligator al8 = new Alligator(); addObject(al8, 7700, 387);
        midAlligator ma1 = new midAlligator(); addObject(ma1, 4005, 387);
        midAlligator ma2 = new midAlligator(); addObject(ma2, 7550, 387);
        midAlligator ma3 = new midAlligator(); addObject(ma3, 7850, 387);
        AirBoss ab = new AirBoss(150); addObject(ab, 8800, 35);
        BossBattleInit bbi = new BossBattleInit(); addObject(bbi, 9050, -10);
        addObject(Player, 100, 327);
        addObject(InfoBar, 400, 530);
        addObject(playerHealthBar,210,530);
        addObject(moneybag,400,530);
        if(Variables.hasBow){
            addObject(arrowCounter, 532, 536);
        }
    }
}
