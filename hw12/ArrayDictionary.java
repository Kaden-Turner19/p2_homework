/**
 * Class that will read from a file, load values into a list and find anagrams from that list
 *
 * @author  Kaden Turner
 * @version 11/5/2025
 *
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArrayDictionary
{

   private Word[] data;
   private int n = 0;

   /**
    * Read words from a file and insert into a list
    *
    * @param file file to read from
    */ 
   public ArrayDictionary(String file)
   {
      data = new Word[500000];
      
      try
      {
         BufferedReader numFile;
         String str;
         
         numFile = new BufferedReader(new FileReader(file));
         while((str = numFile.readLine()) !=null)
         {
            data[n] = (new Word(str));
            n++;
         }
         
         numFile.close();
      }   
      catch(IOException e)
      {
         System.out.println("Please enter a valid file name.");
      }
   }
   
   /**
    * Read through the list and return the count of w's anagrams
    *
    * @param w value to compare and find anagrams for
    
   public int countAnagrams(Word w)
   {
      int count = 0;
      WordNode c = head;
      
      while(c != null)
      {
         if(w.anagramCheck(c.data) == true)
         {
            count++;
         }
         c = c.next;
      }
      
      return count;
   }
   
   /**
    * Display each word that has more than 6 anagrams
    
   public void displayBigAnagramFamilies()
   {
      WordNode cur = head;
      
      while(cur != null)
      {
         WordNode test = head;
         int count = 0;
         
         while(test != null)
         {
            if(cur.data.anagramCheck(test.data))
            {
               count++;
            }
            
            test = test.next;
         }
         if(count >= 6)
         {
            System.out.println(cur.data);
            System.out.println(count);
         }
         
         cur = cur.next;
      }
   }
   */
}