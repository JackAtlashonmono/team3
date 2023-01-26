import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.TextLabel;
import greenfoot.WorldVisitor;
import greenfoot.util.GraphicsUtilities;
import java.util.ArrayList;
import java.awt.Graphics2D;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 450, 1); 
        

        //addObject( new Mariko(), 40, 410 );
        //addObject( new Kurio(), 740, 410 );
        addObject( new Ground(), 200,350 );
        //addObject( new Mariko(), 40, 400 );
        //addObject( new Kurio(), 800, 410 );



        addObject( new Mariko(), 40, 170 );
        //addObject( new Kurio(), 740, 410 );

        addObject( new Mariko(), 40, 370 );
        addObject( new sord(), 0, 360 );
        addObject( new flag(), 740, 410 );
        
        //kurioのランダム生成
        int kurio_count = 3;
        for(int i=0; i<kurio_count; i++)
        {
            int A = 100;
            int B = 800;
            int C = A + (int)(Math.random()*((B-A)+1));
            addObject( new Kurio(), C, 410 );
        }
        /*
        //hardmode
        int hanekurio_count = 2;
        for(int i=0; i<hanekurio_count; i++)
        {
            int A = 100;
            int B = 800;
            int C = A + (int)(Math.random()*((B-A)+1));
            int D = 50;
            int E = 300;
            int F = D + (int)(Math.random()*((E-D)+1));
            addObject( new hanekurio(), C, F );
        }
        */

    }

    class TextLabelEx extends TextLabel
    {
        boolean enable;
        int xpos;
        int ypos;
        int size;
        boolean bold;
        greenfoot.Color gfcolor;
        java.awt.Color color;
        String text;
        String[] lines;
        private GraphicsUtilities.MultiLineStringDimensions dimensions = null;

        @Override
        public int getX(){ return xpos;}

        @Override
        public int getY(){ return ypos;}

        @Override
        public String getText(){ return text;}     

        public TextLabelEx(String _text, int _xpos, int _ypos, int _size, boolean _bold, greenfoot.Color _gfcolor )
        {
            super("", 0, 0 );
            lines = new String[1];
            xpos = _xpos;
            ypos = _ypos;
            reset( _text, _size, _bold, _gfcolor );
        }

        public void reset( String _text, int _size, boolean _bold, greenfoot.Color _gfcolor )
        {
            if( text == _text && size == _size && bold == _bold && gfcolor == _gfcolor ) return;
            text = _text;
            size = _size;
            bold = _bold;
            gfcolor = _gfcolor;
            lines[0] = text;
            dimensions = null;

            if( text.length() == 0 ) enable = false;
            else enable = true;
        }

        @Override
        public void draw(Graphics2D g, int cellsize)
        {
            if( !enable ) return;
            if(dimensions == null) {
                dimensions = GraphicsUtilities.getMultiLineStringDimensions(lines, bold ? java.awt.Font.BOLD : java.awt.Font.PLAIN, size);
                color = new java.awt.Color( gfcolor.getRed(), gfcolor.getGreen(), gfcolor.getBlue(), gfcolor.getAlpha() );
            }

            int ydraw = ypos * cellsize - dimensions.getHeight() / 2 + cellsize / 2;
            int xdraw = xpos * cellsize - dimensions.getWidth() / 2 + cellsize / 2;
            g.translate(xdraw, ydraw);
            GraphicsUtilities.drawOutlinedText(g, dimensions, color, java.awt.Color.BLACK);
            g.translate(-xdraw, -ydraw);
        }
    }   

    public void showTextEx(String text, int x, int y, int size, boolean bold, greenfoot.Color color )
    {
        for( TextLabel label : WorldVisitor.getTextLabels(this) ){
            if( label.getX() == x && label.getY() == y ){
                if( label instanceof TextLabelEx ){
                    ((TextLabelEx)label).reset(text, size, bold, color);
                    return;                    
                }
            }
        }
        WorldVisitor.getTextLabels(this).add(new TextLabelEx( text, x, y, size, bold, color ) );

        //showText( "labels: "+WorldVisitor.getTextLabels(this).size(), 80, 20 );
    }
}
