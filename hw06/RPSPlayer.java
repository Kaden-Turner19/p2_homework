/**
 * A computer Rock, Paper, Scissors class that will contain most functions for both Player classes.
 * 
 *
 * @author  Kaden Turner
 * @version for P2
 *
*/

import java.util.Scanner;

public class RPSPlayer
{
   protected String name; // player's name
	protected int wins;    // number of wins since last reset
	protected int losses;  // number of losses since last reset
   
   public RPSPlayer(String name)
   {
      this.name = name;
      wins= losses= 0;
   }
   
  /**
   * Computer player choose pose randomly.
   *
   * @return The code for the pose (0=Rock, 1=Paper, 2=Scissors)
   
  */
	/*public int pose()
	{
	}
   */
   
   /**
	 * @return name of the player
	 */
	public String toString()
	{
		return name;
	}
   
	/**
	 * Restore wins and losses to zeroes.
	 */
	public void reset() { wins= losses= 0; }
   
	/**
	 * Getter for name.
	 * @return player's name
	 */
	public String getName() { return name; }


	/**
	 * Getter for wins.
	 * @return number of wins
	 */
	public int getWins() { return wins; }


	/**
	 * Getter for losses.
	 * @return number of losses
	 */
	public int getLosses() { return losses; }
   
	/**
	 * Present player name along with win/loss record.
	 */
	public void display()
	{
		System.out.printf("%-15s: %2d-%2d\n",name,wins,losses);
	}
   
	/**
	 * Converts a pose code into the appropriate string.
	 * @param code either 0, 1, or 2
	 * @return a String where 0=rock, 1=paper, 2=scissors
	 */
	public static String translate(int code)
	{
		switch (code)
		{
			case 0 : return "Rock";
			case 1 : return "Paper";
			case 2 : return "Scissors";
  			default: return "Invalid code";
		}
	}
   

}