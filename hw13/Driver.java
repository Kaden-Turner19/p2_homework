/**
 * Driver for testing IntList code.
 *
 * @author  Kaden Turner
 * @version 11/5/2025
 *
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Driver
{
	public static void main(String [] args)
	{     
      ArrayDictionary ad = new ArrayDictionary("C:/Users/kylet/p2_homework/data/mywords.txt");
      
      //System.out.println(ad.countAnagrams(new Word("soccer")));      //testing with small file
      //System.out.println(ad.countAnagrams(new Word("listen")));
      
      long startTime = System.currentTimeMillis();    //start time
      
      System.out.println(ad.countAnagrams(new Word("aaa")));
      System.out.println(ad.countAnagrams(new Word("abduction")));
      System.out.println(ad.countAnagrams(new Word("xyz")));
      System.out.println(ad.countAnagrams(new Word("uio")));
      System.out.println(ad.countAnagrams(new Word("silent")));
      System.out.println(ad.countAnagrams(new Word("hero")));
      System.out.println(ad.countAnagrams(new Word("jjj")));
      System.out.println(ad.countAnagrams(new Word("long")));
      System.out.println(ad.countAnagrams(new Word("pole")));
      
      
      long endTime = System.currentTimeMillis();      //end time
      
      double totalTime = (endTime - startTime) / 1000.0;    //format time output
      System.out.println("Total time: " + totalTime);    //print total time
	}  
}

