// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Follow up:
// What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

// Example:

// Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 8 -> 0 -> 7


class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Deque<Integer> stack1 = new LinkedList<>();
		Deque<Integer> stack2 = new LinkedList<>();
		Deque<Integer> stack = new LinkedList<>();
		int carry = 0;

		while (l1 != null) {
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			stack2.push(l2.val);
			l2 = l2.next;
		}

		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int n1 = stack1.isEmpty() ? 0 : stack1.pop();
			int n2 = stack2.isEmpty() ? 0 : stack2.pop();
			stack.push((n1 + n2 + carry) % 10);
			carry = (n1 + n2 + carry) / 10;
		}
		if (carry != 0) stack.push(carry);

		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (!stack.isEmpty()) {
			ListNode node = new ListNode(stack.pop());
			p.next = node;
			p = p.next;
		}
		return dummy.next;
	}
}