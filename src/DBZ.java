import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class DBZ extends Applet implements KeyListener, Runnable

{
	String fname = "v";
	
	  SpriteAnimated img = new SpriteAnimated(100, 60, "v_", 8);
	  Image ig;
	  
	  Image Ball;
	  SpriteAnimated img2 = new SpriteAnimated(500,60,"v_",7);
	  
	  AstroidAnimated Astroids = new AstroidAnimated(700,60,"Astro2",3);
	  
	  Rect r1 = new Rect(100,70,50,60);
	  Rect r2 = new Rect(500,70,30,60);
	  Rect BallRect = new Rect(600,600,50,60);
	  
	  
	//  Rect AstroRect = new Rect(500,70,30,60);
	  
	  boolean GameLoop = true;
	  boolean moveleft = true;
	  boolean moveright = false;
	  
	  
	  Random ranX = new Random();
	  Random ranposX = new Random();
	  
	  static int highscore;
	  static int speed =0;
	  static int ChSpeed  = 5;
	  int score = 0;
	  int ranBallX;
	  int ranBallY;
	  int[] posX = {100,800,450,587};
	  int[] posY = {300,200,40,387};
	   
	  private AudioClip audio;
	  
	  Image offscreen;
	  Graphics offscreen_g;

	boolean[] isPressed = new boolean[100];
	
	
	public void init()
	{
		//setBackground(Color.black);
		this.setSize(800, 450);
		
		
		ig = Toolkit.getDefaultToolkit().getImage("v1_back_1.PNG");
		//img.getImage();
		Ball = Toolkit.getDefaultToolkit().getImage("Dragonball.PNG");
		
		
		audio = getAudioClip(getCodeBase(),"sound.wav");
		
		for(int i = 0; i < isPressed.length; i++)
		         isPressed[i] = false;
		
		requestFocus();
		this.addKeyListener(this);

		Thread t =  new Thread(this);
		t.start();
		
		offscreen = createImage(this.getWidth(),this.getHeight());
		offscreen_g = offscreen.getGraphics();
	}
	
	
	

public void run() {	
		
	
while(true){
	
// Controllable Game Loop.	
	if(GameLoop){

		
// Moving Astroid Left.
	if(moveleft){ 
		 if(Astroids.x >0){
		 Astroids.TravelBy(4+speed, 0);
		 Astroids.AstroRect.TravelBy(4+speed, 0);
		 }
		 
	
	

	 else{
		// Restart the astroid with x and y +.25. 
		//Astroids.setTravel(false);
		 
		 score++;
		 Astroids = null;
		 Astroids = new AstroidAnimated(0,img.y,"Astro2",3);
		 speed += 1;
		 moveright = true;
		 moveleft = false;
		 
//		 Astroids.TravelBy(3, -5);
//		 Astroids.AstroRect.TravelBy(3, -5);
		 
 }
	}
		 
	
//  Moving Astroid Right.	
	if(moveright){
	
	if(Astroids.x <800){
			 Astroids.TravelBy(-1*(4+speed), 0);
			 Astroids.AstroRect.TravelBy(-1*(4+speed), 0);
		 }
	 
	 
		 else{
				// Restart the astroid with x and y +.25. 
				//Astroids.setTravel(false);
			
				 score++;
				 Astroids = null;
				 Astroids = new AstroidAnimated(800,img.y,"Astro2",3);
				 speed += 1;
				 
				 moveright = false;
				 moveleft = true;
				 
//				 Astroids.TravelBy(3, -5);
//				 Astroids.AstroRect.TravelBy(3, -5);
				 
		 }
		 
	 
	}
	

// Character Movement	
    if(isPressed[KeyEvent.VK_UP])      {
    	img.moveUpBy(ChSpeed);
    	r1.moveUpBy(ChSpeed);
    	
    }
 
    if(isPressed[KeyEvent.VK_DOWN])    {
    	img.moveDownBy(ChSpeed);
    	r1.moveDownBy(ChSpeed);
    }

    if(isPressed[KeyEvent.VK_LEFT])    {
    	img.moveLeftBy(ChSpeed);
    	r1.moveLeftBy(ChSpeed);
    }

    if(isPressed[KeyEvent.VK_RIGHT])  {
    	img.moveRightBy(ChSpeed);
    	r1.moveRightBy(ChSpeed);
    }
    
    if(isPressed[KeyEvent.VK_S])        img.attack1By(3);
    
    if(isPressed[KeyEvent.VK_D])        img.attack2By(0);
      img.getRect(r1);
	}
	
	else{
		Astroids.ChkCollision(score);
		
	}
    
    repaint();
    
    try
    {
       Thread.sleep(40);
    }
    catch(Exception x){};

}
    
}


	
	
	public void keyPressed(KeyEvent e) {
		
		isPressed[e.getKeyCode()] = true;
		

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
		isPressed[e.getKeyCode()] = false;
		
		if(e.getKeyCode()== e.VK_D) img.PballMove(20);

//Game Restart		
		if(e.getKeyCode()== e.VK_R){
			GameLoop = true;
			
// delete the objects and recreate the objects at initial position 			
			Astroids = null;
			Astroids = new AstroidAnimated(700,60,"Astro2",3);
			
			img = null;
			img = new SpriteAnimated(100, 60, "v_", 8);
			r1 = null;
			r1 = new Rect(100,70,50,60);
			
			speed = 0;
			score = 0;
			ChSpeed  = 5;
			  
		}
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}

	public void update(Graphics g)
	{

		offscreen_g.clearRect(100, 0, this.getWidth(), this.getHeight());
		paint(offscreen_g);
		g.drawImage(offscreen,0,0,null);
	}
	
	
	public void paint(Graphics g)
	{
		int PosX = 350;	
		
		
		
		
		g.drawImage(ig, 0, 0, null);
		img.draw(g);
		
		//r1.draw(g);
		//r2.draw(g);
	
		Astroids.draw(g);
		
		
// Power-Up.		
		if(score%10==1)
		{
			if(r1.hasCollidedWith(BallRect))
			{
				ChSpeed += 1; 
				score += 5;
				Ball.flush();
				ranBallX = ranX.nextInt(600);
				
			}
			
			else{
			
				
			g.drawImage(Ball, ranBallX,ranBallX, null);
			BallRect.getCoords(ranBallX+10, ranBallX);
			
			//BallRect.draw(g);
			}
			
			}
		
	      
// Collision
		if(r1.hasCollidedWith(Astroids.AstroRect))
		{
			Astroids = null;
			Astroids = new AstroidAnimated(600,60,"Astro2",3);
			GameLoop = false;
//			Astroids.ChkCollision(score);
			img.Die();
			
			
		}
		
		else{
			//img2.draw(g);
// Score Board			
			g.setColor(Color.RED);
			g.drawString("Score:"+score, 500, 20);
			
			Font font = new Font("Verdana",Font.BOLD,14);
			g.setFont(font);
			g.drawString("PowerLevel:"+ChSpeed+"000", 100, 20);
			
			if(highscore <= score)
			{
			   highscore = score;	
			}
			
			g.drawString("HighScore:"+highscore, 650, 20);
			
		}
		
	}
		
	
	
}
