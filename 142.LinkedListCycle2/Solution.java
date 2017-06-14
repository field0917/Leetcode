// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Note: Do not modify the linked list.

// Follow up:
// Can you solve it without using extra space?

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
  public ListNode detectCycle(ListNode head) {
  	//if (head == null) return head;

    ListNode walk = head;
    ListNode run = head;

   	while (run != null && run.next != null) {
 			walk = walk.next;
 			run = run.next.next;
 			if (walk == run) {
 				ListNode walk2 = head;
 				while (walk2 != walk) {
 					walk2 = walk2.next;
 					walk = walk.next;
 				}
 				return walk;
 			}		
   	}
   	return null;

  }
}