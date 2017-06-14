// Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

// For example:

// Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

// Note:
// The order of the result is not important. So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?


public class Solution {
  public int[] singleNumber(int[] nums) {
  	int diff = 0;
    for (int num : nums) {
    	diff ^= num;
    }

    // Create the mask，this expression can find the right most 1 bit.
    diff &= -diff;

    int[] res = {0, 0};

    for (int num : nums) {
    	if (num & diff == 0) { // num with the bit set
    		res[0] ^= num;
    	} else {               // num with the bit not set
    		res[1] ^= num;
    	}
    }

    return res;
  }
}