import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mariko here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sord extends Actor
{
    private int gravity;
    public void act()
    {
         gravity--;
         setLocation(getX(), getY() - gravity);
         checkForJump();
        // Add your action code here
        Actor actor = getOneIntersectingObject( Kurio.class );
        if( actor != null ){
            //Kurioとぶつかった時の処理
            getWorld().removeObject( actor );
        } 

        if( Greenfoot.isKeyDown( "A" ) ){
            setRotation(0);
            move(-3);
        }
        if( Greenfoot.isKeyDown( "D" ) ){
            setRotation(0);
            move(3);
        } 
        
    }
    private void checkForJump()
    {

        if( Greenfoot.isKeyDown("space"))
            gravity = 15; // this will make the character jump

    }
}
