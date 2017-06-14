
class TreeNode {
	int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Solution {

// Inorder traverse
	public void inOrderTraverse(TreeNode root) {
		if(root == null) return;
		inOrderTraverse(root.left);
		System.out.println("inOrderTraverse " + root.val);
		inOrderTraverse(root.right);
	}
// Pre-order traverse
	public void preOrderTraverse(TreeNode root) {
		if(root == null) return;
		System.out.println("preOrderTraverse " + root.val);
		preOrderTraverse(root.left);
		preOrderTraverse(root.right);
	}
// Post-order traverse
	public void postOrderTraverse(TreeNode root) {
		if(root == null) return;
		postOrderTraverse(root.left);
		postOrderTraverse(root.right);
		System.out.println("postOrderTraverse " + root.val);
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
		s.preOrderTraverse(nodeOne);
		s.postOrderTraverse(nodeOne);
		s.inOrderTraverse(nodeOne);

	}


}