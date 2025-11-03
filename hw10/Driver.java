/**
 * Driver for testing IntList code.
 *
 * @author
 * @version
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver
{
	public static void main(String [] args)
	{ 
      //Code testing for the Homework 10
      /*
      Word w1 = new Word("kaden");
      Word w2 = new Word("gfedcba");      //testing the word class to see functionality
      
      System.out.println(w1);    
      System.out.println(w2);
      
      WordNode wn = new WordNode();
      wn.data = "Kaden";
      wn.next = new WordNode();           //testing for the WordNode class 
      wn.next.data = "Turner";
      
      WordList wl = new WordList();
      wl.insert("Kaden");
      wl.insert("Turner");                //testing for the WordList class
      wl.display();
      */
      
      try
      {
         BufferedReader bf;                  //declare the BufferedReader
         String line;
         WordList list = new WordList();
      
         bf = new BufferedReader(new FileReader("C:/Users/kylet/p2_homework/hw10/words.txt"));    //initialize the buffered reader to word.txt
      
         while((line = bf.readLine()) != null)
         {
            list.insert(new Word(line));
         }
         bf.close();
         list.display();
      }
      catch(IOException e)
      {
         System.out.println("Please select a valid file.");
      }
	}
}

