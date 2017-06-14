// Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

// Example:

// Input: The root of a Binary Search Tree like this:
//               5
//             /   \
//            2     13

// Output: The root of a Greater Tree like this:
//              18
//             /   \
//           20     13


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	int valSum = 0;
  public TreeNode convertBST(TreeNode root) {
  	helper(root);
    return root;
  }

  private void helper(TreeNode root) {
  	if (root == null) return;

  	helper(root.right);
  	root.val += valSum;
  	valSum = root.val;
  	helper(root.left);
  }
}