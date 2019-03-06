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

  public UnfairQueueLL() {
    left = new Node();
    right = new Node();
    left.next = right;
    right.prev = left;
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

  public void addRight(T item){
    Node newRight = new Node();
    newRight.data = item;
    if (right.data == null) {
      left.next = newRight;
      newRight.prev = left;
    }
    else {
      right.next = newRight;
      newRight.prev = right;
    }
    right = newRight;
    size++;
  }

  public void addLeft(T item) {
    Node newLeft = new Node();
    newLeft.data = item;
    if (left.data == null) {
      right.prev = newLeft;
      newLeft.next = right;
    }
    else {
      left.prev = newLeft;
      newLeft.next = left;
    }
    left = newLeft;
    size++;

  }

  public T removeMiddle(){
    int indexMiddle = 0;
    if(size == 0){
      return null;
    }
    //if the list is empty, return null
    else if (size == 1){
      T output = left.data;
      left = null;
      size--;
      return output;
    }
    //if the list only has one element, return that element
    else {
      int randomVal = (int) (Math.random() * 10);
      double dIndexMid = ((double) (size - 1)) / 2.0;
      if(randomVal % 2 == 0) {
        indexMiddle = (int) Math.ceil(dIndexMid);
      }
      else{
        indexMiddle = (int) Math.floor(dIndexMid);
        //if the list is even-numbered
        //depending on whether random number is odd or even.
        //the index number will be either rounded up from the middle
        //or down
      }
      Node p = left;
      for(int i = 0; i < indexMiddle - 1; i++){
        p = p.next;
      }
      size--;
      T output = p.next.data;
      p.next = p.next.next;
      p.next.next.prev = p;
      return output;
    }
  }

  public T peekMiddle(){
    int indexMiddle = 0;
    if(size == 0){
      return null;
    }
    //if the list is empty, return null
    else if (size == 1){
      return left.data;
    }
    //if the list only has one element, return that element
    else {
      int randomVal = (int) (Math.random() * 10);
      double dIndexMid = ((double) (size - 1)) / 2.0;
      if(randomVal % 2 == 0) {
        indexMiddle = (int) Math.ceil(dIndexMid);
      }
      else{
        indexMiddle = (int) Math.floor(dIndexMid);
        //if the list is even-numbered
        //depending on whether random number is odd or even.
        //the index number will be either rounded up from the middle
        //or down
      }
      Node p = left;
      for(int i = 0; i < indexMiddle; i++){
        p = p.next;
      }
      T output = p.data;
      return output;
    }
  }

  public boolean isEmpty() {
    return(this.size == 0);
  }

  public int getSize(){
    return this.size;
  }
  public String toString(){
    StringBuilder s = new StringBuilder();
    Node p = left;
    while(p != null){
      s.append(p.data);
      s.append(" ");
      p = p.next;
    }
    return s.toString();

  }

  // Feel free to create any static methods you need or want
  // that might help you determine the middle element.
  public static void main(String[] args){
    UnfairQueueLL<String> queue = new UnfairQueueLL<>();
    queue.addRight("Maxime");
    queue.addLeft("Bunnies");
    queue.addRight("Poops");
    queue.addLeft("Boston");
    queue.addRight("College");
    queue.addLeft("Suck");
    System.out.println(queue.isEmpty());
    System.out.println(queue.getSize());
    System.out.println(queue.toString());
    System.out.println(queue.peekMiddle());
    System.out.println(queue.removeMiddle());
    System.out.println(queue.toString());
  }

}
