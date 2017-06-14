// Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than or equal to the node's key.
// The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
// Both the left and right subtrees must also be binary search trees.
// For example:
// Given BST [1,null,2,2],
//    1
//     \
//      2
//     /
//    2
// return [2].

// Note: If a tree has more than one mode, you can return them in any order.

// Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	// Using extra space
  public int[] findMode(TreeNode root) {
  	if (root == null) return new int[]{};
    Map<Integer, Integer> map = new HashMap<>();
    int max = getFrequency(root, map);
    ArrayList<Integer> al = new ArrayList<>();

    for (int key : map.keySet()) {
    	if (map.get(key) == max) {
    		al.add(key);
    	}
    }

    int[] res = new int[al.size()];
    for (int i = 0; i < al.size(); i++) {
    	res[i] = al.get(i);
    }
    return res;
  }

  private int getFrequency(TreeNode root, Map<Integer, Integer> map) {
  	if (root == null) return 0;
  	int max = 0;
  	int newFreq = map.getOrDefault(root.val, 0) + 1;
  	map.put(root.val, newFreq);
  	if (newFreq > max) max = newFreq;

  	max = Math.max(Math.max(getFrequency(root.left, map), getFrequency(root.right, map)), max);

  	return max;
  }

  // O(1) solution
  public int[] findMode(TreeNode root) {
  	List<Integer> temp = new LinkedList<>();
  	int[] var = new int[3]; // var[0] = max, var[1] = curr_val_count, var[2] = prev_node_val

  	helper(root, var, temp);

  	int[] result = new int[temp.size()];
  	for (int i = 0; i < temp.size(); i++) result[i] = temp.get(i);
  	return result;
  }
  // in-order traverse can make sure all the nodes with same value are consecutive
  private void helper(TreeNode root, int[] var, List<Integer> temp) {
  	if (root == null) return;
  	helper(root.left, var, temp);

  	var[1] = root.val == var[2] ? var[1] + 1 : 1;
  	if (var[1] >= var[0]) {
  		if (var[1] > var[0]) temp.clear();
  		var[0] = var[1];
  		temp.add(root.val);
  	}
  	var[2] = root.val;

  	helper(root.right, var, temp);
  }



}