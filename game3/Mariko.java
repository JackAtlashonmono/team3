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
    private double gravity = 0.1;
    private double vSpeed = 0;
    
    public void act()
    {
        checkFalling();
        
        // Add your action code here
        Actor actor = getOneIntersectingObject( Kurio.class );
        Actor under = getOneIntersectingObject( Ground.class );
        /*if( under != null ){
            //床と ぶつかった時の処理
            
        }*/
        if( actor != null ){
            //Kurioとぶつかった時の処理
            ((MyWorld)getWorld()).showTextEx("GAME OVER", 400, 200, 128, true, Color.RED );
            Greenfoot.stop();
        } 
        actor = getOneIntersectingObject( flag.class );
        if( actor != null ){
            //flagとぶつかった時の処理
            ((MyWorld)getWorld()).showTextEx("CLEAR", 400, 200, 128, true, Color.GREEN );
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
        if( onGround() == true && Greenfoot.isKeyDown("space")){
            vSpeed = -8;
            fall();
        }
    }
   
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
