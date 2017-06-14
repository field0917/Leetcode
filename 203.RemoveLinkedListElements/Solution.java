// Remove all elements from a linked list of integers that have value val.

// Example
// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
// Return: 1 --> 2 --> 3 --> 4 --> 5

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null) return head;

    ListNode dummyHead = new ListNode(0);
    dummyHead.next = head;
    ListNode prev = dummyHead;
    ListNode curr = head;

    while (curr != null) {
    	if (curr.val == val) prev.next = curr.next;
    	else prev = curr;
    		
    	curr = curr.next;
    }
    return dummyHead.next;
  }
}