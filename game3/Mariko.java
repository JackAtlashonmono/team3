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
    private int gravity;
    public void act()
    {
         gravity--;
         setLocation(getX(), getY() - gravity);
         checkForJump();
        // Add your action code here.
        if( Greenfoot.isKeyDown( "A" ) ){
            setRotation(0);
            move(-1);
        }
        if( Greenfoot.isKeyDown( "D" ) ){
            setRotation(0);
            move(1);
        }
       
    }
    private void checkForJump()
    {
            if( Greenfoot.isKeyDown("space"))
                gravity = 20; // this will make the character jump
    }
}
