/**
 * Personal Movie Inventory System.
 *
 * @author  Kaden Turner
 * @version 9/3/2025
 *
 * <pre>
 * This is the starter code for the parallel array version of the movie
 * inventory system.
 * </pre>
*/

import java.util.Scanner;
import java.io.*;

public class ParallelArrayMovies
{
	public static final String DATAFILE= "../data/tinymovielist.txt";
	public static final int MAXMOVIES= 10000;

	public static void main(String [] args)
	{
		int choice;						 // user's selection from the menu
		String [] titles= new String[MAXMOVIES];
		String [] genres= new String[MAXMOVIES];
		int [] years= new int[MAXMOVIES];
		int numberOfEntries;
      


		numberOfEntries= loadMovies(titles,genres,years);
		System.out.println("Number of entries read from data file: "+numberOfEntries);
		do {
			choice= getMenuChoice();
			if (choice==1)
				numberOfEntries= enterMovie(titles,genres,years,numberOfEntries);
			else if (choice==3)
				displayAll(titles,genres,years,numberOfEntries);
         else if (choice==6)
            searchByYear(titles,genres,years,numberOfEntries);
            
		} while (choice!=0);

		System.out.println("\nTHE END");
	}


	/**
	 * Allow user to enter a new movie.
	 *
	 * @param titles array of movie titles
	 * @param genres array of movie genres
	 * @param years array of movie copyright dates
	 * @param n the actual number of movies currently in the array
	 * @return the new movie count
	*/
	public static int enterMovie(String [] titles, String [] genres, int [] years, int n)
	{
		Scanner kb= new Scanner(System.in);
		System.out.print("Enter movie title : ");
		titles[n]= kb.nextLine();
		System.out.print("Enter movie genre: ");
		genres[n]= kb.nextLine();
		System.out.print("Enter year of movie: ");
		years[n]= kb.nextInt();
		kb.nextLine();

		return n+1;
	}




	/**
	 * Load movies from the data file into the arrays
	 *
	 * @param titles array of movie titles
	 * @param genres array of movie genres
	 * @param years array of movie copyright dates
	 * @return the actual number of movies loaded into the arrays
	*/
	public static int loadMovies(String [] titles, String [] genres, int [] years)
	{
      int count = 0;       //Count variable to return, will hold the number of movies added
      
      try{
         Scanner scan = new Scanner(new File(DATAFILE));    //Opens new scanner object reading from the specified file
         
         while(scan.hasNextLine())
         {
            titles[count] = scan.nextLine().trim();
            genres[count] = scan.nextLine().trim();
            years[count] = scan.nextInt();
            scan.nextLine();     //Used to obtain the leftover newline
            
            count++;
         }
         
         scan.close();
      }
      catch(FileNotFoundException e){
         System.out.println("Error: Could not load data file " + DATAFILE);
      }

		return count;
	}



	/**
	 * Displays all movie information.
	 *
	 * @param titles array of movie titles
	 * @param genres array of movie genres
	 * @param years array of movie copyright dates
	 * @param n the actual number of movies currently in the array
	*/
	public static void displayAll(String [] titles, String [] genres, int [] years, int n)
	{
		int i;
		System.out.println("------------------------------------------------");
		System.out.printf("%-30s %-20s %s\n","TITLE","GENRE","YEAR");
		for (i=0; i<n; i++)
			System.out.printf("%-30s %-20s %4d\n",titles[i],genres[i],years[i]);
	}


	/**
	 * Displays menu and get's user's selection
	 *
	 * @return the user's menu selection
	*/
	public static int getMenuChoice()
	{
		Scanner kb= new Scanner(System.in);
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
    * @param titles array of movie titles
	 * @param genres array of movie genres
	 * @param years array of movie copyright dates
    * @param n number of elements in the array
	*/
   public static void searchByYear(String [] titles, String [] genres, int [] years, int n)
   {
      Scanner kb = new Scanner(System.in);
      System.out.println("Enter year to search for: ");
      int searchYear = kb.nextInt();
      boolean found = false;  //Used to determine if there are any movies for specified search
      
      System.out.println("------------------------------------------------");
		System.out.printf("%-30s %-20s %s\n","TITLE","GENRE","YEAR");

		for (int i=0; i<n; i++)
      {
			if(years[i] == searchYear)
         {
            System.out.printf("%-30s %-20s %4d\n", titles[i], genres[i], years[i]);
            found = true;
         }
      }
      
      if (!found)
         System.out.println("No movies found for this year " + searchYear + ".");
   }
}
