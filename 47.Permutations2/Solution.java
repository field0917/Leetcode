// Given a collection of numbers that might contain duplicates, return all possible unique permutations.

// For example,
// [1,1,2] have the following unique permutations:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]
import java.util.*;
public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> list = new LinkedList<>();
    boolean[] used = new boolean[nums.length];
    Arrays.sort(nums);
    helper(list, new LinkedList<>(), nums, used);
    return list;

  }
  private void helper(List<List<Integer>> list, List<Integer> sublist, int[] nums, boolean[] used) {
  	if (sublist.size() == nums.length) {
  		list.add(new LinkedList<>(sublist));
  		return;
  	}

  	for (int i = 0; i < nums.length; i++) {
  		if (used[i]) 
  			continue;
  		if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) 
  			continue;// when a number has the same value with its previous, we can use this number only if his previous is used
			sublist.add(nums[i]);
			used[i] = true;
			helper(list, sublist, nums, used);
			used[i] = false;
			sublist.remove(sublist.size() - 1);
  	
  	}
  }

  public static void main(String[] args) {
  	int[] nums = {1, 2, 1};
  	Solution s = new Solution();
  	System.out.println(s.permuteUnique(nums));
  }
}