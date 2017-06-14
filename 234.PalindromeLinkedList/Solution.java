// Given a singly linked list, determine if it is a palindrome.

// Follow up:
// Could you do it in O(n) time and O(1) space?
import java.util.*;

class ListNode {
	int val;
 	ListNode next;
 	ListNode(int x) { val = x; }
}

public class Solution {
	// O(n) space O(n) time
  // public boolean isPalindrome(ListNode head) {
  // 	if (head == null) return true;

  // 	List<Integer> al = new ArrayList<>();
  // 	ListNode p = head;

  // 	while (p != null) {
  // 		al.add(p.val);
  // 		p = p.next;
  // 	}

  // 	int forthIdx = 0;
  // 	int backIdx = al.size() - 1;

  // 	while (forthIdx < backIdx) {
  // 		if (al.get(forthIdx) != al.get(backIdx)) {
  // 			return false;
  // 		} else {
  // 			forthIdx++;
  // 			backIdx--;
  // 		}
  // 	}
  // 	return true;
  // }

	// O(1) space O(n) time
  public boolean isPalindrome(ListNode head) {
  	if (head == null) return true;
  	ListNode slow = head, fast = head;
  	while (fast != null && fast.next != null) {
  		slow = slow.next;
  		fast = fast.next.next;
  	}
  	slow = fast == null ? slow : slow.next;
  	ListNode second = reverse(slow);

  	while (second != null) {
  		if (head.val != second.val) return false;
  		else {
  			head = head.next;
  			second = second.next;
  		}
  	}
  	return true;
  }

  private ListNode reverse(ListNode head) {
  	ListNode prev = null, cur = head;
  	while (cur != null) {
  		ListNode next = cur.next;
  		cur.next = prev;
  		prev = cur;
  		cur = next;
  	}
  	return prev;
  }

  public static void main(String[] args) {
  	ListNode head = new ListNode(0);
  	ListNode n1 = new ListNode(1);
  	ListNode n2 = new ListNode(1);
  	ListNode n3 = new ListNode(0);
  	head.next = n1;
  	n1.next = n2;
  	n2.next = n3;
  	boolean result = new Solution().isPalindrome(head);
  	System.out.println(result);
  }

}

