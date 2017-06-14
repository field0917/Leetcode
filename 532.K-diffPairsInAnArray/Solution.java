// Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.

// Example 1:
// Input: [3, 1, 4, 1, 5], k = 2
// Output: 2
// Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
// Although we have two 1s in the input, we should only return the number of unique pairs.
// Example 2:
// Input:[1, 2, 3, 4, 5], k = 1
// Output: 4
// Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
// Example 3:
// Input: [1, 3, 1, 5, 4], k = 0
// Output: 1
// Explanation: There is one 0-diff pair in the array, (1, 1).
// Note:
// The pairs (i, j) and (j, i) count as the same pair.
// The length of the array won't exceed 10,000.
// All the integers in the given input belong to the range: [-1e7, 1e7].

import java.util.*;
public class Solution {

	// O(nlgn)
	// Notice :
	// 1. nums = {1, 1, 1, 1}, k = 0
	// 2. nums = {1, 1, 2, 2}, k = 1
  public int findPairs(int[] nums, int k) {
    if (nums == null || nums.length < 2) return 0;

    Arrays.sort(nums);

    int i = 0, j = 1;
    int count = 0;

    while (i < nums.length && j < nums.length) {
    	if (i == j || nums[j] - nums[i] < k) j++;
    	
    	else if (nums[j] - nums[i] == k) {
    		count++;
    		i++;
    		//j++;

    		while (i < nums.length && nums[i] == nums[i - 1]) {
    			i++;
    		}
    		j = Math.max(i + 1, j + 1);
    	}

    	else {
    		// if (j - i <= 1) {
    		// 	j++;
    		// }
    		i++;
    	}
    }
    return count;
  }

  // O(n)
  public int findPairs(int[] nums, int k) {
  	if (k < 0) return 0;
  	Map<Integer, Integer> hm = new HashMap<>();
  	int count = 0;

  	for (int num : nums) {
  		hm.put(num, hm.getOrDefault(num, 0) + 1);
  	}

  	if (k == 0) {
  		for (Integer value : hm.values()) {
  			if (value != 1) count++;
  		}
  	} else {
  		for (Integer key : hm.keySet()) {
  			if (hm.containsKey(key - k)) {
  				count++;
  				hm.remove(key - k);
  			}
  		}
  	}

  	return count;
  }

  public static void main(String[] args) {
  	int[] nums = {1, 3, 1, 5, 4};
  	int k = 0;
  	Solution s = new Solution();

  	System.out.println(s.findPairs(nums, k));
  }
}