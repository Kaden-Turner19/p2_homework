/**
 * Driver for testing IntList code.
 *
 * @author
 * @version
 *
 */

public class Driver
{
	public static void main(String [] args)
	{
      IntList list = new IntList();
      
      list.insert(10);
      list.insert(15);
      list.insert(20);     //testing for insert method
      list.display();
      
      System.out.println();      
      list.search(10);      
      System.out.println();      //testing for search method
      list.search(15);
      System.out.println();
      
      list.remove(20);     //testing for remove method
      list.display(); 
      System.out.println();      //delete first instance in list
      
      list.insert(25);
      list.remove(15);        //delete second instance in list
      list.display();
      System.out.println();
      
      list.remove(10);     //delete the last instance of the list
      list.display();
      System.out.println();
      
      list.remove(25);     //delete the last and only instance of the list
      System.out.println();
      
      list.remove(10);     //attempt to delete a value while the list is null
	}
}

