// Given an integer array, find three numbers whose product is maximum and output the maximum product.

// Example 1:
// Input: [1,2,3]
// Output: 6
// Example 2:
// Input: [1,2,3,4]
// Output: 24
// Note:
// The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
// Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
import java.util.*;

public class Solution {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        //int nump = 0, numn = 0, numz = 0;
        int len = nums.length;
        // for (int n : nums) {
        //     if (n < 0) numn++;
        //     else if (n == 0) numz++;
        //     else nump++;
        // }

        // if (nump == 0 || numn < 2) {
        //     return nums[len - 1] * nums[len - 2] * nums[len - 3];
        // } else {
        //     int p1 = nums[0] * nums[1] * nums[len - 1];
        //     int p2 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        //     return p1 <= p2 ? p2 : p1;
        // }
        int p1 = nums[0] * nums[1] * nums[len - 1];
        int p2 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        return p1 <= p2 ? p2 : p1;

    }

    public static void main(String[] args) {
        int[] nums = {-8, -7, -2, -1};
        Solution s = new Solution();

        System.out.println(s.maximumProduct(nums));
    }
}