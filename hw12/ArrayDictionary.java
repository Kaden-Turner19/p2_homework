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

public class ArrayDictionary {
   
   Word[] data;
   int n = 0;
   
   /**
    * Read words from a file and insert into a list
    *
    * @param file file to read from
    */ 
   public ArrayDictionary(String file) {
      
      data = new Word[500000];
      
      try {
         BufferedReader numFile;
         String str;
         
         numFile = new BufferedReader(new FileReader(file));
         
         while((str = numFile.readLine()) !=null) {
            data[n] = (new Word(str));
            n++;
         }
         
         numFile.close();
      }   
      catch(IOException e) {
         System.out.println("Please enter a valid file name.");
      }
      
      sort();
   }
   
   /**
    * Helper sort class for qSort
    */    
   private void sort() {
      qSort(0,n-1);
   }
   
   /**
    * Quick sort method that sorts an array
    *
    * @param p the start of the partition
    * @param r the end of the partition
    */
   public void qSort(int p, int r) {
   
      int q;
      if (p<r) { 
         q = partition(p,r);     //partition array (splits at q)
         qSort(p,q);             //do quicksort on left portion
         qSort(q+1,r);           //do quicksort on right portion
      }
   }
   
   /**
    * Partition method that will sort according to the parameters passed
    *
    * @param p the start of the partition
    * @param r the end of the partition
    * @returns the split point
    */  
   public int partition(int p, int r) {
   
      int i, j;
      Word k = data[p];  //first element in partition
      Word temp;
      i = p-1;    //i is our left pointer
      j = r+1;    //j is our right pointer
      
      do {
         do { j--; } while (data[j].compareTo(k) > 0);   //move right pointer
         do { i++; } while (data[i].compareTo(k) < 0);   //move left pointer
         if (i<j) {                       //if the pointers have not crossed
            temp = data[i];                  //then we swap
            data[i] = data[j];
            data[j] = temp;
         }
      }
      while (i<j);      //stop when i & j have crossed
      return j;
   }   
    
   /**
    * Read through the list and return the count of w's anagrams
    *
    * @param w value to compare and find anagrams for
    * @return the number of anagrams
    */
   public int countAnagrams(Word w) {
      int index = binSearch(w);     //call binary search to find the index of the word
      
      if (index == -1) {            //if there is no index than we return 0
         return 0;
      }

      int count = 0;    //count variable to hold the number of anagrams
   
      if(index - 1 > -1) {    //if index is at the front of the list than dont search left
         for (int i = index - 1; i >= 0; i--) {    //search to the left of the index for anagrams
            if (w.anagramCheck(data[i])) {         //if anagramCheck is true than increase count
               count++;
            }
            else {
               break;
            }
         }
      }

      if (index + 1 < n) {                        //if the index is at the end of the list than don't proceed
         for (int i = index + 1; i < n; i++) {    //search to the right of the index for anagrams
            if (w.anagramCheck(data[i])) {                  //if anagramCheck is true than increase count        
               count++;
            } else {
               break;
            }
         }
      }

      return count;     //return the total count variable
   }
   
   /**
    * Display each word that has more than 6 anagrams
    */
   public void displayBigAnagramFamilies() {
    int count = 1;
    int numberOfFamilies = 0;

    for (int i = 1; i <= n; i++) {        //loop through the array
        if (i < n && data[i].compareTo(data[i - 1]) == 0) {    //continue to go through if the words are the same
            count++;    
        }
        else {
            if (count >= 6) {    //check to see if the family contains 7 or more
                System.out.println("Family = " + count);    //just to make it look organized

                for (int j = i - count; j < i; j++) {       // loop through the family and print the data
                    System.out.println(data[j]);
                }
                numberOfFamilies++;
            }
            count = 1;     //reset the counter
         }
      }
      System.out.println("Number of Families = " + numberOfFamilies);
   }
   
   /**
    * Performs a binary search and returns -1 if its not there
    *
    * @param w the Word to search for
    * @return index of a matching Word or -1
    */
   private int binSearch(Word w) {
      return binSearchHelper(w, 0, n-1);
   }

   /**
    * Helper method that helps with recursion
    *
    * @param val the Word to search for
    * @param left left boundary of search range
    * @param right right boundary of search range
    * @return index where found or -1
    */
   private int binSearchHelper(Word val, int left, int right) {
   
      if(left > right) {      //if the left boundary is larger than the right than return -1
         return -1;
      }
      
      int middle = (left + right) / 2;    //locate the middle 
      if (val.compareTo(data[middle]) == 0) {          //if val is == to data[middle] value than return middle
         return middle;
      }
      else if (val.compareTo(data[middle]) < 0) {     //if val is < data[middle] value than recursively search below
         return binSearchHelper(val, left, middle - 1);
      } 
      else {
         return binSearchHelper(val, middle + 1, right);
      }
   }
}