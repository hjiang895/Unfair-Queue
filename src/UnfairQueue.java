public interface UnfairQueue<T> {
  void addRight(T item);
  void addLeft(T item);
  T removeMiddle();
  T peekMiddle();
  boolean isEmpty();
  int getSize();
  String toString();

}
