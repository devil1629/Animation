public class LookUp
{
   final static double[] cos = generateCos();

   final static double[] sin = generateSin();



   public static double[] generateCos()
   {
       double[] cos = new double[360];


       for(int degrees = 0; degrees < 360; degrees++)

          cos[degrees] = Math.cos(degrees * Math.PI / 180);

       return cos;
   }

   public static double[] generateSin()
   {
       double[] sin = new double[360];

       for(int degrees = 0; degrees < 360; degrees++)

          sin[degrees] = Math.sin(degrees * Math.PI / 180);

       return sin;
   }


}
