// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution.

// Example:
// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].
// UPDATE (2016/2/13):
// The return format had been changed to zero-based indices. Please read the above updated description carefully.
import java.util.*;

public class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    int[] idxArr = new int[2];
    int diff = 0;

    for (int i = 0; i < nums.length; i++) {
    	diff = target - nums[i];
    	if (map.containsKey(nums[i])) {
    		idxArr[1] = i;
    		idxArr[0] = map.get(nums[i]);
    		break;
    	}
    	map.put(diff, i);
    }
    return idxArr;
  }
}