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
				enterMovie();
         else if (choice==6)
            searchByYear();
			else if (choice==5)
				searchByTitle();
         else if (choice==4)
            searchByGenre();
         else if (choice==2)
            deleteMovie();
         else if (choice==3)
            mc.display();           
		} while (choice!=0);
      
		System.out.println("\nTHE END");

   }
   
	/**
	 * Allow user to enter a new movie.
	*/
	public void enterMovie()
	{
		System.out.println("Enter movie title : ");
		String title = kb.nextLine();
		System.out.println("Enter movie genre: ");
		String genre = kb.nextLine();
		System.out.println("Enter year of movie: ");
		int year = kb.nextInt();
		kb.nextLine();
      
      mc.insert(title, genre, year);
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
	 * Search movies by number of years
	*/
   public void searchByYear()
   {
      int year;
      System.out.println("Enter the year you want to search for: ");
      year = kb.nextInt();     //Storing user input for later search
      kb.nextLine();
      mc.searchByYear(year);
   }
   
  /**
   * Search movies by name of title
  */
  public void searchByTitle()
  {
      System.out.println("Enter title to search for: ");
      String searchTitle = kb.nextLine();
      mc.searchByTitle(searchTitle);    
   }
   
   /**
    * Search movies by name of genre
   */
   public void searchByGenre()
   {
      System.out.println("Enter genre to search for: ");
      String searchGenre = kb.nextLine();
      mc.searchByGenre(searchGenre);
   }
   
   /**
    * prompt the user to enter a title to be deleted
   */
   public void deleteMovie()
   {
      System.out.println("Enter the name of the title you want to delete: ");
      String t = kb.nextLine();
      mc.searchByTitle(t);     //shows available movies to delete
      
      System.out.println("Enter the ID number you would like to delete: ");
      int id = kb.nextInt();      //id variable to use for deletion
      mc.remove(id);
   }
}
