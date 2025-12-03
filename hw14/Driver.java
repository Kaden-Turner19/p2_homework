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
		MyStack s = new MyStack();

      System.out.println(s.checkParens("((hi there)"));
      System.out.println(s.checkParens("(hi there)) how are( you?"));
      System.out.println(s.checkParens("(hi there)"));
      System.out.println(s.checkParens("(hi there (how)(are)(you (doing (today))) now)."));        
	}
}

