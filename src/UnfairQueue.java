public interface UnfairQueue<T> {
  addRight(T item);
  addLeft(T item);
  T removeMiddle();
  T peekMiddle();
  boolean isEmpty();
  int getSize();
  String toString();

}
