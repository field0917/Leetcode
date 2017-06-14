// Find the sum of all left leaves in a given binary tree.

// Example:

//     3
//    / \
//   9   20
//  /   /  \
// 1   15   7

// There are two left leaves in the binary tree, with values 1 and 15 respectively. Return 16.
import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	// Iteration
  public int sumOfLeftLeaves(TreeNode root) {
  	if (root == null) return 0;

    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int sumLeft = 0;

    while (!queue.isEmpty()) {
    	TreeNode node = queue.poll();
    	if (node.left != null) {
    		if (node.left.left == null && node.left.right == null)
    			sumLeft += node.left.val;
    		else
    			queue.offer(node.left);
    	}
    	if (node.right != null) {
    		queue.offer(node.right);
    	}
    }
    return sumLeft;
  }

  // Recursion
  public int sumOfLeftLeaves(TreeNode root) {
  	if (root == null) return 0;
  	int sumLeft = 0;

  	if (root.left != null) {
  		if (root.left.left == null && root.left.right == null) sumLeft += root.left.val;
  		else sumLeft += sumOfLeftLeaves(root.left);
  	}
  	sumLeft += sumOfLeftLeaves(root.right);
  }


}