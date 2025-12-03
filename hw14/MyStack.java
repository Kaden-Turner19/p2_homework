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
   public void push(String val) {
      StackNode p = new StackNode();
      p.data = val;
      p.next = top;
      top = p;
   }
   
  /**
   * Removes the head of the list
   */
   public String pop() {
      StackNode p = top;
      top = top.next;
      return p.data;
   }
  /**
   * Checks to see if the list is empty
   *
   * @return boolean value, true if the stack is empty, false if the stack is not
   */
   public boolean isEmpty() {
      return top == null;
   }
  /**
   * Checks a string to see if there are properly matched ()'s
   *
   * @param check String value thats being checked
   * @return boolean value, true for correct use, false for incorrect use.
   */
   public boolean checkParens(String check) {
      
      MyStack stack = new MyStack();      //initialize new stack to store String values
         
      for(int i = 0;i<check.length();i++) {           //loop through the check parameter
      
         if(check.substring(i,i+1).equals("(")) {     //check substring, if it equals an open then we push to the stack
            stack.push("(");
         }
         
         else if(check.substring(i,i+1).equals(")")) {      //if it equals a close then we pop unless stack is empty
            if(stack.isEmpty()) {
               return false;
            }
            else {
               stack.pop();
            }
         }
      }
      
      if(!stack.isEmpty()) {     //if stack is not empty than there is a missing close
         return false;
      }
      else {
         return true;            //if the stack is empty than there's a correct number of parenthesis's
      }
   }
}