public class Driver
{
   public static void main(String[] args)
   {
      RoundRobinTournament tournament = new RoundRobinTournament();

      // Add 7 players (mix of human and computer)
      tournament.add(new HumanRPSPlayer("Kaden"));
      tournament.add(new ComputerRPSPlayer("Dave"));
      tournament.add(new ComputerRPSPlayer("James"));
      tournament.add(new ComputerRPSPlayer("Larry"));
      tournament.add(new ComputerRPSPlayer("June"));
      tournament.add(new ComputerRPSPlayer("Sarah"));
      tournament.add(new ComputerRPSPlayer("Mike"));

      System.out.println("\n Starting Round Robin Tournament ");
      tournament.display();

      tournament.play();

      System.out.println("\n Tournament Over ");
      System.out.println("\nSorting players by best record...");
      tournament.sort();
      tournament.display();
   }
}

