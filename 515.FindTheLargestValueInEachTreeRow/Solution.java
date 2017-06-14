// You need to find the largest value in each row of a binary tree.

// Example:
// Input: 

//           1
//          / \
//         3   2
//        / \   \  
//       5   3   9 

// Output: [1, 3, 9]

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	//Come up by myself!!!!!
  // public List<Integer> largestValues(TreeNode root) {
  // 	List<List<Integer>> list = new LinkedList<>();

  // 	List<Integer> result = new LinkedList<>();

  // 	levelLists(root, list, 0);

  // 	for (int i = 0; i < list.size(); i++) {
  // 		int max = Integer.MIN_VALUE;
  // 		for (int j = 0; j < list.get(i).size(); j++) {	
  // 			if (list.get(i).get(j) > max) max = list.get(i).get(j);
  // 		}
  // 		result.add(max);
  // 	}
  // 	return result;
  // }

  // private void levelLists(TreeNode root, List<List<Integer>> list, int level) {
  // 	if (root == null) 
  // 		return;

  // 	levelLists(root.left, list, level + 1);
  // 	levelLists(root.right, list, level + 1);

  // 	while (list.size() < level + 1) {
  // 		list.add(new LinkedList<Integer>());
  // 	}
  // 	list.get(level).add(root.val);
  	  	
  // }


  // More clever solution
  public List<Integer> largestValues(TreeNode root) {
  	List<Integer> result = new LinkedList<>();
  	helper(root, result, 0);
  	return result;
  }

  private void helper(TreeNode root, List<Integer> result, int level) {
  	if (root == null) return;

  	if (level == result.size()) {
  		result.add(root.val);
  	} else result.set(level, Math.max(result.get(level),root.val));

  	helper(root.left, result, level + 1);
  	helper(root.right, result, level + 1);
  }
}