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
    public void addRight(T item){
      if(size == storage.length){
         throw new RuntimeException("Stack Overflow.");
      }
      //if size is at capacity, we throw an exception
      if(size == 0){
        storage[0] = item;
      }
      //if size is 0, we put the element at index 0
	  else {
      	right = (right + 1) % storage.length;
        storage[right] = item;
      }
      size++;
      //


    }

    public void addLeft(T item){
      if(size == storage.length){
         throw new RuntimeException("Stack Overflow.");
       }
       if(size == 0){
         storage[0] = item;
       }
       else if(left == 0){
         left = storage.length - 1;
         storage[left] = item;
       }
       //if left is at index 0, then you put it at the end of the queue
	   else {
		 left = left - 1;
       	 storage[left] = item;
	   }
       size++;

    }
    public T removeMiddle(){
	     int indexMiddle = 0;
       if(size == 0){
         return null;
       }
      //if the list is empty, return null
       else if (size == 1){
		     T output = storage[0];
		     storage[0] = null;
         size--;
		     return output;
       }
      //if the list only has one element, return that element
      else {
        if(size%2 == 1){
          indexMiddle = size/2;
        }
        //if the list is odd-numbered, return the middle
        else {
	      int randomVal = (int) (Math.random() * 10);
          double dIndexMid = ((double) (size - 1)) / 2.0;
          if(randomVal % 2 == 0){
            indexMiddle = (int) Math.ceil(dIndexMid);
          }
          else{
            indexMiddle = (int) Math.floor(dIndexMid);
          }
        }
          //if the list is even-numbered
          //depending on whether random number is odd or even,
          //the index number will be either rounded up or down from the middle
      int trueIndex = (left + indexMiddle) % storage.length;
      T output = storage[trueIndex];
	    T[] newArray = (T[]) new Object[CAPACITY];
      for (int i = 0; i < indexMiddle; i++) {
	      int oldIndex = (left + i) % storage.length;
		    newArray[i] = storage[oldIndex];
	    }
      for (int j = indexMiddle + 1; j <= size; j++) {
		  int oldIndex = (left + j) % storage.length;
          newArray[j - 1] = storage[oldIndex];
	    }
      left = 0;
	    right = size - 1;
      storage = newArray;
      size--;

      return output;
    }

  }


    public T peekMiddle() {
      int indexMiddle = 0;
      if(size == 0){
        return null;
      }

      //if the list is empty, return null
      else if (size == 1){
        return storage[0];
      }
      //if the list only has one element, return that element
      else {
        int randomVal = (int) (Math.random() * 10);
        double dIndexMid = ((double) (size - 1)) / 2.0;
        if(randomVal % 2 == 0){
          indexMiddle = (int) Math.ceil(dIndexMid);
        }
        else {
          indexMiddle = (int) Math.floor(dIndexMid);
          //if the list is even-numbered
          //depending on whether random number is odd or even.
          //the index number will be either rounded up from the middle
          //or down
        }
    int trueIndex = (left + indexMiddle) % storage.length;
    return storage[trueIndex];
    }
}
    public boolean isEmpty(){
      return(this.size == 0);
    }
    public int getSize(){
        return this.size;
    }
    public String toString(){
      StringBuilder s = new StringBuilder();

      for(int i = 0; i < size; i++){
        int index = (left + i) % storage.length;
        s.append(storage[index]);
        s.append(" ");
      }
      return s.toString();

    }
    // Feel free to create any static methods you need or want
    // that might help you determine the middle element.
    public static void main(String[] args){
      UnfairQueueArray<String> queue = new UnfairQueueArray<>();
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
