// Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

// You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

// Example:
// Given 1->2->3->4->5->NULL,
// return 1->3->5->2->4->NULL.

// Note:
// The relative order inside both the even and odd groups should remain as it was in the input. 
// The first node is considered odd, the second node even and so on ...

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
  public ListNode oddEvenList(ListNode head) {
  	if (head == null) return head;

    ListNode pre = new ListNode(0);
    pre.next = head;
    ListNode h2 = head.next;
    ListNode p1 = head, p2 = head.next;

    while (p1 != null && p2 != null) {
    	p1.next = p2.next;
    	pre = p1;
    	p1 = p1.next;
    	if (p1 != null) {
    		p2.next = p1.next;
    		p2 = p2.next;
    	}
    }
    if (p1 != null) p1.next = h2;
    else pre.next = h2;

    return head;
  }

// Nice and clean!
  public ListNode oddEvenList(ListNode head) {
    if (head != null) {
    
        ListNode odd = head, even = head.next, evenHead = even; 
    
        while (even != null && even.next != null) {
            odd.next = odd.next.next; 
            even.next = even.next.next; 
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead; 
    }
    return head;
}
}