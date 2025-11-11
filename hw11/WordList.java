/**
 * A linked list of Word values.
 *
 * @author  Kaden Turner
 * @version 11/2/2025
 *
 */
public class WordList
{
	protected WordNode head;

	/**
	 * A new list has head pointing nowhere.
	 */
	public WordList()
	{
		head = null;
	}

	/**
	 * Displays contents of the list.
	 */
	public void display()
	{
      WordNode cur = head;
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
	public void insert(Word newdata)
	{  
      WordNode node = new WordNode();    //create new node
      node.data = newdata;             //store newdata into new node data  
      node.next = head;
      head = node;
	}
   
	/**
	 * Search the list for the Word w.
	 *
	 * @param w the Word to be searched for
	 * @return reference to the found Word (null if not found)
    */
	public Word search(Word w)
	{
      WordNode temp = head;
      while(temp != null)
      {
         if(temp.data.equals(w))
         {
            System.out.println(temp.data);
            return temp.data;
         }
         temp = temp.next;
      }
      return null;
	}

	/**
	 * Find first occurrence of w (if it exists) and remove it from the list.
	 *
	 * @param w the Word to be removed
    */
	public void remove(Word w)
	{
      WordNode q;
      WordNode p = head;
      
      try
      {
         if(head.data.equals(w))
         {
            head = p.next;    //Condition for if the value is first in list
         }
      
         p = p.next;    //set the p WordNode one ahead of q
         q = head;      //set the q WordNode one behind of p
      
         while(p != null)
         {
            if(p.data.equals(w))
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
