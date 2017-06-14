// Given a collection of distinct numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]

import java.util.*;
public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new LinkedList<>();
    boolean[] used = new boolean[nums.length];
    helper(nums, list, new LinkedList<>(), used);
    return list;
  }
  private void helper(int[] nums, List<List<Integer>> list, List<Integer> sublist, boolean[] used) {
  	if (sublist.size() == nums.length) {
  		list.add(new LinkedList<>(sublist));
  		return;
  	}

  	for (int i = 0; i < nums.length; i++) {
  		if (!used[i]) {
  			sublist.add(nums[i]);
  			used[i] = true;
  			helper(nums, list, sublist, used);
  			used[i] = false;
  			sublist.remove(sublist.size() - 1);
  		}
  		
  	}
  }

  public static void main(String[] args) {
  	int[] nums = {1, 2, 3};
  	Solution s = new Solution();
  	System.out.println(s.permute(nums));
  }
}