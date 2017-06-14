// Given a binary tree, find the leftmost value in the last row of the tree.

// Example 1:
// Input:

//     2
//    / \
//   1   3

// Output:
// 1
// Example 2: 
// Input:

//         1
//        / \
//       2   3
//      /   / \
//     4   5   6
//        /
//       7

// Output:
// 7
// Note: You may assume the tree (i.e., the given root node) is not NULL.

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

// recursion
public class Solution {
  int mostLeft = 0;
  int maxLevel = -1; // when only have one node, level and maxlevel are both 0, you wont get teh mostLeft value
  public int findBottomLeftValue(TreeNode root) {
    
    postOrder(root, 0);
    return mostLeft;
  }

  private void postOrder(TreeNode root, int level) {
    if (root == null) return;
    if (root.left == null && root.right == null) {
      if (level > maxLevel) {
        maxLevel = level;
        mostLeft = root.val;
      }
      //return;
    }

    postOrder(root.left, level + 1);

    postOrder(root.right, level + 1);
  }
}

// traversal
public class Solution {
  public int findBottomLeftValue(TreeNode root) {
    Deque<TreeNode> queue = new LinkedList<>();
    int res = 0;
    queue.offer(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Treenode node = queue.poll();
        if (i == 0) res = node.val;
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      }
    }
    return res;
  }

  // smarter solution
  public int findBottomLeftValue(TreeNode root) {
    Deque<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while(!queue.isEmpty()) {
      root = queue.poll();
      if (root.right != null) queue.offer(root.right);
      if (root.left != null) queue.offer(root.left);
    }
    return root.val;
  }
}