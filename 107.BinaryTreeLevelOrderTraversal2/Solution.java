// Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//  /  /  \
// 8  15   7
// return its bottom-up level order traversal as:
// [
//   [8,15,7],
//   [9,20],
//   [3]
// ]
import java.util.Queue;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	// BFS
  // public List<List<Integer>> levelOrderBottom(TreeNode root) {
  //   Queue<TreeNode> queue = new LinkedList<>();
  //   List<List<Integer>> wrappedList = new LinkedList<>();

  //   if(root == null) return wrappedList;

  //   queue.offer(root);
  //   while(!queue.isEmpty()) {
  //   	List<Integer> sublist = new LinkedList<>();
  //   	int level = queue.size();
  //   	for(int i = 0; i < level; i++) {
  //   		if(queue.peek().left != null) queue.offer(queue.peek().left);
  //   		if(queue.peek().right != null) queue.offer(queue.peek().right);
  //   		sublist.add(queue.poll().val);
  //   	}
  //   	wrappedList.add(0, sublist);
  //   }
  //   return wrappedList;
  // }

  // DFS
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
  	List<List<Integer>> wrappedList = new LinkedList<>();
  	levelMaker(wrappedList, root, 0);
  	return wrappedList;
  }

  private void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
  	if(root == null) return;
  	if(level >= list.size()) {
  		list.add(0, new LinkedList<Integer>());
  	}
  	levelMaker(list, root.left, level + 1);
  	levelMaker(list, root.right, level + 1);
  	list.get(list.size() - level - 1).add(root.val);
  }
}