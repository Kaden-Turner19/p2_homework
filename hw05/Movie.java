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

import java.io.*;

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
   
  /*
   * Getter for the attribute title
  */
   public String getTitle()      //we must add a new constructor to obtain each parameter
   {
      return title;
   }
   
  /*
   * Getter for the attribute genre
  */
   public String getGenre()      //Constructor for the genre parameter
   {
      return genre;
   }
   
  /*
   * Getter for the attribute year
  */
   public int getYear()       //constructor for the year parameter
   {
      return year;
   }
   
   /*
    * compares two strings titles to address if they match
    *
    * @param search String used to hold the search wanted
    * @return whether there is a partial match
   */
   public boolean matchesTitle(String search)
   {
      if(this.title.toLowerCase().contains(search))
      {
         System.out.printf("%-30s %-20s %-5d\n",this.title,this.genre,this.year);    //formatted string copied from the other methods
         return true;
      }
      else
      {
         return false;
      }
   }
   
   /*
    * prints the attributes of this class to the desired data file
    *
    * @param outFile a PrintStream object to print the attributes to
   */
   public void writeToFile(PrintStream outFile)
   {
      outFile.println(this.title);
      outFile.println(this.genre);      //Prints each attribute to the PrintStream
      outFile.println(this.year);
   }
}