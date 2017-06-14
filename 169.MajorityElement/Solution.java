// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

// You may assume that the array is non-empty and the majority element always exist in the array.
import java.util.Map;
import java.util.HashMap;

public class Solution {
  // public int majorityElement(int[] nums) {
  // 	Map<Integer, Integer> hm = new HashMap<>();
  // 	int max = 0;
  // 	// int majorityNum = 0;
  // 	if(nums.length == 1) return nums[0];

  // 	for(int num : nums) {
  // 		if(hm.containsKey(num)) {
  // 			Integer count = hm.get(num) + 1;
  // 			hm.put(num, count);
  // 			if(count > nums.length/2) return num;
  // 		} else {
  // 			hm.put(num, 1);
  // 		}
  // 	}
  // 	return 0;
  // }

  // Using vote algrithem
  public int majorityElement(int[] nums) {
  	int majority = nums[0];
  	int count = 1;

  	for(int i = 1; i < nums.length; i++) {
  		if(majority == nums[i]) count++;
  		else if(majority != nums[i] && count != 0) count--;
  		else {
  			majority = nums[i];
  			count = 1;
  		}
  	}
  	return majority;
  }

  public static void main(String[] args) {
  	int[] nums = {0,1,3,1,1};
  	Solution s = new Solution();

  	System.out.println(s.majorityElement(nums));
  }
}