import java.util.Scanner;

public class Driver
{
	public static void main(String [] args)
	{
		ComputerRPSPlayer a;
      HumanRPSPlayer b;
      
      int oldScoreA = 0;
      int oldScoreB = 0;
      int count = 5;
      
		a= new ComputerRPSPlayer("George");
		b= new HumanRPSPlayer("Kaden");

		System.out.println("0 is the code for "+ComputerRPSPlayer.translate(0));
		System.out.println("1 is the code for "+ComputerRPSPlayer.translate(1));
		System.out.println("2 is the code for "+ComputerRPSPlayer.translate(2));
		System.out.println("3 is the code for "+ComputerRPSPlayer.translate(3));
		System.out.println("---------------------------------");
      
      for(int i = 0;i<count;i++)
      {
         b.fight(a);
         
         if(a.getWins() == oldScoreA && b.getWins() == oldScoreB)
         {
            count++;
         }
         else if(a.getWins() == 3)
         {
            System.out.println(a + " is the Winner!");
            break;
         }
         
         else if(b.getWins() == 3)
         {
            System.out.println(b + " is the Winner!");
            break;
         }
         
         oldScoreA = a.getWins();
         oldScoreB = b.getWins();
         
      }
	}
}

