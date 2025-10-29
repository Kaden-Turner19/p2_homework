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
      IntNode temp = head;
      while(temp != null)
      {
         if(temp.data == val)
         {
            System.out.println(temp.data);
            return temp;
         }
         temp = temp.next;
      }
      return null;
	}

	/**
	 * Find first occurrence of val (if it exists) and remove it from the list.
	 *
	 * @param val the value to be removed
	 */
	public void remove(int val)
	{
      IntNode q;
      IntNode p = head;
      
      try
      {
         if(head.data == val)
         {
            head = p.next;    //Condition for if the value is first in list
         }
      
         p = p.next;    //set the p IntNode one ahead of q
         q = head;      //set the q IntNode one behind of p
      
         while(p != null)
         {
            if(p.data == val)
            {
               q.next = p.next;
            }
         p = p.next;
         q = q.next;
         }      
	   }
      catch(NullPointerException e)    //This will handle the case that head is null
      {
         System.out.println("The selected list is empty.");
      }
   }
}
