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
        // Add your action code here
        Actor actor = getOneIntersectingObject( Kurio.class );
        if( actor != null ){
            //Kurioとぶつかった時の処理
            ((MyWorld)getWorld()).showTextEx("GAME OVER", 400, 200, 128, true, Color.RED );
            Greenfoot.stop();
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
