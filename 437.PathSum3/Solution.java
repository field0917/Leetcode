// You are given a binary tree in which each node contains an integer value.

// Find the number of paths that sum to a given value.

// The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

// The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

// Example:

// root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

//       10
//      /  \
//     5   -3
//    / \    \
//   3   2   11
//  / \   \
// 3  -2   1

// Return 3. The paths that sum to 8 are:

// 1.  5 -> 3
// 2.  5 -> 2 -> 1
// 3. -3 -> 11

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {

	// O(n ^ 2)
  // public int pathSum(TreeNode root, int sum) {
  // 	if (root == null) return 0;

  // 	return findPaths(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  // }

  // private int findPaths(TreeNode root, int sum) {
  // 	int numPath = 0;
  // 	if (root == null) return numPath;
  // 	if (root.val == sum) numPath++;
  // 	numPath += findPaths(root.left, sum - root.val);
  // 	numPath += findPaths(root.right, sum -root.val);
  // 	return numPath;
  // }

  // O(n)
  public int pathSum(TreeNode root, int sum) {
  	if (root == null) return 0;
  	Map<Integer, Integer> map = new HashMap<>(); // To store all the preSum of the paths, and how many possibilities to get this preSum
  	map.put(0, 1); // when currSum - target == 0, there should be 1 path to get target
  	return helper(root, 0, sum, map);
  }

  private int helper(TreeNode root, int currSum, int target, Map<Integer, Integer> map) {
  	if (root == null) return 0;

  	currSum += root.val;
  	int res = 0;

  	if (map.containsKey(currSum - target)) res = map.get(currSum - target);

  	if (!map.containsKey(currSum)) map.put(currSum, 1);
  	else map.put(currSum, map.get(currSum) + 1);

  	res += helper(root.left, currSum, target, map);
  	res += helper(root.right, currSum, target, map);
  	map.put(currSum, map.get(currSum) - 1); // If we are done with current node, we just need to delete the current pathsum in the preSum, 
  																					// and leave all other prefix sum in it. Then, in higher layers, 
  																					// we can forget everything about this node (and its descendants).

  	return res;
  }
}




