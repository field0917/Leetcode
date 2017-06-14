// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
import java.util.Deque;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	// Iteration BFS
  // public List<List<Integer>> levelOrder(TreeNode root) {
  //   List<List<Integer>> wrappedList = new LinkedList<>();
  //   Deque<TreeNode> queue = new LinkedList<>();
  //   TreeNode node;

  //   if(root == null) return wrappedList;
  //   queue.offer(root);

  //   while(!queue.isEmpty()) {
  //   	List<Integer> sublist = new LinkedList<>();
  //   	int size = queue.size();
  //   	for(int i = 0; i < size; i++) {
  //   		node = queue.poll();
  //   		if(node.left != null) queue.offer(node.left);
  //   		if(node.right != null) queue.offer(node.right);
  //   		sublist.add(node.val);
  //   	}
  //   	wrappedList.add(sublist);
  //   }
  //   return wrappedList;
  // }

  // Recursion DFS
  public List<List<Integer>> levelOrder(TreeNode root) {
  	List<List<Integer>> wrappedList = new LinkedList<>();
  	levelOrderHelper(wrappedList, root, 0);
  	return wrappedList;
  }

  private void levelOrderHelper(List<List<Integer>> list, TreeNode root, int level) {
  	if(root == null) return;
  	if(level >= list.size()) list.add(new LinkedList<Integer>());
  	list.get(level).add(root.val);
  	levelOrderHelper(list, root.left, level + 1);
  	levelOrderHelper(list, root.right, level + 1);
  }

  // 2nd time doing it
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> list = new LinkedList<>();
    helper(list, root, 0);
    return list;

  }
  private void helper(List<List<Integer>> list, List<Integer>sublist, TreeNode root, int level) {
    if (root == null) return;
    if (list.size() < level) {
      list.add(new LinkedList<>());

    }
    list.get(level).add(root);
    helper(list, root.left, level + 1);
    helper(list, root.right, level + 1);
  }
}