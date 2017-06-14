// Write a program to find the node at which the intersection of two singly linked lists begins.


// For example, the following two linked lists:

// A:          a1 → a2
//                    ↘
//                      c1 → c2 → c3
//                    ↗            
// B:     b1 → b2 → b3
// begin to intersect at node c1.


// Notes:

// If the two linked lists have no intersection at all, return null.
// The linked lists must retain their original structure after the function returns.
// You may assume there are no cycles anywhere in the entire linked structure.
// Your code should preferably run in O(n) time and use only O(1) memory.

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	// Calculate the difference
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
  	if (headA == null || headB == null) return null;

    ListNode pA = headA;
    ListNode pB = headB;
    int diff = 0;

    while (pA != null && pB != null) {
    	pA = pA.next;
    	pB = pB.next;
    }

    ListNode p = pA == null ? pB : pA;

    while (p != null) {
    	p = p.next;
    	diff++;
    }

    ListNode a = headA;
    ListNode b = headB;
    if (pA == null) {
    	while (diff > 0) {
    		b = b.next;
    		diff--;
    	}
    } else {
    	while (diff > 0) {
    		a = a.next;
    		diff--;
    	}
    }

    while (a != null && b != null) {
    	if (a == b) return a;
    	a = a.next;
    	b = b.next;
    }
    return null;
  }

  // Don't calculate the difference
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
  	if (headA == null && headB == null) return null;

  	ListNode a = headA;
  	ListNode b = headB;

  	while (a != b) {
  		a = a == null ? headB : a.next;
  		b = b == null ? headA : b.next;
  	}
  	return a;
  }
}