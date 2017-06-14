// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

// Hint:

// Try to utilize the property of a BST.
// What if you could modify the BST node's structure?
// The optimal runtime complexity is O(height of BST).

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	// O(k) Priority Queue
  public int kthSmallest(TreeNode root, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(10, Collections.reverseOrder());
    traverse(root, pq, k);
    return pq.poll();
  }
  private void traverse(TreeNode root, PriorityQueue<Integer> pq, int k) {
  	if (root == null) return;
  	traverse(root.left, pq, k);
  	pq.offer(root.val);
  	if (pq.size() > k) pq.poll();
  	traverse(root.right, pq, k);
  }

  // O(k) Recursive
  private static int res = 0;
  private static int count = 0;
  public int kthSmallest(TreeNode root, int k) {
  	count = k;
  	traverse(root);
  	return res;
  }
  private void traverse(TreeNode root) {
  	// if (root.left != null) traverse(root.left);
  	// count--;
  	// if (count == 0) {
  	// 	res = root.val;
  	// 	return;
  	// }
  	// if (root.right != null) traverse(root.right); // void method will return automaticlly
  	if (root == null) return;
  	traverse(root.left);
  	count--;
  	if (count == 0) {
  		res = root.val;
  		return;
  	}
  	traverse(root.right);
  }


  // O(K) Iterative
  public int kthSmallest(TreeNode root, int k) {
  	Deque<TreeNode> stack = new LinkedList<>();

  	int count = 0;
  	TreeNode node = root;
  	int res = 0;

  	while (node != null || !stack.isEmpty()) {
  		while (node != null) {
  			stack.push(node);
  			node = node.left;
  		}
  		node = stack.pop();
  		count++;
  		if (count == k) return node.val;
  		node = node.right;
  	}

  	return -1;
  }

  // 
  public int kthSmallest(TreeNode root, int k) {
  	int count = countNode(root.left);
  	if (k <= count) {
  		return kthSmallest(root.left, k);
  	} else if (k > count + 1) {
  		return kthSmallest(root.right, k - count - 1);
  	}
  	return root.val; // k == count + 1, root is the kth smallest element
  }
  public int countNode(TreeNode root) {
  	if (root == null) return 0;
  	return 1 + countNode(root.left) + countNode(root.right);
  }


}