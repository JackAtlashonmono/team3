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
<<<<<<< HEAD
        if( Greenfoot.isKeyDown( "A" ) ){
            setRotation(0);
            move(-1);
        }
=======
        if( Greenfoot.isKeyDown( "W" ) ){
            setRotation(-90);
            move(1);
        }
        if( Greenfoot.isKeyDown( "S" ) ){
            setRotation(90);
            move(1);
        }
        if( Greenfoot.isKeyDown( "A" ) ){
            setRotation(180);
            move(1);
        }
>>>>>>> 118d9c8b476de85733492994ac5340e426625975
        if( Greenfoot.isKeyDown( "D" ) ){
            setRotation(0);
            move(1);
        }
<<<<<<< HEAD
       
    }
    private void checkForJump()
    {
            if( Greenfoot.isKeyDown("space"))
                gravity = 20; // this will make the character jump
=======
        
        Actor actor = getOneIntersectingObject( Kurio.class );
        if( actor != null ){
            //Kurioとぶつかった時の処理
            Greenfoot.stop();
        } 
>>>>>>> 118d9c8b476de85733492994ac5340e426625975
    }
}
