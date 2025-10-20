/**
 * driver class that executes the Palindrome functions
 *
 * @author  Kaden Turner
 * @version for P2 10/17/2025
 */
public class Driver 
{
   public static void main(String[] args) 
   {
      if (args.length != 1)
      {
         System.out.println("Error: You must provide a valid filename. ");
         return;
      }

      Palindrome p = new Palindrome(args[0]);       //creates a Palindrome object and process's the file
      p.processFile();
   }
}
