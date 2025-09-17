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
   MovieContainer mc = new MovieContainer();
   mc.display();
   
   mc.insert("Kaden","Action",2005);
   mc.insert("Kaden1","Action",2006);
   mc.insert("Kaden2","Action",2007);
   mc.display();
   }
}