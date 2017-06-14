// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.
// Example:
// MinStack minStack = new MinStack();
// minStack.push(-2);
// minStack.push(0);
// minStack.push(-3);
// minStack.getMin();   --> Returns -3.
// minStack.pop();
// minStack.top();      --> Returns 0.
// minStack.getMin();   --> Returns -2.
import java.util.*;

// Use one stack and one priorityQ
public class MinStack {
	PriorityQueue<Integer> queue;
	Deque<Integer> stack;

  /** initialize your data structure here. */
  public MinStack() {
    queue = new PriorityQueue();
    stack = new LinkedList<Integer>();
  }
  
  public void push(int x) {
    queue.offer(x);
    stack.push(x);
  }
  
  public void pop() {
    int x = stack.peek();
    stack.pop();
    queue.remove(x);
  }
  
  public int top() {
    return stack.peek();
  }
  
  public int getMin() {
    return queue.peek();
  }

}

// Use one stack
public class MinStack {
  int min = Integer.MAX_VALUE;
  Deque<Integer> stack;

  /** initialize your data structure here. */
  public MinStack() {
    stack = new LinkedList<>();
  }
  
  public void push(int x) {
    if (x <= min) {
      stack.push(min);
      min = x;
    }
    stack.push(x);
  }
  
  public void pop() {
    if (stack.pop() == min) min = stack.pop();
  }
  
  public int top() {
    return stack.peek();
  }
  
  public int getMin() {
    return min;
  }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */