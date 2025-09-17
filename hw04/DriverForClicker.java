/**
 * This driver is for testing the Clicker class.
 *
 * @author
 * @version
 *
*/

public class DriverForClicker
{
	public static void main(String [] args)
	{
		Clicker one,two,three;

		System.out.println("Welcome to the Clicker tester");
      
      one = new Clicker();
      one.increment();
      System.out.println("Here is the current value: " + one.getValue());
      one.reset();
      System.out.println(one);
      
      two = new Clicker();
      two.increment();
      two.increment();
      two.increment();
      System.out.println(two);
	}
}

