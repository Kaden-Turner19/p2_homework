/**
 * a round robin tournament where every player plays every other player once.
 * 
 * @author  Kaden Turner
 * @version 10/12/2025
 */
public class RoundRobinTournament extends RPSTournament
{
   public RoundRobinTournament()
   {
      super();
   }

   /**
    * each player fights every other player once
    */
   public void play()
   {
      for (int i = 0; i < numPlayers - 1; i++)
      {
         for (int j = i + 1; j < numPlayers; j++)
         {
            System.out.println("\nMatch: " + players[i].getName() + " vs " + players[j].getName());
            players[i].fight(players[j]);
         }
      }
   }
}
