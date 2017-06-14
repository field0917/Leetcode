// Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

// An example is the root-to-leaf path 1->2->3 which represents the number 123.

// Find the total sum of all root-to-leaf numbers.

// For example,

//     1
//    / \
//   2   3
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.

// Return the sum = 12 + 13 = 25.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
  public int sumNumbers(TreeNode root) {
  	
    return sumNumbersHelper(root, 0, 0);
  }

  private int sumNumbersHelper(TreeNode root, int sum, int num) {
  	if (root == null) return sum;
  	if (root.left == null && root.right == null) {
  		num = num * 10 + root.val;
  		sum += num;
  		return sum;
  	}
  	num = num * 10 + root.val;
  	// sum = sumNumbersHelper(root.left, sum, num);
  	// sum = sumNumbersHelper(root.right, sum, num);
  	// return sum;
  	return sumNumbersHelper(root.left, sum, num) + sumNumbersHelper(root.right, sum, num);
  }
}