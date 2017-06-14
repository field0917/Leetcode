// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// For example:
// Given the following binary tree,
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
// You should return [1, 3, 4].
import java.util.*;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> list = new LinkedList<>();
    helper(list, root, 0);

    return list;
  }

  private void helper(List<Integer> list, TreeNode root, int level) {
  	if (root == null) return;
  	if (list.size() > level) {
  		list.remove(level);
  		
  	}
  	list.add(level, root.val);
  	helper(list, root.left, level + 1);
  	helper(list, root.right, level + 1);
  }

  public static void main(String[] args) {
  	TreeNode a = new TreeNode(1);
  	TreeNode b = new TreeNode(2);
  	TreeNode c = new TreeNode(3);
  	a.left = b;
  	a.right = c;

  	Solution s = new Solution();
  	System.out.println(s.rightSideView(a));
  }
}