// Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.

// Example 1:
// Input: [1,12,-5,-6,50,3], k = 4
// Output: 12.75
// Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
// Note:
// 1 <= k <= n <= 30,000.
// Elements of the given array will be in the range [-10,000, 10,000].


public class Solution {

    // change nums
    public double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) return nums[0];
        
        double maxSum = 0.0 + Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = k - 1, j = -1; i < nums.length; i++, j++) {
            int sum = 0;

            if (i == k - 1) sum = nums[k - 1];
            else sum = nums[i] - nums[j];

            if (sum > maxSum) maxSum = (double)sum;
        }
        return maxSum / k;
    }

    // no change of nums
    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        long max = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }

        return max/1.0/k;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        Solution s = new Solution();
        System.out.println(s.findMaxAverage(nums, k));
    }
}