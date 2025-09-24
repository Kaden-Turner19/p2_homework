/**
 * Personal Movie Inventory System.
 *
 * @author  Kaden Turner
 * @version 9/17/2025
 *
 * <pre>
 * This is the starter code for the parallel array version of the movie
 * inventory system.
 * </pre>
*/

import java.io.*;
import java.util.Scanner;

public class MovieContainer
{
	private static final String DATAFILE= "../data/movielist.txt";
   private int numMovies = 0;                         //Created a new variable to hold the number of movies
   private Movie[] movies = new Movie[10000];     //Created a new Movie array with 10000 slots
   
	public static final int MAXMOVIES = 10000;

	/**
	 * Allow user to enter a new movie.
	 *
	 * @param t new title of the movie added
	 * @param g new genre of the movie added
    * @param y new year of the movie added
	 * @return the new movie count
	*/
	public int insert(String t, String g, int y)
	{
      movies[numMovies] = new Movie(t, g, y);
      
      numMovies++;
		return numMovies;
	}
   
	/**
	 * Displays all movie information.
	*/
	public void display()
	{
		System.out.println("------------------------------------------------");
		System.out.printf("%-30s %-20s %s\n","TITLE","GENRE","YEAR");
      
		for (int i=0; i<numMovies; i++)
      {
			System.out.print(movies[i]);
      }
	}
   
   /**
	 * prompt the user to enter a year and display all movies that match the given year.
    *
    * @param n number of elements in the array
	*/
   public void searchByYear(int n)
   {    
      System.out.println("------------------------------------------------");
      System.out.printf("%-30s %-20s %s\n","TITLE","GENRE","YEAR");     //Formatted Strings copied from the main method to preserve aesthetic
      
      for(int i = 0;i < numMovies;i++)
      {
         if(movies[i].getYear() == n)
            System.out.printf("%-30s %-20s %4d\n", movies[i].getTitle(), movies[i].getGenre(), movies[i].getYear());
      }
   }
   
  /**
   * prompt the user to enter a title and display all movies that match the given title.
   *
   * @param t Title to search for
  */
  public void searchByTitle(String t)
  {      
      t = t.toLowerCase();     //convert user input to lower case
    
      System.out.println("------------------------------------------------");
      System.out.printf("%-30s %-20s %-5s %s\n","TITLE","GENRE","YEAR","ID");     //formatted Strings copied from the main method to preserve aesthetic
                                                                                  //added the ID column for the deleteMovie method
    
      for(int i = 0;i < numMovies;i++)
	   {
         movies[i].matchesTitle(t);
	   }      
   }
   
   /**
    * prompt the user to enter a genre and display all movies within that genre
    *
    * @param g selected genre to search for
   */
   public void searchByGenre(String g)
   {  
      g = g.toLowerCase();     //making the search case insensitive
      
      System.out.println("------------------------------------------------");
      System.out.printf("%-30s %-20s %s\n","TITLE","GENRE","YEAR");     //formatted Strings copied from the main method
      
      for(int i = 0;i < numMovies;i++)
      {
         if(movies[i].getGenre().toLowerCase().equals(g))
         {
            System.out.print(movies[i]);      //formatted Strings copied from the main mehtod
         }
      } 
   }
   
   /**
    * prompt the user to enter a title to be deleted
    *
    * @param index index of the selected movie to delete
    * @return the updated amount of movies in the array
   */
   public int remove(int index)
   {  
      if(index < 0 || index >= numMovies)    
      {
         System.out.println("Invalid ID");      //if the id is out of bounds or not valid then return nothing
         return numMovies;
      } 
      
      for(int i = index;i < numMovies - 1;i++)
      {
         movies[i] = movies[i+1];
      }
      
      movies[numMovies - 1] = null;     //Must clear the remaining entries
      
      numMovies--;
      
      return numMovies;    //returns the numberOfEntries -1 if id is valid
      
   }
   
   /**
    * Displays the size of the movie container
   */
   public void size()
   {
      System.out.println(numMovies);
   }

   /**
    * Saves all the movies to the data file thats selected
   */
   public void save()
   {
      try
      {
         PrintStream outFile = new PrintStream(DATAFILE);      //declaring new PrintStream to print to the data file
         
         for(int i = 0;i < numMovies;i++)
         {
            movies[i].writeToFile(outFile);
         }
         
         outFile.close();
         
      }
      catch(IOException e)    //catches the exception so the program doesn't break
      {
         System.out.println("Couldn't save data to the selected file.");
      }
   }
   
   /*
    * reads from the data file into the container
    *
    * @param dataFile directory of the file that we want to read
   */
   public MovieContainer(String dataFile)
   {
      int count = 0;
      
      try
      {
         Scanner outFile = new Scanner(new File(dataFile));      //declaring new PrintStream to print to the data file
         
         while(outFile.hasNextLine())
         {
            String title = outFile.nextLine().trim();
            String genre = outFile.nextLine().trim();
            int year = outFile.nextInt();
            outFile.nextLine();     //Used to obtain the leftover newline
            
            movies[count] = new Movie(title, genre, year);
            count++;
         }
         
         numMovies = count;
         outFile.close();
         
      }
      catch(IOException e)    //catches the exception so the program doesn't break
      {
         System.out.println("Couldn't save data to the selected file.");
      }
   }
}