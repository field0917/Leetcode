// Given a binary tree, return all root-to-leaf paths.

// For example, given the following binary tree:

//    1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:

// ["1->2->5", "1->3"]

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> list = new LinkedList<>();
    if(root != null) binaryTreePathsHelper(list, root, "");
    return list;
  }

  private void binaryTreePathsHelper(List<String> list, TreeNode root, String s) {
  	if(root.left == null && root.right == null) list.add(s + root.val);
  	if(root.left != null) binaryTreePathsHelper(list, root.left, s + root.val + "->");
  	if(root.right != null) binaryTreePathsHelper(list, root.right, s + root.val + "->");
  }
}