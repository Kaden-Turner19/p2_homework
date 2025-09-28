/**
 * Driver class used to test the MovieContainer class
 *
 * @author  Kaden Turner
 * @version 9/17/2025
 *
 * <pre>
 * This is the beginning of hw04
 * </pre>
*/
public class Driver
{     
   public static void main(String [] args)
   {
      MovieUI mui = new MovieUI("../data/movielist.txt");
      mui.run();
   }
}