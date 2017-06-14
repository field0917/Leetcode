// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// For example,
// If n = 4 and k = 2, a solution is:

// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> list = new LinkedList<>();
    helper(list, new LinkedList<>(), n, k, 1);
    return list;
  }

 	private void helper(List<List<Integer>> list, List<Integer> sublist, int n, int k, int start) {
 		if (sublist.size() == k) {
 			list.add(new LinkedList<>(sublist));
 			return;
 		}
 		for (int i = start; i <= n; i++) {
 			sublist.add(i);
 			helper(list, sublist, n, k, i+1);
 			sublist.remove(sublist.size() - 1);
 		}
 	}
}