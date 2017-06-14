// Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

// Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.

class ListNode {
 	int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

public class Solution {
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	public static void main(String[] args) {
		ListNode nodeOne = new ListNode(1);
		ListNode nodeTwo = new ListNode(2);
		ListNode nodeThree = new ListNode(3);
		ListNode nodeFour = new ListNode(4);
		nodeOne.next = nodeTwo;
		nodeTwo.next = nodeThree;
		nodeThree.next = nodeFour;

		Solution s = new Solution();

		s.deleteNode(nodeThree);
		System.out.println(nodeTwo.next.val);
	}
}