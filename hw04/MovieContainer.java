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

	public static void main(String [] args)
	{
		int choice;						 // user's selection from the menu
      int numberOfEntries;       
      
		//numberOfEntries = loadMovies(movies);
		//System.out.println("Number of entries read from data file: " + numberOfEntries);
      /*
      
      saveMovie(movies,numberOfEntries);    //save method called after the loop has finished saving the changes made
      
		System.out.println("\nTHE END");
      */
	}

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
	 * Load movies from the data file into the arrays
	 *
	 * @param movie Array of Movie Objects
	 * @return the actual number of movies loaded into the arrays
	*/
   /*
	public static int loadMovies(Movie[] movies)
	{
      int count = 0;       //Count variable to return, will hold the number of movies added
      
      try{
         Scanner scan = new Scanner(new File(DATAFILE));    //Opens new scanner object reading from the specified file
         
         while(scan.hasNextLine())
         {
            String title = scan.nextLine().trim();
            String genre = scan.nextLine().trim();
            int year = scan.nextInt();
            scan.nextLine();     //Used to obtain the leftover newline
            
            movies[count] = new Movie(title,genre,year);
            count++;
         }
         
         scan.close();
      }
      catch(FileNotFoundException e){
         System.out.println("Error: Could not load data file " + DATAFILE);
      }

		return count;
	}
   */
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
		   if(movies[i].getTitle().toLowerCase().contains(t))  //.contain will handle the partial matching if there is any
		   {
			   System.out.printf("%-30s %-20s %-5d %4d\n",movies[i].getTitle(),movies[i].getGenre(),movies[i].getYear(),i);    //formatted string copied from the other methods
                                                                                            //added the ID number
		   }
	   }      
   }
   
   /**
    * prompt the user to enter a genre and display all movies within that genre
    *
    * @param movie Array of Movie Objects
    * @param n number of elements in the array
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
    * @param movie Array of Movie Objects
    * @param n number of elements in the array
    * @return the updated amount of movies in the array
   */
   /*
   public static int deleteMovie(Movie[] movie, int n)
   {
      
      Scanner scan = new Scanner(System.in);    //declare new Scanner 
      searchByTitle(movie, n);     //shows available movies to delete
      
      System.out.println("Enter the ID number you would like to delete: ");
      int id = scan.nextInt();      //id variable to use for deletion
      
      if(id < 0 || id > n)    
      {
         System.out.println("Invalid ID");      //if the id is out of bounds or not valid then return nothing
         return n;
      } 
      
      for(int i = id;i < n - 1;i++)
      {
         movie[i] = movie[i+1];
      }
      
      return n-1;    //returns the numberOfEntries -1 if id is valid
      
   }
   */

   /**
    * Saves all the movies to the data file thats selected
    *
    * @param movie Array of Movie Objects
    * @param n number of elements in the array
   */
   /*
   public static void saveMovie(Movie[] movie, int n)
   {
      try
      {
         PrintStream outFile = new PrintStream(DATAFILE);      //declaring new PrintStream to print to the data file
         
         for(int i = 0;i < n;i++)
         {
            outFile.println(movie[i].getTitle());
            outFile.println(movie[i].getGenre());      //loops through each entry and updates them to the file
            outFile.println(movie[i].getYear());
         }
         
         outFile.close();     //closes the PrintStream because I wasn't born in a barn :)
      }
      catch(IOException e)    //catches the exception so the program doesn't break
      {
         System.out.println("Couldn't save data to the selected file.");
      }
   }
   */
}