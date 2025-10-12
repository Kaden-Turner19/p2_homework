/**
 * A tournament class that simulates a tournament with set players
 * 
 *
 * @author  Kaden Turner
 * @version for P2
 *
*/
public abstract class RPSTournament extends RPSPlayerContainer
{     
   public RPSTournament()
   {
      super();
   }
   
  /**
    *  P lay method to set up tournament
   */ 
   public abstract void play();
      
  /**
   *  Sort method that will take the RPSPlayers and sort them by increasing order
  */ 
   public void sort()
   {  
      for(int i = 0;i < numPlayers-1;i++)
      {
         int min = i;
            
         for(int j = i+1;j < numPlayers;j++)
         {
            if(players[j].compareTo(players[min]) < 0)
            {
               min = j;
            }
         }
            
         RPSPlayer temp = (players[i]);
         players[i] = players[min];
         players[min] = temp;
       }
    }
}