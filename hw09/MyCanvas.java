/**
 * Program that takes in an ASCII image, be able to modify the file and fill certain spaces.
 *
 * @author  Kaden Turner
 * @version for Program Design 2
*/

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
      image = new char[3][4];
      rows = 3;
      cols = 4;
      
      for(int i = 0;i<3;i++)
      {
         for(int j = 0;j<4;j++)
         {
            image[i][j] = 'a';
         }
      }
   }
   
  /**
   *  Show method that displays the image held within the 2D-Array
   */
   public void show()
   {
      for(int i = 0;i<image.length;i++)
      {
         for(int j = 0;j<image[i].length;j++)
         {
            System.out.print(image[i][j]);
         }
         System.out.println();
      }
      
   }
}