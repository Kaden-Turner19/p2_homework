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
import java.util.ArrayList;
import java.util.ListIterator;

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
      
      sort();
   }
   
   /**
    * Displays the first 20 elements of the array
    *   
   public void display() {
      ListIterator<Word> li;
      li = this.listIterator();
      Word temp;
      
      while(li.hasNext()) {
         temp = li.next();
         System.out.println(temp);
      }
   }
   **/
   
   /**
    * Helper sort class for qSort
    */    
   private void sort() {
      qSort(0,this.size() - 1);
   }
    
   /**
    * Read through the list and return the count of w's anagrams
    *
    * @param w value to compare and find anagrams for
    * @return the number of anagrams
    */
   public int countAnagrams(Word w) {
      int index = binSearch(w);
      if (index == -1) {
         return 0;
      }

      int count = 1;

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
      for (int i = 0;i < this.size();i++) {
         int count = 0;
         
         for (int j = 0;j < this.size();j++) {
            if (this.get(i).anagramCheck(this.get(j))) {
               count++;
            }
         }
         
         if (count >= 7) {
            System.out.println(this.get(i));
            System.out.println(count);
         }
      }
   }
   
   /**
    * Performs a binary search and returns -1 if its not there
    *
    * @param w the Word to search for
    * @return index of a matching Word or -1
    */
   private int binSearch(Word w) {
      return binSearchHelper(w, 0, this.size() - 1);
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
      if (left > right) {
         return -1;
      }
      int mid = (left + right) / 2;
      Word midWord = this.get(mid);

      if (val.compareTo(midWord) == 0) {
         return mid;
      }
      else if (val.compareTo(midWord) < 0) {
         return binSearchHelper(val, left, mid - 1);
      }
      else
         return binSearchHelper(val, mid + 1, right);
   }
      
   /**
    * Quick sort method that sorts an array
    *
    * @param p the start of the partition
    * @param r the end of the partition
    */
   public void qSort(int p, int r) {
      int q;
      
      if(p<r) {
         q = partition(p,r);      //Partition array splitting at q
         qSort(p,q);              //do quicksort on left
         qSort(q+1,r);            //do quicksort on right
      }
   }
   
   /**
    * Partition method that will sort according to the parameters passed
    *
    * @param a array of doubles to sort
    * @param p the start of the partition
    * @param r the end of the partition
    */  
   public int partition(int p, int r) {
      int i, j;
      Word pivot = this.get(p);     //the first element in the partition
      
      i = p-1; //i is the left pointer
      j = r+1; //j is the rigth pointer
      
      while(true) {
         do {j--;} while (this.get(j).compareTo(pivot) > 0);  //move the right pointer
         do {i++;} while (this.get(i).compareTo(pivot) < 0);  //move the left pointer
         
         if(i >= j) {
            return j;
         }
         
         Word temp = this.get(i);
         this.set(i, this.get(j));
         this.set(j, temp);
      } 
   }
}