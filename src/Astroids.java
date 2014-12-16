import java.awt.Graphics;


public abstract class Astroids 
{

	   int x;
	   int y;

	   int w;
	   int h;
	   
	   int Score;
	
	   final int type = 1;
	   boolean travel = false;
	   boolean AstrCollide = false;
	   
	   
	public Astroids(int x, int y, int w, int h) {
		
		
		  this.x = x;
	      this.y = y;

	      this.w = w;
	      this.h = h;
	}
	
	
	

	public boolean isTravel() {
		return travel;
	}
	
	


	public void setTravel(boolean travel) {
		this.travel = travel;
	}



	public void ChkCollision(int score)
	{
		AstrCollide = true;
		this.Score = score;
	}

	public void moveRt (int dx)
	{
		x += dx;
		
	}

	public void moveLt(int dx)
	{
		x -= dx;
		
	}
	
	public void TravelBy(int dx, int dy)
	{
		x -= dx;
		y -= dy;
		travel =true;
	}
	
	
	public abstract void draw(Graphics g);

}
