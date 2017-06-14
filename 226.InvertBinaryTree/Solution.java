// Invert a binary tree.

//      4
//    /   \
//   2     7
//  / \   / \
// 1   3 6   9
// to
//      4
//    /   \
//   7     2
//  / \   / \
// 9   6 3   1
import java.util.LinkedList;
import java.util.Deque;

class TreeNode {
	int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Solution {
// Recursive
  // public TreeNode invertTree(TreeNode root) {
  // 	if(root == null) return null;
  // 	TreeNode left = root.left;
  // 	TreeNode right = root.right;
  
  // 	root.right = invertTree(left);
  // 	root.left = invertTree(right);
  // 	return root;
  // }

// Iteration
  public TreeNode invertTree(TreeNode root) {
  	if(root == null) return null;
  	Deque<TreeNode> stack = new LinkedList<>();
  	stack.push(root);

  	while(!stack.isEmpty()) {
  		TreeNode node = stack.pop();
  		TreeNode left = node.left;
  		node.left = node.right;
  		node.right = left;
  		if(node.left != null) stack.push(node.left);
  		if(node.right != null) stack.push(node.right);
  	}
  	return root;
  }

  public static void main(String[] args) {
		TreeNode nodeOne = new TreeNode(1);
		TreeNode nodeTwo = new TreeNode(2);
		TreeNode nodeThree = new TreeNode(3);
		TreeNode nodeFour = new TreeNode(4);
		TreeNode nodeFive = new TreeNode(5);
		nodeOne.left = nodeTwo;
		nodeOne.right = nodeThree;
		nodeTwo.left = nodeFour;
		nodeTwo.right = nodeFive;

		Solution s = new Solution();

		System.out.println(s.invertTree(nodeOne));
	}
}