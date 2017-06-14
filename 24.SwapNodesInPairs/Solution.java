// Given a linked list, swap every two adjacent nodes and return its head.

// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    dummy.next = head;
    ListNode first;
    ListNode second;

    while(curr.next != null && curr.next.next != null) {
    	first = curr.next;
    	second = curr.next.next;

    	first.next = second.next;
    	second.next = first;
    	curr.next = second;

    	curr = curr.next.next;
    }
    return dummy.next;
  }
  // 2nd time doing it by myself!!!
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;
    prev.next = head;
    ListNode p = head;

    while (p != null && p.next != null) {
        prev.next = p.next;
        p.next = p.next.next;
        prev.next.next = p;

        prev = p;
        p = p.next;
    }
    return dummy.next;
  }
}