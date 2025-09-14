/**
 * Movie class to hold a singular movie
 *
 * @author  Kaden Turner
 * @version 9/10/2025
 *
 * <pre>
 * This is the beginning of hw03
 * </pre>
*/
public class Movie
{
   public String title;
   public String genre;
   public int year;

   public Movie(String title, String g, int y)
   {
      this.title = title;
      genre = g;
      year = y;
   }
   
   public String toString()
   {
      String f;
      f = String.format("%-30s %-20s %4d\n",title,genre,year);
      
      return f;
   }
}