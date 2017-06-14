// Implement the following operations of a queue using stacks.

// push(x) -- Push element x to the back of queue.
// pop() -- Removes the element from in front of queue.
// peek() -- Get the front element.
// empty() -- Return whether the queue is empty.
// Notes:
// You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
// You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

class MyQueue {
	Deque<Integer> s1 = new LinkedList<>();
	Deque<Integer> s2 = new LinkedList<>();

  // Push element x to the back of queue.
  public void push(int x) {
		while (!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		s1.push(x);
  }

  // Removes the element from in front of queue.
  public void pop() {
  	while(!s1.isEmpty()) {
  		s2.push(s1.pop());
  	}
  	s2.pop();
  }

  // Get the front element.
  public int peek() {
  	while(!s1.isEmpty()) {
  		s2.push(s1.pop());
  	}
  	return s2.peek();
  }

  // Return whether the queue is empty.
  public boolean empty() {
  	 return s1.isEmpty() && s2.isEmpty();
  }
}