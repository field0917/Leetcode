// Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.

// Example 1:
// Input: [1,1,2,3,3,4,4,8,8]
// Output: 2
// Example 2:
// Input: [3,3,7,7,10,11,11]
// Output: 10
// Note: Your solution should run in O(log n) time and O(1) space.

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];

        int start = 0, end = nums.length - 1;

        //while (start <= end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            // if (mid == 0 || mid == nums.length - 1) return nums[mid];
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];
            // if (mid % 2 == 0) {
            //     if (nums[mid] != nums[mid + 1]) {
            //         end = mid - 1;
            //     } else {
            //         start = mid + 1;
            //     }
            // } else {
            //     if (nums[mid] != nums[mid - 1]) {
            //         end = mid - 1;
            //     } else {
            //         start = mid + 1;
            //     }
            // }
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1]) start = mid + 1;
            else if (mid % 2 != 0 && nums[mid] == nums[mid - 1]) start = mid + 1;
            else end = mid - 1;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,10,11};
        Solution s = new Solution();
        System.out.println(s.singleNonDuplicate(nums));
    }
}