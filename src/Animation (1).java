import java.awt.Image;
import java.awt.Toolkit;

public class Animation
{
   Image[] image;

   int current = 1;

   int delay = 0;
    
   int count;

   public Animation(String name, int count)
   {
      image = new Image[count];
      
      this.count = count;	
      for(int i = 0; i < count; i++)

         image[i] = Toolkit.getDefaultToolkit().getImage(name+"_"+i+".PNG");
   }


   public Image currentImage()
   {
      if (delay == 7)
      {
         delay = -1;

         current++;

         if (current >= image.length) current = 1;
      }

      delay++;
      
  //    if(image[current] == image[6] )
      
      return image[current];
   }

   public Image staticImage()
   {
      return image[count-1];
   
}
}

