import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class AstroidAnimated extends Astroids
{

	Image astro;
	
	Rect AstroRect = new Rect(x,y,55,50);
	
	public AstroidAnimated(int x, int y, String name, int size) {
		super(x, y, 0,0);
		
		

	         astro = Toolkit.getDefaultToolkit().getImage(name+".PNG");
	       
	       
	}

	
	
	public void AstroidRectTravelBy(int dx)
	{
		AstroRect.moveLeftBy(dx);
	}
	
	
	public void moveUp(int dy)
	{
		AstroRect.moveUpBy(dy);
		
	}
	public void moveDn(int dy)
	{
		AstroRect.moveDownBy(dy);
		
	}
	
	public void draw(Graphics g) 
	{
		
	    	 g.drawImage(astro,x, y, null);
	    	
	    	// AstroRect.draw(g);
	    	 
	    if(AstrCollide){   
	    	    Font font = new Font("Verdana", Font.BOLD, 17);
	        	g.setFont(font);
				g.setColor(Color.RED);
			    g.drawString("Game Over  (Press 'R' to restart)", 300, 100);
			    g.drawString("Score:"+Score, 300, 200);
	    }
	    
	    AstrCollide = false;
	    
	    	 
	}

}
