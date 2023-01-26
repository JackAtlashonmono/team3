import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mariko here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sord extends Actor
{
    private double gravity = 0.1;
    private double vSpeed = 0;
    public void act()
    {
        checkFalling();
        /* gravity--;
         setLocation(getX(), getY() - gravity);
         checkForJump();*/
        // Add your action code here
        Actor actor = getOneIntersectingObject( Kurio.class );
        Actor actor2 = getOneIntersectingObject( hanekurio.class );
        if( actor != null ){
            //Kurioとぶつかった時の処理
            getWorld().removeObject( actor );
        } 
        if( actor2 != null ){
            //Kurioとぶつかった時の処理
            getWorld().removeObject( actor2 );
        }

        if( Greenfoot.isKeyDown( "A" ) ){
            setRotation(0);
            move(-3);
        }
        if( Greenfoot.isKeyDown( "D" ) ){
            setRotation(0);
            move(3);
        } 
        if( onGround() == true && Greenfoot.isKeyDown("space")){
            vSpeed = -8;
            fall();
        }
    }
    /*private void checkForJump()
    {

        if( Greenfoot.isKeyDown("space"))
            gravity = 15; // this will make the character jump

    }*/
    public boolean onGround()
    {
        Object under = getOneObjectAtOffset(0, getImage().getHeight()/2 + 2, Ground.class);
        return under != null;
    }
    
    private void fall()
    {
        setLocation(getX(), getY() + (int)vSpeed);
        vSpeed = vSpeed + gravity;
    }
    
    public void checkFalling()
    {
        if(onGround() == false)
        {
            fall();
        }
    }
}
