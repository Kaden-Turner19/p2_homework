/**
 * Personal Movie Inventory System.
 *
 * @author  Kaden Turner
 * @version 9/28/2025
 *
 * <pre>
 * This is the starter code for the parallel array version of the movie
 * inventory system.
 * </pre>
*/
import java.io.*;
import java.util.Scanner;

public class  MovieUI
{
   private MovieContainer mc;
   private Scanner kb;
   
   /**
    * MovieUI constructor to create the movie container and scanner
    *
    * @param dataFile file to load data from
   */
   public MovieUI(String dataFile)
   {
      this.mc = new MovieContainer(dataFile);
      this.kb = new Scanner(System.in);
   }
   
   /**
    * Provides menu and chooses action
   */
   public void run()
   {
      int choice;						 // user's selection from the menu       

		do {
			choice = getMenuChoice();
         
			if (choice==1)
				numberOfEntries = enterMovie(movies,numberOfEntries);
			else if (choice==3)
				displayAll(movies,numberOfEntries);
         else if (choice==6)
            	searchByYear(movies,numberOfEntries);
			else if (choice==5)
				searchByTitle(movies, numberOfEntries);
         else if (choice==4)
            searchByGenre(movies,numberOfEntries);
         else if (choice==2)
            numberOfEntries = deleteMovie(movies, numberOfEntries);           
		} while (choice!=0);
      
		System.out.println("\nTHE END");

   }
   
	/**
	 * Allow user to enter a new movie.
	 *
	 * @param movie Array of Movie objects
	 * @param n the actual number of movies currently in the array
	 * @return the new movie count
	*/
	public static int enterMovie(Movie[] movie, int n)
	{
		Scanner kb= new Scanner(System.in);
		System.out.print("Enter movie title : ");
		String title = kb.nextLine();
		System.out.print("Enter movie genre: ");
		String genre = kb.nextLine();
		System.out.print("Enter year of movie: ");
		int year = kb.nextInt();
		kb.nextLine();
      
      movie[n] = new Movie(title, genre, year);

		return n+1;
	}
   
	/**
	 * Displays menu and get's user's selection
	 *
	 * @return the user's menu selection
	*/
	public int getMenuChoice()
	{
		int choice;	 // user's selection

		System.out.println("\n\n");
		System.out.print("------------------------------------\n");
		System.out.print("[1] Add a Movie\n");
		System.out.print("[2] Delete a Movie\n");
		System.out.print("[3] List All Movies\n");
		System.out.print("[4] Search by Genre\n");
		System.out.print("[5] Search by Title\n");
		System.out.print("[6] Search by Year\n");
		System.out.print("---\n");
		System.out.print("[0] Exit Program\n");
		System.out.print("------------------------------------\n");
		do {
			System.out.print("Your choice: ");
			choice= kb.nextInt();
		} while (choice < 0 || choice > 6);

		return choice;
	}
   
   /**
	 * prompt the user to enter a year and display all movies that match the given year.
    *
	 * @param movie Array of Movie Objects
    * @param n number of elements in the array
	*/
   public void searchByYear(Movie[] movie, int n)
   {
      Scanner scan = new Scanner(System.in);    //Declaring a new scanner for this method
      System.out.println("Enter the year you want to search for: ");
      int search = scan.nextInt();     //Storing user input for later search
      
      System.out.println("------------------------------------------------");
      System.out.printf("%-30s %-20s %s\n","TITLE","GENRE","YEAR");     //Formatted Strings copied from the main method to preserve aesthetic
      
      for(int i = 0;i < n;i++)
      {
         if(movie[i].getYear() == search)
            System.out.printf("%-30s %-20s %4d\n", movie[i].getTitle(), movie[i].getGenre(), movie[i].getYear());
      }
   }
   
  /**
   * prompt the user to enter a title and display all movies that match the given title.
   *
	* @param movie Array of Movie Objects
   * @param n number of elements in the array
  */
  public void searchByTitle(Movie[] movie, int n)
  {
      Scanner scan = new Scanner(System.in);    //declare new Scanner
      System.out.println("Enter title to search for: ");
      String searchTitle = scan.nextLine();
      
      searchTitle = searchTitle.toLowerCase();     //convert user input to lower case
    
      System.out.println("------------------------------------------------");
      System.out.printf("%-30s %-20s %-5s %s\n","TITLE","GENRE","YEAR","ID");     //formatted Strings copied from the main method to preserve aesthetic
                                                                                  //added the ID column for the deleteMovie method
    
      for(int i = 0;i < n;i++)
	   {
		   if(movie[i].getTitle().toLowerCase().contains(searchTitle))  //.contain will handle the partial matching if there is any
		   {
			   System.out.printf("%-30s %-20s %-5d %4d\n",movie[i].getTitle(),movie[i].getGenre(),movie[i].getYear(),i);    //formatted string copied from the other methods
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
   public void searchByGenre(Movie[] movie, int n)
   {
      Scanner scan = new Scanner(System.in);    //declare new scanner
      System.out.println("Enter genre to search for: ");
      String searchGenre = scan.nextLine();
      
      searchGenre = searchGenre.toLowerCase();     //making the search case insensitive
      
      System.out.println("------------------------------------------------");
      System.out.printf("%-30s %-20s %s\n","TITLE","GENRE","YEAR");     //formatted Strings copied from the main method
      
      for(int i = 0;i < n;i++)
      {
         if(movie[i].getGenre().toLowerCase().equals(searchGenre))
         {
            System.out.print(movie[i]);      //formatted Strings copied from the main mehtod
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
   public int deleteMovie(Movie[] movie, int n)
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
}
