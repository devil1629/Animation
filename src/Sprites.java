import java.awt.Graphics;

public abstract class Sprites
{
   int x;
   int y;

   int w;
   int h;

   int dir = DN;

   boolean moving = false;
   boolean moveP = false;
   boolean die = false;

   final static int UP = 0;
   final static int DN = 1;
   final static int LT = 2;
   final static int RT = 3;
   final static int AT = 4;
   final static int AT2 = 5;
   final static int PB = 6;
   final static int Die = 7;

   
   public Sprites(int x, int y, int w, int h)
   {
      this.x = x;
      this.y = y;

      this.w = w;
      this.h = h;
   }

   public void attack1By(int dx)
   {
      x += dx;
	   
      dir = AT;

      moving = true;
   }
   
   public void PballMove(int dx)
   {
      x += dx;
	   
      dir = PB;

      moveP = true;
   }
   
   public void Die()
   {
     
	   
      dir = Die;

      die = true;
   }
   
   public void attack2By(int dx)
   {
      x += dx;
	   
      dir = AT2;

      moving = true;
   }
   
   public void moveUpBy(int dy)
   {
      y -= dy;

      dir = UP;

      moving = true;
   }

   public void moveDownBy(int dy)
   {
      y += dy;

      dir = DN;

      moving = true;
   }


   public void moveLeftBy(int dx)
   {
      x -= dx;

      dir = LT;

      moving = true;
   }

   public void moveRightBy(int dx)
   {
      x += dx;

      dir = RT;

      moving = true;
   }





//   public boolean hasCollidedWith(Rect r)
//   {
//      return
//         (  x +   w >= r.x) &&
//         (r.x + r.w >=   x) &&
//         (r.y + r.h >=   y) &&
//         (  y  +  h >= r.y);
//   }


   public boolean contains(int mx, int my)
   {
       return (my < y+h) && (my > y) && (mx > x) && (mx < x+w);
   }


   public abstract void draw(Graphics g);


}






/*
import java.awt.*;


public class Sprites 
{
	int x;
	int y;
	String fname;
	int count;
	int current = 0;
	
	Image[] img;
	
	public Sprites(int x , int y, String fname, int count)
	{
		
		this.x = x;
		this.y = y;
		this.fname = fname;
		this.count = count;
		
		
		
        
		 img = new Image[count];
		
	}
	
	


	public void getImage()
	{
        Toolkit toolkit = Toolkit.getDefaultToolkit();
		
        
		for(int i=0 ; i < count; i++)
		{
			int k = i+1;
		img[i] = toolkit.getImage(fname+k+".PNG");
		
		}
		
		
	}
	
	public void Attack()
	{
		
		
	}
	
	
	public void moveUp (int dy)
	{
		y -= dy;
		current=0;
	}
	
	public void moveDn (int dy)
	{
		y += dy;
		current=3;
	}
	public void moveLt (int dx)
	{
		x -= dx;
		current=2;
	}
	public void moveRt (int dx)
	{
		x += dx;
		current=1;
	}
	
	public void darw(Graphics g)
	{
		g.drawImage(img[current], x, y, null);
		
	}
	
}
*/