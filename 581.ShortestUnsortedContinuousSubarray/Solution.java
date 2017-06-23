// Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

// You need to find the shortest such subarray and output its length.

// Example 1:
// Input: [2, 6, 4, 8, 10, 9, 15]
// Output: 5
// Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
// Note:
// Then length of the input array is in range [1, 10,000].
// The input array may contain duplicates, so ascending order here means <=.


public class Solution {
    public int findUnsortedSubarray(int[] nums) {
       if (nums == null || nums.length == 0) return 0;

       int len = nums.length;
       int min = nums[len - 1], max = nums[0];
       int start = -1, end = -2;

       for (int i = 1; i < len; i++) {
           min = Math.min(min, nums[len - 1 - i]);
           max = Math.max(max, nums[i]);

           if (nums[i] < max) end = i;
           if (nums[len - 1 - i] > min) start = len - 1 - i;
       }
       return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 7, 3, 5};
        Solution s = new Solution();
        System.out.println(s.findUnsortedSubarray(nums));
    }
}