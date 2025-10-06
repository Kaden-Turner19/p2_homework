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
}
