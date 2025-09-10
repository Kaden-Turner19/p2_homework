/**
 * Driver class used to test the Movie class
 *
 * @author  Kaden Turner
 * @version 9/10/2025
 *
 * <pre>
 * This is the beginning of hw03
 * </pre>
*/
public class Driver
{
   public static void main(String [] args)
   {
      /**Movie clue = new Movie();
      clue.title = "Clue";
      clue.genre = "Mystery";
      clue.year = 1974;
      
      System.out.println(clue.title);
      System.out.println(clue.genre);
      System.out.println(clue.year);
      */
      
      Movie homeAlone = new Movie("Home Alone", "Action", 1996);
      System.out.println(homeAlone.title);
      System.out.println(homeAlone.genre);
      System.out.println(homeAlone.year);
   }
}