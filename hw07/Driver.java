public class Driver
{
    public static void main(String[] args)
    {
         RPSTournament tournament = new RPSTournament();
         tournament.add(new HumanRPSPlayer("Kaden"));
         tournament.add(new ComputerRPSPlayer("Dave"));
         tournament.add(new ComputerRPSPlayer("James"));
         tournament.add(new ComputerRPSPlayer("Larry"));
         tournament.add(new ComputerRPSPlayer("June"));
         
         tournament.display();
         tournament.sort();
         tournament.display();
    }
}
