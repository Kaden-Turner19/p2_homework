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
   private String title;
   private String genre;
   private int year;

   public Movie(String title, String g, int y)
   {
      this.title = title;
      this.genre = g;
      this.year = y;
   }
   
   public String toString()
   {
      String f;
      f = String.format("%-30s %-20s %4d\n",title,genre,year);
      
      return f;
   }
   
   public String getTitle()      //we must add a new constructor to obtain each parameter
   {
      return title;
   }
   public String getGenre()      //Constructor for the genre parameter
   {
      return genre;
   }
   public int getYear()       //constructor for the year parameter
   {
      return year;
   }
}