import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mariko here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mariko extends Actor
{
    /**
     * Act - do whatever the Mariko wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if( Greenfoot.isKeyDown( "up" ) ){
            setRotation(-90);
            move(1);
        }
        if( Greenfoot.isKeyDown( "down" ) ){
            setRotation(90);
            move(1);
        }
        if( Greenfoot.isKeyDown( "left" ) ){
            setRotation(180);
            move(1);
        }
        if( Greenfoot.isKeyDown( "right" ) ){
            setRotation(0);
            move(1);
        }
        
        Actor actor = getOneIntersectingObject( Kurio.class );
        if( actor != null ){
            //Kurioとぶつかった時の処理
            Greenfoot.stop();
        } 
    }
}
