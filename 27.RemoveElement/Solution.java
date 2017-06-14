// Given an array and a value, remove all instances of that value in place and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory.

// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

// Example:
// Given input array nums = [3,2,2,3], val = 3

// Your function should return length = 2, with the first two elements of nums being 2.

public class Solution {
  public int removeElement(int[] nums, int val) {
    if(nums == null || nums.length == 0) return 0;

    int end = nums.length - 1;
    for(int i = 0; i <= end; i++) {
    	if(nums[i] == val) {
    		while (nums[end] == val && end > i) {
    			end--;
    		}

    		nums[i] = nums[end];
    		end--;
    	}
    }
    return end + 1;
  }

  public static void main(String[] args) {
  	int[] nums = {1};
  	int val = 1;
  	Solution s = new Solution();

  	System.out.println(s.removeElement(nums,val));
  }
}