public class RPSPlayerContainer
{
    private RPSPlayer[] players;  // array of players
    private int numPlayers;       // number of players added so far

    public RPSPlayerContainer()
    {
        players = new RPSPlayer[100];  // reserve space for 100 players
        numPlayers = 0;
    }
    /**
     *  When given a player add them to the container
     *
     * @param p New player object to add to the container
    */ 
    public void add(RPSPlayer p)
    {
        if (numPlayers < players.length)
        {
            players[numPlayers] = p;
            numPlayers++;
        }
        else
        {
            System.out.println("Container full. Can't add more players.");
        }
    }
    /**
     *   Displays all players within the container
    */
    public void display()
    {
        System.out.println("\n--- Player List ---");
        for (int i = 0; i < numPlayers; i++)
        {
            players[i].display(); //Uses RPSPlayer display()
        }
        System.out.println("-------------------\n");
    }
}
