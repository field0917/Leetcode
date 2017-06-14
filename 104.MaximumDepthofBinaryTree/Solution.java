//Given a binary tree, find its maximum depth.

//The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.


/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
	int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Solution {
  public int maxDepth(TreeNode root) {
  	if(root == null) return 0;
  	return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
  }


	public static void main(String[] args) {
		TreeNode nodeOne = new TreeNode(1);
		TreeNode nodeTwo = new TreeNode(2);
		TreeNode nodeThree = new TreeNode(3);
		TreeNode nodeFour = new TreeNode(4);
		//TreeNode nodeFive = new TreeNode(5);
		nodeOne.left = nodeTwo;
		nodeOne.right = nodeThree;
		nodeTwo.left = nodeFour;
		//nodeTwo.right = nodeFive;

		Solution s = new Solution();
		System.out.println(s.maxDepth(nodeOne));
	}


}