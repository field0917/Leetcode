// Reverse a singly linked list.

// Hint:
// A linked list can be reversed either iteratively or recursively. Could you implement both?

class ListNode {
  int val;
  ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    ListNode p = head;
    ListNode next = null;

    while(p != null) {
    	next = p.next;
    	p.next = prev;
    	prev = p;
    	p = next;
    }
    return prev;
  }
}