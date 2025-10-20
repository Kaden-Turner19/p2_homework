/**
 * timer class used to track time
 *
 * @author  Kaden Turner
 * @version for P2 10/17/2025
 */
public class CodeTimer 
{
   private long startTime;
   private long endTime;
   
  /**
   * method to start the timer
   */
   public void start() 
   {
       startTime = System.nanoTime();
   }
  /**
   * method to stop the timer
   */ 
   public void stop()
   {
       endTime = System.nanoTime();
   }
  /**
   * method gets the amount of time elapsed
   */
   public double getElapsedSeconds() 
   {
       return (endTime - startTime) / 1_000_000_000.0;
   }
}
