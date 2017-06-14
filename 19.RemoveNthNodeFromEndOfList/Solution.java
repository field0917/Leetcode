// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

//    Given linked list: 1->2->3->4->5, and n = 2.

//    After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass.

class ListNode {
 	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
  	if (head == null) return head;

  	ListNode h = new ListNode(0);
  	h.next = head;
    ListNode fast = h;
    ListNode slow = h;
    for (int i = 0; i <= n; i++) {
    	fast = fast.next;
    }
    while (fast != null) {
    	
    	slow = slow.next;
    	fast = fast.next;
    }
    slow.next = slow.next.next;
    
    return h.next;
  }

  // 2nd time by myself
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode p1 = dummy, p2 = dummy;

    for (int i = 0; i <= n; i++) {
      p2 = p2.next;
    }

    while (p2 != null) {
      p1 = p1.next;
      p2 = p2.next;
    }

    p1.next = p1.next.next;

    return dummy.next;
  }
  
}