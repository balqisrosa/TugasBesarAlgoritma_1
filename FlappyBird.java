import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FlappyBird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBird extends Actor
{
    private double g = 1;
    
    private int y = 200;
    private boolean hespressed = false; //variabel ini bernilai true jika spasi ditekan
    private boolean isalive = true; //variabel ini bernilai true jika flappybird masih hidup
    private boolean isacroos = false; //variabel ini bernilai true jika flappybird sudah melewati pipa
    private boolean hassaddscore = false; //variabel ini bernilai true jika skor sudah ditambahkan
    /**
     * Act - do whatever the FlappyBird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public FlappyBird(){
        GreenfootImage image = getImage();
        image.scale(50, 40);
    }
    public void act()
    {
        //Jika menekan spasi, koordinat Y akan berkurang dan terbang ke atas
        if(spacePressed()){
            g=-2;
        }
        g += 0.1; //Nilai g meningkat 0,1 setiap saat dan flappybird akan jatuh dengan cepat
        y += g; //Nilai tidak berubah dengan kecepatan konstan
        setLocation(getX(), (int)(y)); 
        //Jika menabrak pipa maka flappybird mati 
        if(isTouchPipe()){
            isalive = false;
        }
        //Pemberian suara pada saat Game Over
        if(isTouchPipe()){
            isalive = false;
        }
        //Setelah jatuh atau nabrak pipa maka flappybird hilang
        if(!isalive){
            getWorld().addObject(new GameOver(), 300, 200);
            getWorld().removeObject(this);
            Greenfoot.stop();
        }
        //penambah skor setelah melewati pipa dan pemberian suara
        if(!hassaddscore && isacroos && isalive){
            Greenfoot.playSound("score.mp3");
            Score.add(1);
        }
        hassaddscore = isacroos;
    }
    public boolean spacePressed(){
        boolean pressed = false;
        if(Greenfoot.isKeyDown("Space")){
            //pemberian suara
            if(!hespressed){
                Greenfoot.playSound("flay.mp3");
                pressed = true;
            }
            hespressed = true;
        }else{
            hespressed = false;
        }
        return pressed;
    }
    //pemberian suara ketika menabrak pipa dan jatuh
    public boolean isTouchPipe(){
        isacroos = false;
        for(Pipe Pipe : getWorld().getObjects(Pipe.class)){
            if(Math.abs(Pipe.getX() - getX()) <69){
            if(Math.abs(Pipe.getY() + 30 - getY()) > 37){
                Greenfoot.playSound("peng.mp3");
                isalive = false;
            }
            isacroos = true;
        }
    }
    return !isalive;
}
}

