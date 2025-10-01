/**
 * A computer Rock, Paper, Scissors player that poses by randomly choosing a
 * pose.
 *
 * @author  Terry Sergeant
 * @version for P2
 *
*/

import java.util.Scanner;

public class ComputerRPSPlayer extends RPSPlayer
{
	public ComputerRPSPlayer(String name)
	{
		super(name);
	}

  /**
   * Computer player choose pose randomly.
   *
   * @return The code for the pose (0=Rock, 1=Paper, 2=Scissors)
  */
	public int pose()
	{
		return (int) (Math.random()*3.0);
	}
   
   /**
	 * Have this player take on another player showing results and updating
	 * win/loss records for each player.
	 */
	public void fight(ComputerRPSPlayer other)
	{
		int me,them;

		// get poses
		me= this.pose();
		them= other.pose();

		// announce poses
		System.out.println(name+" throws "+translate(me)+" ...");
		System.out.println(other.name+" throws "+translate(them)+" ...");

		// announce winner and update win/loss records
		if (me==them)
			System.out.println("Tie!");
		else
		{
			if (them==(me+1)%3)
			{
				System.out.println(other.name+" wins!");
				this.losses++;
				other.wins++;
			}
			else
			{
				System.out.println(this.name+" wins!");
				this.wins++;
				other.losses++;
			}
		}
	}


}
