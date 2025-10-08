/**
 * A human Rock, Paper, Scissors player that poses by having the user
 * select the pose.
 *
 * @author  Terry Sergeant
 * @version for P2
 *
*/

import java.util.Scanner;

public class HumanRPSPlayer extends RPSPlayer
{
	public HumanRPSPlayer(String name)
	{
      super(name);
	}

  /**
   * Human player chooses pose from a menu.
   *
   * @return The code for the pose (0=Rock, 1=Paper, 2=Scissors)
  */
	public int pose()
	{
		Scanner kb= new Scanner(System.in);
		int choice;

		System.out.println("+------------------+");
		System.out.println("| 0) Rock          |");
		System.out.println("| 1) Paper         |");
		System.out.println("| 2) Scissors      |");
		System.out.println("+------------------+");
		System.out.print  ("| Choose: ");
		do {
			choice= kb.nextInt();
		} while (choice<0 || choice > 2);

		System.out.println("+------------------+");

		return choice;
	}
}
