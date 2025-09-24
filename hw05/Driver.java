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
   private static final String DATAFILE= "../data/movielist.txt";
      
   public static void main(String [] args)
   {
   MovieContainer mc = new MovieContainer(DATAFILE);
   mc.display();
   
   mc.insert("Kaden","Action",2005);
   mc.insert("Kaden1","Action",2006);
   mc.insert("Kaden2","Action",2100);
   mc.insert("hello", "Suspense",2008);
   mc.display();
   mc.searchByYear(2100);
   mc.searchByTitle("kaden");
   mc.searchByTitle("hello");
   mc.searchByGenre("Action");
   mc.searchByGenre("Suspense");
   mc.display();
   mc.remove(3);
   mc.display();
   mc.save();
   mc.size();
   }
}