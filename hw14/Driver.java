/**
 * Driver for testing MyStack.
 *
 * @author  Kaden Turner
 * @version 12/2/2025
 *
 */

public class Driver
{
	public static void main(String [] args)
	{
		MyStack s= new MyStack();

		s.push(10);
		s.push(20);
		s.push(15);
		s.push(25);
		s.push(12);

		while (!s.isEmpty())
			System.out.println(s.pop());

	}
}

