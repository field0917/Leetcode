// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left != null && root.right != null)
    	return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    if (root.left == null)
    	return minDepth(root.right) + 1;
    return minDepth(root.left) + 1;
  }
}