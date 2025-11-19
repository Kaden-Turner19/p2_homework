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
      
      //sort();
   }
   
   /**
    * Displays the first 20 elements of the array
    */    
   public void display() {
      ListIterator<Word> li;
      li = this.listIterator();
      Word temp;
      
      while(li.hasNext()) {
         temp = li.next();
         System.out.println(temp);
      }
   }
   
   
   
   
   
   
   /**
    * Helper sort class for qSort
    *    
   public void sort() {
      qSort(0,n-1);
   }
   
   /**
    * Quick sort method that sorts an array
    *
    * @param p the start of the partition
    * @param r the end of the partition
    *  
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
    *    
   public int partition(int p, int r) {
      int i, j;
      Word pivot = data[p];     //the first element in the partition
      
      i = p-1; //i is the left pointer
      j = r+1; //j is the rigth pointer
      
      while(true) {
         do {j--;} while (data[j].compareTo(pivot) > 0);  //move the right pointer
         do {i++;} while (data[i].compareTo(pivot) < 0);  //move the left pointer
         
         if(i >= j) {
            return j;
         }
         
         Word temp = data[i];
         data[i] = data[j];
         data[j] = temp;
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