// You are a professional robber planning to rob houses along a street. 
// Each house has a certain amount of money stashed, 
// the only constraint stopping you from robbing each of them is that adjacent 
// houses have security system connected and it will automatically contact the 
// police if two adjacent houses were broken into on the same night.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

public class Solution {
  public int rob(int[] nums) {
  	if(nums == null || nums.length == 0) return 0;
  	if(nums.length == 1) return nums[0];
    int seperate = nums[0];
    int adjacent = Math.max(nums[0], nums[1]);
    int res = adjacent;

    for(int i = 2; i < nums.length; i++) {
    	res = Math.max(seperate + nums[i], adjacent);
    	seperate = adjacent;
    	adjacent = res;
    }
    return res;
  }

  public static void main(String[] args) {
  	int[] nums = {};
  	Solution s = new Solution();
  	System.out.println(s.rob(nums));
  }
}