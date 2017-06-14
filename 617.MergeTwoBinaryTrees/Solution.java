// Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

// You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

// Example 1:
// Input: 
// 	Tree 1                     Tree 2                  
//           1                         2                             
//          / \                       / \                            
//         3   2                     1   3                        
//        /                           \   \                      
//       5                             4   7                  
// Output: 
// Merged tree:
// 	     3
// 	    / \
// 	   4   5
// 	  / \   \ 
// 	 5   4   7
// Note: The merging process must start from the root nodes of both trees.


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return null;
    TreeNode t = mergeNodes(t1, t2);
    t.left = mergeTrees(getLeft(t1), getLeft(t2));
    t.right = mergeTrees(getright(t1), getRight(t2));
    return t;
  }

  private TreeNode getLeft(TreeNode t) {
  	return t == null ? null : t.left;
  }

  private TreeNode getRight(TreeNode t) {
  	return t == null ? null : t.right;
  }

  private TreeNode mergeNodes(TreeNode t1, TreeNode t2) {
  	int val = 0;
  	if (t1 == null || t2 == null) {
  		val = t1 == null ? t2.val : t1.val;
  	} else {
  		val = t1.val + t2.val;
  	}
  	TreeNode t = new TreeNode(val);
  	return t;
  }
  
}

