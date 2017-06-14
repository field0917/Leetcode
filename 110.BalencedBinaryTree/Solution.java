// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
  public boolean isBalanced(TreeNode root) {
    int res = height(root);
    return res != -1;
  }

  private int height(TreeNode root) {}
  	if (root == null) return 0;

  	int lh = height(root.left);
  	if(lh == -1) return -1;

  	int rh = height(root.right);
  	if(rh == -1) return -1;

  	if(Math.abs(lh - rh) > 1) return -1;

  	return Math.max(lh, rh) + 1;

  }
}