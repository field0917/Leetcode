// The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

// Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

// Example 1:
// Input: nums = [1,2,2,4]
// Output: [2,3]
// Note:
// The given array size will in the range [2, 10000].
// The given array's numbers won't have any order.


public class Solution {

    // O(n) time, O(n) space
    public int[] findErrorNums(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int originalSum = (1 + nums.length) * nums.length / 2;
        int[] res = new int[2];

        for (int num : nums) {
            sum += num;
            if (!set.add(num)) res[0] = num;
        }

        res[1] = originalSum - sum + res[0];
        return res;
    }

    // O(n) time, O(1) space
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            if (nums[idx] > 0) nums[idx] = -nums[idx];
            else res[0] = idx + 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res[1] = i + 1;
        }
        return res;
    }
}