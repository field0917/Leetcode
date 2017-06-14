// Follow up for "Remove Duplicates": Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// For example,
// Given input array nums = [1,1,2],

// Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array nums = [1,1,1,2,2,3],

// Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.


public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums == null) return 0;
    if (nums.length < 2) return nums.length;

    int i = 1, j = 1;
    int n = 1;

    while (i < nums.length) {
    	if (nums[i] != nums[i - 1]) {
    		n = 1;
    		nums[j] = nums[i];
    		j++;
    	} else {
    		if (n < 2) {
    			nums[j] = nums[i];
    			j++;
    			n++;
    		}
    	}
    	i++;
    }
    return j;
  }

  // shorter solution
  public int removeDuplicates(int[] nums) {
  	int i = 0;
  	for (int n : nums) {
  		if (i < 2 || n > nums[i - 2]) {
  			nums[i++] = n;
  		}
  	}
  	return i;
  }

  public static void main(String[] args) {
  	int[] nums = {1, 1, 1, 2, 2, 3};
  	Solution s = new Solution();
  	System.out.println(s.removeDuplicates(nums));
  }
}