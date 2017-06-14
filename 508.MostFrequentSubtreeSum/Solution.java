// Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

// Examples 1
// Input:

//   5
//  /  \
// 2   -3
// return [2, -3, 4], since all the values happen only once, return all of them in any order.
// Examples 2
// Input:

//   5
//  /  \
// 2   -5
// return [2], since 2 happens twice, however -5 only occur once.
// Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.


class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	int maxFreq = 0;
  public int[] findFrequentTreeSum(TreeNode root) {
  	if (root == null) return new int[0];

    Map<Integer, Integer> hm = new HashMap<>();
    sumOfChildren(root, hm);

    List<Integer> res = new ArrayList<>();

    for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
    	if (entry.getValue() == maxFreq) {
    		res.add(entry.getKey());
    	}
    }

    int[] result = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
    	result[i] = res.get(i);
    }
    return result;
  }

  private int sumOfChildren(TreeNode root, Map<Integer, Integer> hm) {
  	if (root == null) return 0;

  	int left = sumOfChildren(root.left, hm);
  	int right = sumOfChildren(root.right, hm);
  	int sum = left + right + root.val;
  	int freq = hm.getOrDefault(sum, 0) + 1;
  	hm.put(sum, freq);

  	maxFreq = Math.max(maxFreq, freq);

  	return sum;
  }
}