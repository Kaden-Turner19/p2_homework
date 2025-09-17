/**
 * A Clicker is used to count things.
 *
 * @author  Kaden Turner
 * @version    9/17/2025
 */
public class Clicker
{
    private int value;  // the current count (hidden inside the object)

    public Clicker()
    {
        value = 0;  // starts at zero
    }
    /**
     * Increments the counter by 1 (simulates pressing the button).
     */
    public void increment()
    {
        value++;
    }

    /**
     * Resets the counter back to zero.
     */
    public void reset()
    {
        value = 0;
    }

    /**
     * Returns the current value (simulates reading the display).
     *
     * @return the current count
     */
    public int getValue()
    {
        return value;
    }

    /**
     * Returns a string representation of the Clicker.
     *
     * @return a string with the current value
     */
    public String toString()
    {
        return "Clicker value: " + value;
    }
}


