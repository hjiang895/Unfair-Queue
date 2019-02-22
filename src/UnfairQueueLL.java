public class UnfairQueueLL<T> implements UnfairQueue<T>{

  // instance variables
  // Remember: we have a pointer to left and right!
  Node left;
  Node right;
  int size;

  // Node inner class
  // Remember: this is a doubly linked list!
  class Node {
    T data;
    Node prev;
    Node next;
  }

  /* Interface methods to implement
  addRight(T item);
  addLeft(T item);
  T removeMiddle();
  T peekMiddle();
  boolean isEmpty();
  int getSize();
  String toString();
  */

  // Feel free to create any static methods you need or want
  // that might help you determine the middle element.

}
