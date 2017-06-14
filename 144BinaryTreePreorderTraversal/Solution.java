// Given a binary tree, return the preorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,2,3].

// Note: Recursive solution is trivial, could you do it iteratively?

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    Deque<TreeNode> stack = new LinkedList<>();

    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
		  if (curr != null) {
		  	list.add(curr.val);
		  	if (curr.right != null) {
		  		stack.push(curr.right);
		  	}
		  	curr = curr.left;
		  } else {
		  	curr = stack.pop();
		  }
		}

		return list;
  }
}