import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kurio here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kurio extends Actor
{
    int left=0;
    /**
     * Act - do whatever the Kurio wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        // Add your action code here.
        setRotation(0);
        if(left==1){
            move(-1);
        }else{
            move(1);
        }
        if( isAtEdge() ){
            left=1-left;
        }        

    }
}
