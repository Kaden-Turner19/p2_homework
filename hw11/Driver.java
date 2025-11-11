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
      long startTime = System.currentTimeMillis();    //start time
   
      LinkedDictionary ld = new LinkedDictionary("C:/Users/kylet/p2_homework/data/mywords.txt");     //declare the linkeddictionary with the test file
      
      //System.out.println(ld.countAnagrams(new Word("silent")));         //testing for countAnagrams method
      
      ld.displayBigAnagramFamilies();     //testing for displayBigAnagramFamilies method
      
      long endTime = System.currentTimeMillis();      //end time
      
      double totalTime = (endTime - startTime) / 1000.0;    //format time output
      System.out.println("Total time: " + totalTime);    //print total time
	}  
}

