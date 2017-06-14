// Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

// Example:

// Input:

//    1
//     \
//      3
//     /
//    2

// Output:
// 1

// Explanation:
// The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
// Note: There are at least two nodes in this BST.

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
  // public int getMinimumDifference(TreeNode root) {
  //   List<Integer> list = new LinkedList<>();
  //   int diff = Integer.MAX_VALUE;

  //   helper(root, list);

  //   for (int i = 0; i < list.size() - 1; i++) {
  //   	diff = Math.min(diff, list.get(i + 1) - list.get(i));
  //   }
  //   return diff;
  // }
  // private void helper(TreeNode root, List<Integer> list) {
  // 	if (root == null) return;
  // 	helper(root.left, list);
  // 	list.add(root.val);
  // 	helper(root.right, list);
  // }

	int min = Integer.MAX_VALUE;
	Integer prev = null;

  public int getMinimumDifference(TreeNode root) {
  	if (root == null) return min;

  	getMinimumDifference(root.left);

  	if (prev != null) {
  		min = Math.min(min, root.val - prev);
  	}

  	prev = root.val;

  	getMinimumDifference(root.right);

  	return min;
  }
}