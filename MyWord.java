import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWord here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWord extends World
{

    /**
     * Constructor for objects of class MyWord.
     * 
     */
    public MyWord()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new FlappyBird(), 100, 200);
        addObject(new Pipe(), 300, 150);
        addObject(new Pipe(), 600, 150);
        addObject(new Score(), 300, 100);
    }
}
