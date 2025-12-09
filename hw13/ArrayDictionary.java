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
      int count;
      int numberOfFamilies = 0;                             //int to hold the count of families
      
      for(int i = 0;i<this.size();i++) {                              //loops through each word
         count = countAnagrams(this.get(i));                //counts the number of anagrams for the selected word using binary search within countAnagrams
         
         if(count >= 6) {                                   //if that count is greater than or equal to 6 than its considered a big family
            numberOfFamilies++;                             //increase the counter
            
            System.out.println("Family = " + (count + 1));  //print out the size of the family
            System.out.println(this.get(i));                    //print out the main word
            
            for (int left = i - 1; left >= 0; left--) {     //logic to print left of the desired word, starting one left of the word
                if (this.get(i).anagramCheck(this.get(left))) {     //check if its an anagram
                    System.out.println(this.get(left));         //print the word if it is an anagram
                } else {
                    break;                                  //if not than break out of the loop
                }
            }
            
            int skipRight = 0;
            for (int right = i + 1; right < this.size(); right++) {   //logic to print the right side, starting one to the right
                if (this.get(i).anagramCheck(this.get(right))) {    //check if its an anagram
                    System.out.println(this.get(right));        //print if it is
                    skipRight++;                            //counts how far the family goes to the right
                } else {
                    break;                                  //if not than break the loop
                }
            }
            i = i + skipRight;                              //moves i forward past the family of anagrams, 
                                                            //prevents printing the same family again
         }
      }
   
      System.out.println("Number of Families = " + numberOfFamilies);   //prints the number of families found
   }
}