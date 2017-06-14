// Implement the following operations of a stack using queues.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// empty() -- Return whether the stack is empty.
// Notes:
// You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
// Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
// You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
// Update (2015-06-11):
// The class name of the Java function had been updated to MyStack instead of Stack.

// Two queues:

// class MyStack {
// 	Deque<Integer> queue1 = new LinkedList<>();
// 	Deque<Integer> queue2 = new LinkedList<>();

//   // Push element x onto stack.
//   public void push(int x) {
//     if (!queue2.isEmpty()) queue2.offer(x);
//     else queue1.offer(x);
//   }

//   // Removes the element on top of the stack.
//   public void pop() {
//   	if (!queue1.isEmpty()) {
//   		while (queue1.size() > 1) queue2.offer(queue1.poll());
//     	queue1.poll();
//   	} else {
//   		while (queue2.size() > 1) queue1.offer(queue2.poll());
//   		queue2.poll();
//   	} 
//   }

//   // Get the top element.
//   public int top() {
//   	int top = 0;
//     if (!queue1.isEmpty()) {
//   		while (queue1.size() > 1) queue2.offer(queue1.poll());
//     	top = queue1.poll();
//     	queue2.offer(top);
//   	} else {
//   		while (queue2.size() > 1) queue1.offer(queue2.poll());
//   		top = queue2.poll();
//   		queue1.offer(top);
//   	}
//   	return top;
//   }

//   // Return whether the stack is empty.
//   public boolean empty() {
//     return queue1.isEmpty() && queue2.isEmpty();
//   }
// }

// One queue roll over:
class MyStack {
	Queue<Integer> queue = new LinkedList<>();

  // Push element x onto stack.
  public void push(int x) {
    queue.offer(x);
    for (int i = 1; i < queue.size(); i++) {
    	queue.offer(queue.poll());
    }
  }

  // Removes the element on top of the stack.
  public void pop() {
  	queue.poll();
  }

  // Get the top element.
  public int top() {
    return queue.peek();
  }

  // Return whether the stack is empty.
  public boolean empty() {
    return queue.isEmpty();
  }
}