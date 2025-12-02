/**
 * Linked List using the StackNode class.
 *
 * @author  Kaden Turner
 * @version 11/5/2025
 *
 */

public class MyStack {
   private StackNode top;
   
  /**
   * Constructor that sets top null
   */
   public MyStack() {
      top = null;
   }
   
  /**
   * Instantiates a StackNode and inserts it at the beginning with val set to data.
   *
   * @param val value to give to the new node in the linked list
   */
   public void push(int val) {
      StackNode p = new StackNode();
      p.data = val;
      p.next = top;
      top = p;
   }
   
  /**
   * Removes the head of the list
   */
   public int pop() {
      StackNode p = top;
      top = top.next;
      return p.data;
   }
  /**
   * Checks to see if the list is empty
   */
   public boolean isEmpty() {
      return top == null;
   }
}