// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following [1,2,2,null,3,null,3] is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.
import java.util.Deque;

class TreeNode {
	int val;
	TreeNode left;
 	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	// Recursion
  // public boolean isSymmetric(TreeNode root) {
  //   return root == null || isSymmetricHelp(root.left, root.right);
  // }

  // private boolean isSymmetricHelp(TreeNode left, TreeNode right) {
  // 	if(left == null || right == null) return left == right;
  // 	if(left.val != right.val) return false;
  // 	return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);
  // }

  // Iteration
  public boolean isSymmetric(TreeNode root) {
  	if(root == null) return true;

  	Deque<TreeNode> stack = new LinkedList<>();
  	TreeNode left;
  	TreeNode right;

  	if(root.left != null) {
  		if(root.right == null) return false;
  		stack.push(root.left);
  		stack.push(root.right);
  	} else {
  		if(root.right != null) return false;
  	}

  	while(!stack.isEmpty()) {
  		right = stack.pop();
  		left = stack.pop();

  		if(left.val != right.val) return false;

  		if(left.left != null) {
  			stack.push(left.left);
  			if(right.right == null) return false;
  			else stack.push(right.right);
  		} else {
  			if(right.right != null) return false;
  		}

  		if(right.left != null) {
  			stack.push(right.left);
  			if(left.right == null) return false;
  			else stack.push(left.right);
  		} else {
  			if(left.right != null) return false;
  		}
  	}
  	return true;
  }

}