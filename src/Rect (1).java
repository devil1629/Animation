import java.awt.Graphics;

public class Rect extends Sprites
{
   int x;
   int y;

   int w;
   int h;


   public Rect(int x, int y, int w, int h)
   {
	   super(x,y,w,h);
      this.x = x;
      this.y = y;

      this.w = w;
      this.h = h;
   }

   
 
   public void TravelBy(int dx, int dy)
	{
		x -= dx;
		y -= dy;
		
	}

   public void moveUpBy(int dy)
   {
      y -= dy;
   }

   public void moveDownBy(int dy)
   {
      y += dy;
   }


   public void moveLeftBy(int dx)
   {
      x -= dx;
   }

   public void moveRightBy(int dx)
   {
      x += dx;
   }

   public void getCoords(int x, int y)
   { 
	   this.x = x;
	   this.y = y;
	   
   }



   public boolean hasCollidedWith(Rect r)
   {
      return
         (  x +   w >= r.x) &&
         (r.x + r.w >=   x) &&
         (r.y + r.h >=   y) &&
         (  y  +  h >= r.y);
   }


   public boolean contains(int mx, int my)
   {
       return (my < y+h) && (my > y) && (mx > x) && (mx < x+w);
   }


   public void draw(Graphics g)
   {
      g.drawRect(x, y, w, h);
   }

}