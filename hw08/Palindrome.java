/**
 * reads a list of words and finds the amount of palindromes. displays stats as well
 *
 * @author  Kaden Turner
 * @version for P2 10/17/2025
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Palindrome 
{
   private String filename;

   /**s
    * constructor accepts the input file name
    *
    * @param filename name of the input file
   */
   public Palindrome(String filename)
   {
       this.filename = filename;
   }

   /**
    * reads words from file, determines palindrome stats, and prints the results
    */
   public void processFile() 
   {
      int totalWords = 0;
      int palindromeCount = 0;
      CodeTimer timer = new CodeTimer();

      timer.start();

      try(BufferedReader reader = new BufferedReader(new FileReader(filename))) 
      {
         String word;
            
         while((word = reader.readLine()) != null)
         {
            word = word.trim();
            if(!word.isEmpty())
            {
               totalWords++;
               if(isPalindrome(word)) 
               {
                  palindromeCount++;
               }
            }
         }
       } 
       catch(IOException e) 
       {
         System.out.println("Error reading file: " + e.getMessage());
         return;
       }

       timer.stop();
       double percent;
        
       if (totalWords > 0)
       {
         percent = (100.0 * palindromeCount / totalWords);
       } 
       else
       {
         percent = 0.0;
       }

       DecimalFormat df = new DecimalFormat("0.000");

       System.out.println("+--------------------------------------------+");
       System.out.println("Input File : " + filename);
       System.out.println("Words Processed: " + totalWords);
       System.out.println("# Palindromes : " + palindromeCount);
       System.out.println("% Palindromes : " + df.format(percent) + "%");
       System.out.println("Time Elapsed : " + df.format(timer.getElapsedSeconds()));
       System.out.println("+--------------------------------------------+");
   }

  /**
   * determines if the string is a palindrome.
   *
   * @param word word to check
   * @return true if the word is a palindrome, else false
   */
   public static boolean isPalindrome(String word)
   {
      if(word == null || word.length() == 0) 
      {
         return false;
      }

      word = word.toLowerCase();
      for (int i = 0; i < word.length() / 2; i++) 
      {
         if (word.charAt(i) != word.charAt(word.length() - 1 - i)) 
         {
            return false;
         }
      }

      return true;
    }
}
