/**
 * Class that will read from a file, load values into a list and find anagrams from that list
 *
 * @author  Kaden Turner
 * @version 11/5/2025
 *
 */
 
import java.util.*;
import java.lang.*;
import java.io.*;

public class ArrayDictionary extends ArrayList<Word> {

   /**
    * Read words from a file and insert into a list
    *
    * @param file file to read from
    */ 
   public ArrayDictionary(String file) {
      
      try {
         BufferedReader numFile;
         String str;
         
         numFile = new BufferedReader(new FileReader(file));
         
         while((str = numFile.readLine()) !=null) {
            this.add(new Word(str));
         }
         
         numFile.close();
      }   
      catch(IOException e) {
         System.out.println("Please enter a valid file name.");
      }
      
      Collections.sort(this);
   }
    
   /**
    * Read through the list and return the count of w's anagrams
    *
    * @param w value to compare and find anagrams for
    * @return the number of anagrams
    */
   public int countAnagrams(Word w) {
      int index = Collections.binarySearch(this, w);
      if (index == -1) {
         return 0;
      }

      int count = 0;

      for (int i = index - 1; i >= 0; i--) {
         if (w.anagramCheck(this.get(i))) {
            count++;
         } else {
            break;
         }
      }

      for (int i = index + 1; i < this.size(); i++) {
         if (w.anagramCheck(this.get(i))) {
            count++;
         } else {
            break;
         }
      }

      return count;
   }
   
   /**
    * Display each word that has more than 6 anagrams
    */
   public void displayBigAnagramFamilies() {
    int count = 1;
    int numberOfFamilies = 0;

    for (int i = 1; i <= this.size(); i++) {        //loop through the array
        if (i < this.size() && this.get(i).compareTo(this.get(i - 1)) == 0) {    //continue to go through if the words are the same
            count++;    
        }
        else {
            if (count >= 6) {    //check to see if the family contains 6 or more
                System.out.println("Family = " + count);    //just to make it look organized

                for (int j = i - count; j < i; j++) {       // loop through the family and print the data
                    System.out.println(this.get(j));
                }
                numberOfFamilies++;
            }
            count = 1;     //reset the counter
         }
      }
      System.out.println("Number of Families = " + numberOfFamilies);
   }
}