// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	// Recursion
  // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
  // 	if(l1 == null) return l2;
  // 	if(l2 == null) return l1;

  //   if(l1.val < l2.val) {
  //   	l1.next = mergeTwoLists(l1.next, l2);
  //   	return l1;
  //   } else {
  //   	l2.next = mergeTwoLists(l1, l2.next);
  //   	return l2;
  //   }
  // }

  // Iteration
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
  	if(l1 == null) return l2;
  	if(l2 == null) return l1;

  	ListNode res = new ListNode(0);
  	ListNode p = res;

  	while(l1 != null && l2 != null) {
  		if(l1.val <= l2.val) {
  			p.next = l1;
  			l1 = l1.next;
  		}
  		else {
  			p.next = l2;
  			l2 = l2.next;
  		}
  		p = p.next;
  	}

  	if(l1 == null) p.next = l2;
  	if(l2 == null) p.next = l1;
  	return res.next;
  }
}

