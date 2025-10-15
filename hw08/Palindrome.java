/**
 * A class that will take in input and determine whether the input is a palindrome
 *
 * @author  Kaden Turner
 * @version for P2 10/15/2025
 *
*/
import java.util.Scanner;

public class Palindrome
{
	public static void main(String [] args)
	{  
      if(args.length != 1)
      {
         System.out.println("Error: There are too many parameters passed, there should only be one.");
      }  
      else
      {
         System.out.println(isPalindrome(args[0]));
      }
	}
   
   /**
    * Will take in a String parameter and determine whether or not its a palindrome
    *
    * @Param word word to be checked
   */
   public static boolean isPalindrome(String word)
   {
      if(word == null || word.length() == 0)
      {
         return false;
      }
      
      for(int i = 0;i<word.length() / 2;i++)
      {
         if(word.charAt(i) != word.charAt(word.length() - 1 - i))
            return false;
      }     
      
      return true;             
   }
}

