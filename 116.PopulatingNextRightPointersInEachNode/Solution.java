// Given a binary tree

//     struct TreeLinkNode {
//       TreeLinkNode *left;
//       TreeLinkNode *right;
//       TreeLinkNode *next;
//     }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

// Note:

// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
// For example,
// Given the following perfect binary tree,
//          1
//        /  \
//       2    3
//      / \  / \
//     4  5  6  7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \  / \
//     4->5->6->7 -> NULL

class TreeLinkNode {
  int val;
  TreeLinkNode left, right, next;
  TreeLinkNode(int x) { val = x; }
}

public class Solution {

  // O(logn) extra space
  public void connect(TreeLinkNode root) {
    if (root == null) return;

    int level = 0;
    Deque<TreeLinkNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {
       
      for (int i = 0; i < Math.pow(2, level) - 1; i++) {
        TreeLinkNode node = queue.poll();
        node.next = queue.peek();
        if (node.left != null && node.right != null) {
          queue.offer(node.left);
          queue.offer(node.right);
        }
      }
      TreeLinkNode node = queue.poll();
      if (node.left != null && node.right != null) {
          queue.offer(node.left);
          queue.offer(node.right);
      }
      level++;
    }

  }

  // O(1) constant extra space
  public void connect(TreeLinkNode root) {
    TreeLinkNode level_start = root;

    while (level_start != null) {
      TreeLinkNode cur = level_start;

      while (cur != null) {
        if (cur.left != null) cur.left.next = cur.right;
        if (cur.right != null && cur.next != null) cur.right.next = cur.next.left;
        cur = cur.next;
      }

      level_start = level_start.left;
    }
  }
}