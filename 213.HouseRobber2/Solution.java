// Note: This is an extension of House Robber.

// After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

// Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.


public class Solution {
  public int rob(int[] nums) {
  	if (nums == null || nums.length == 0) return 0;
  	if (nums.length == 1) return nums[0];

  	int n = nums.length;
    int[] dp1 = new int[n]; // store the max value from house 0 -- house n - 2
    int[] dp2 = new int[n]; // store the max value from house 1 -- house n - 1
    
    dp1[0] = nums[0];
    dp2[1] = nums[1];

    for (int i = 1; i < n; i++) {
    	if (i == 1) dp1[i] = Math.max(dp1[i - 1], nums[i]);
    	else {
    		dp1[i] = Math.max(dp1[i - 2] + nums[i], dp1[i - 1]);
    		dp2[i] = Math.max(dp2[i - 2] + nums[i], dp2[i - 1]);
    	}
    }

    return Math.max(dp1[n - 2], dp2[n - 1]);
  }

  // Make your function reusable
  public int rob(int[] nums) {
    if (nums.length == 1) return nums[0];
    
    return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
  }

  private int rob(int[] num, int lo, int hi) {
    int preRob = 0, preNotRob = 0;
    int rob = 0, notRob = 0;

    for (int j = lo; j <= hi; j++) {
      rob = preNotRob + num[j];
      notRob = Math.max(preRob, preNotRob);

      preRob = rob;
      preNotRob = notRob;
    }

    return Math.max(rob, notRob);
  }
}