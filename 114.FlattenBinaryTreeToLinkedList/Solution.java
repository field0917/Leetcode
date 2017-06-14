// Given a binary tree, flatten it to a linked list in-place.

// For example,
// Given

//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6
// click to show hints.

// Hints:
// If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) {val = x;}
}

public class Solution {

  // right to left, bottom to up
  public void flatten(TreeNode root) {
    flattenHelper(root, null);  
  }

  private TreeNode flattenHelper(TreeNode root, TreeNode pre) {
    if (root == null) return pre;

    pre = flattenHelper(root.right, pre);
    pre = flattenHelper(root.left, pre);
    root.right = pre;
    root.left = null;
    pre = root;
    return pre;
  }

  // preorder
  public void flatten(TreeNode root) {
    if (root == null) return;

    TreeNode left = root.left;
    TreeNode right = root.right;

    flatten(left);
    flatten(right);

    root.left = null;
    root.right = left;
    TreeNode curr = root;
    while (curr.right != null) curr = curr.right;
    curr.right = right;
  }
}