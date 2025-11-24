/**
 * Demonstrates use of Java's ArrayList.
 *
 * @author  TSergeant
 * @version for Program Design 2
 */

import java.util.ArrayList;
import java.util.ListIterator;

public class DemoArrayList
{
	public static void main(String [] args)
	{
      /*
		ArrayList<String> al;

		al= new ArrayList<String>();

		al.add("hi");
		al.add("there");
		System.out.println(al.size());
		System.out.println(al.get(0));
		System.out.println(al.get(1));
      System.out.println(al.indexOf("hi"));
      */
      
      ArrayList<Word> wl;
      ListIterator<Word> it;
      
      wl = new ArrayList<Word>();
      wl.add(new Word("Kaden"));
      wl.add(new Word("Turner"));
      wl.add(new Word("Football"));
      
      it = wl.listIterator();     
      Word temp;
      
      while(it.hasNext()) {
         temp = it.next();
         System.out.println(temp);
      }
      
      
      /*a
      System.out.println(wl.indexOf(new Word("Kaden")));    //should return 0
      System.out.println(wl.get(1));                        //should return "Turner"
      System.out.println(wl.size());      
      wl.remove(new Word("Football"));
      System.out.println(wl.size());
      */
	}
}
