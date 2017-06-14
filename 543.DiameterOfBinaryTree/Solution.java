// Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

// Example:
// Given a binary tree 
//           1
//          / \
//         2   3
//        / \     
//       4   5    
// Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

// Note: The length of path between two nodes is represented by the number of edges between them.



class TreeNode {
	nt val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
  public int diameterOfBinaryTree(TreeNode root) {
  	if (root == null) return 0;
  	int rootlen = maxDepth(root.left) + maxDepth(root.right);
  	int leftlen = diameterOfBinaryTree(root.left);
  	int rightlen = diameterOfBinaryTree(root.right);
    return Math.max(Math.max(rootlen, leftlen) , rightlen);
  }

  private int maxDepth(TreeNode root) {
  	if (root == null) return 0;

  	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}