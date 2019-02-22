public class UnfairQueueArray<T> implements UnfairQueue<T> {

    // static variables
    // Here we're saying the maximum size of the unfair queue is 10.
    int CAPACITY = 10;

    // instance variables
    T[] storage;    // you need an array to store the unfair queue
    int left;       // index of the left end of the unfair queue
    int right;      // index of the right end of the unfair queue
    int size;       // size of the unfair queue

    // constructor
    public UnfairQueueArray () {
      // You want to create an array, but you aren't allowed to
      // create an array of a generic type, so this is a way around that.
      // Create an array of Objects that you then cast to type T
      @SuppressWarnings("unchecked")
      T[] temp = (T[]) new Object[CAPACITY];
      this.storage = temp;
      this.size = 0;
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
