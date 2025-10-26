/**
 * Program that takes in an ASCII image, be able to modify the file and fill certain spaces.
 *
 * @author  Kaden Turner
 * @version for Program Design 2
*/
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyCanvas
{
   private int rows;    //int that stores the amount of rows in the array
   private int cols;    //int that stores the amount of columns in the array
   
   private char[][] image;       //2D-Array of char's that contains an image
   private char borderChar;      //character variable that holds the border character
   
  /**
   * Load method that takes in a file name as a string and loads that file into the array
   *
   * @param fileName String that holds the file name
   */
   public void load(String fileName)
   {     
      try(Scanner scan = new Scanner(new FileReader(fileName)))     //closes if the file is invalid
      {
         rows = scan.nextInt();     //reads the rows and column amounts and stores them
         cols = scan.nextInt();
         scan.nextLine();
         
         image = new char[rows][cols];    //intializes the 2D-Array
         
         for(int i = 0;i<rows;i++)
         {
            if(scan.hasNextLine())
            {
               String line = scan.nextLine();      //read the next line in the file
               
               for(int j = 0;j<cols && j<line.length();j++)    //handles the event that cols is less than line length
               {
                  image[i][j] = line.charAt(j);
               }
               for(int j = line.length(); j<cols;j++)       //fills the remaining columns with spaces if the line is too short 
               {
                  image[i][j] = ' ';
               }
            }
         }
      }
      catch(IOException e)
      {
         System.out.println("ERROR: Please enter a valid text file to read");
      }
      
   }
   
  /**
   *  Show method that displays the image held within the 2D-Array
   */
   public void show()
   {
      for(int i = 0;i<rows;i++)
      {
         for(int j = 0;j<cols;j++)
         {
            System.out.print(image[i][j]);
         }
         System.out.println();
      }    
   }
   
  /**
   * fill method that will fill any open space with characters
   *
   * @param filler character to fill empty space with 
   * @param i First coordinate in the 2D-array
   * @param j Second coordinate in the 2D-array 
   */
   public void fill(char filler, int i, int j)
   {      
      if(i < 0 || i >= rows || j < 0 || j >= cols) //if the parameters are out of bounds then return
      {
         return;
      }
      
      if(image[i][j] == borderChar || image[i][j] == filler)   //if the desired location is a border character or already the desired character then return
      {
         return;
      }
      
      image[i][j] = filler;   //fill the initial square
      
      fill(filler, i-1, j);   //fill up
      fill(filler, i, j-1);   //fill left
      fill(filler, i, j+1);   //fill right
      fill(filler, i+1,j);    //fill down
      
   }
   
  /**
   * setBorder method that will set the border character
   *
   * @param b border character
   */
   public void setBorder(char b)
   {
      this.borderChar = b;
   }
}