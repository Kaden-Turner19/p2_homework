public class Driver
{
    public static void main(String[] args)
    {
        RPSPlayerContainer container = new RPSPlayerContainer();

        RPSPlayer a = new ComputerRPSPlayer("CPU_1");
        RPSPlayer b = new HumanRPSPlayer("Kaden");
        RPSPlayer c = new ComputerRPSPlayer("CPU_2");

        //add to container
        container.add(a);
        container.add(b);
        container.add(c);

        //display container
        container.display();

        //human vs computer
        System.out.println("Let's play a match between " + b.getName() + " and " + a.getName() + "\n");
        b.fight(a);

        //show updated results
        container.display();
        
        System.out.println(b.getName() + " vs " + a.getName() + ": " + b.compareTo(a));
        System.out.println(a.getName() + " vs " + c.getName() + ": " + a.compareTo(c));
        System.out.println(a.getName() + " vs " + a.getName() + ": " + a.compareTo(a));
    }
}
