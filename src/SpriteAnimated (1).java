import java.awt.Graphics;

public class SpriteAnimated extends Sprites
{
   Animation[] animation;

   String[] pose = {"up", "dn", "lt", "rt","at","at2","pball","die"};
   int[] count = {2,2,2,2,3,3,2,6};
   Animation k;
   Rect r1;
   

   public SpriteAnimated(int x, int y, String name, int size)
   {
       super(x, y, 0, 0);

       animation = new Animation[size];


       for(int i = 0; i < animation.length; i++)
          animation[i] = new Animation(name+pose[i], count[i]);

   }
   
   
   public void getRect(Rect r)
   {
	  r1 = r;   
   }

   public void draw(Graphics g)
   {
      if(moving)
      {
    	 
         g.drawImage(animation[dir].currentImage(),x, y, null);
      }
      
      else if(moveP) // add to x to move the sprite and don't stop till a specific number is reached.
      {	
    	  g.drawImage(animation[dir].currentImage(),x, y, null);
    	 // r1.draw(g);
    	  x+=20;
    	  r1.x+=20;
    	  
    	  //System.out.println(x);
    	  if(x >= 560) {moveP=false;
    	  
    	  moveUpBy(0);
    	  
    	  }
    }
      
      else if(die){
    	  g.drawImage(animation[dir].currentImage(),x, y, null);
    	  if(animation[dir].current == animation[dir].count-1) die = false;
   // 	  System.out.println(animation[dir].count + "kill" + animation[dir].current );
      }
      
      else
      {
         g.drawImage(animation[dir].staticImage(),x, y, null);
      }

      moving = false;

   }

 


}