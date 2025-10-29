/**
 * A linked list of integer values.
 *
 * @author
 * @version
 *
 */
public class IntList
{
	private IntNode head;

	/**
	 * A new list has head pointing nowhere.
	 */
	public IntList()
	{
		head = null;
	}

	/**
	 * Displays contents of the list.
	 */
	public void display()
	{
      IntNode cur = head;
      while(cur != null)
      {
         System.out.print(cur.data + " ");
         cur = cur.next;
      }
	}

	/**
	 * In an unordered list we can just add to the front.
	 *
	 * @param newdata The new element to be inserted into the list.
	 */
	public void insert(int newdata)
	{  
      IntNode node = new IntNode();    //create new node
      node.data = newdata;             //store newdata into new node data  
      node.next = head;
      head = node;
	}

	/**
	 * Search the list for the value val.
	 *
	 * @param val the value to be searched for
	 * @return reference to the found node (null if not found)
	 */
	public IntNode search(int val)
	{
		return null;
	}

	/**
	 * Find first occurrence of val (if it exists) and remove it from the list.
	 *
	 * @param val the value to be removed
	 */
	public void remove(int val)
	{
	}
}
