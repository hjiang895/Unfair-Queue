# Problem Set 6: Unfair Queue
## Due Friday, March 1 at 11:59pm

---

In this problem set, you will be implementing an unfair queue, much like a queue that you might encounter in your real life. Sometimes when you are waiting in line, you realize as the line moves forward that there is another line that is being merged into yours to form a single line. People who entered the other line after you entered your line might end up being served before you. Very unfair, but also very real.

### The `UnfairQueue` ADT and interface

In this `UnfairQueue` interface, elements can be added to the right side or the left side, but **they can only be removed from the middle**. The interface looks like this:

```java
public interface UnfairQueue<T> {
  addRight(T item);
  addLeft(T item);
  T removeMiddle();
  T peekMiddle();
  boolean isEmpty();
  int getSize();
}
```

### Implementing the interace

You will be implementing this interface in two ways: (1) with a doubly-linked list (`UnfairQueueLL.java`); and (2) with a fixed-size circular array (`UnfairQueueArray.java`). I have provided some starter code, and you can use the code in the `example_code` repository as a guide.

### What is "the middle" element?

When you have an odd number of elements, the middle element is unambiguous. For example, the middle element of 5 elements is the third element; if the elements are `A B C D E`, the middle element is always `C`. 

If you have an even number of elements, you can decide whether to "round up" or "round down" to identify the mdidle element. If the elements are `A B C D E F`, either `C` or `D` could be the middle element. To make this ADT more like real life,  you will decide using a random number which of the two middle elements will be the one that gets removed. (Please review the code for Problem Set 3 to remind yourself how to generate and use a random number!)

### How do I find the middle element using math?

If you divide an `int` by another `int` in Java, you do something called "integer division". This is equivalent to taking off everything that appears after the decimal point. (This is also called finding the "floor".) Integer division in Java does not round to the nearest integer! 

Therefore, if you want to find the middle element, you can't always just divide the `int size` by an `int 2`. To figure out how to get the middle you want, you can experiment with using the `Math.floor()` and `Math.ceil()` methods in conjunction with casting to `double`. You can also experiment with adding 1 or 2 to the size before doing the integer division. It's up to you to find the solution you like best. I suggest googling and trying out different ideas in Java and on paper.

### Removing the middle element: linked list
You will need to traverse to the middle from one end of the unfair queue to remove the middle node. You might even want to have two pointers for traversing, though it's not strictly necessary. You should try to traverse as few nodes as possible, so which end you traverse from can change depending on which node you decide is the middle node.

### Removing the middle element: circular array
Removing from the middle will require some very fancy stuff in the array implementation! This will probably be the hardest part for many of you. You will have to figure out a clever way to find the middle when your tail or front has wrapped around. In addition, you will need shift some elements over when you remove an element in the middle. This will involve some thinking, so draw lots of pictures before you get started on the `removeMiddle()` method.

### Don't forget the special cases
If your queue is empty, remember that `removeMiddle()` and `peekMiddle()` should either throw an exception or return null. If your queue has one element, `removeMiddle` and `peekMiddle` should return that one element, of course. There are other special cases, so think about these carefully!

### Testing your code `main()`

Write code in the main() method to test your implementation. The TAs will be writing their own main methods to test your code, so test your code thoroughly!

---

## Pushing and verifying your submission

Once your code works to your satisfaction, push `UnfairQueueArray.java` and `UnfairQueueLL.java` to your personal master repo on the GitHub Classroom site, as you have done for your previous problem sets. Use the commit message "READY FOR GRADING" so we know you are done. 

---

## Important notes on grading

1. The files **must be in the `src` directory**. You will lose 2 points for each file that is in the wrong directory. The best way to make sure the files are in the right place is to never ever move them in the first place.

2. Your code must compile. If a class does not compile, you will get a 0. If you are struggling and you aren't able to get in touch with me or the TAs, any TAs in the lab can help you compile your code. If it's 11:55pm on the day it's due and you don't want to take the late penalty, comment out the part of the code that is preventing compilation, and include an explanation of why you are commenting it out.

3. The TAs will review and run your code. Note that in addition to running your `main()` method, they will try out one of their own. It's a good idea to do some error checking to avoid any surprises during grading.
