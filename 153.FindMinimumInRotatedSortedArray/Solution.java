// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// You may assume no duplicate exists in the array.

public class Solution {
  public int findMin(int[] nums) {
  	if (nums.length == 1) return nums[0]; // Only one element in it!!!! 
  	Integer res = null;
    for (int i = 1; i < nums.length; i++) {
    	if (nums[i] - nums[i - 1] < 0) res = nums[i];
    }
    return res == null ? nums[0] : res; // The array may rotated or not!!!!!
  }

  // Binary Search
  public int findMin(int[] nums) {
  	if (nums.length == 1) return nums[0]; // Only one element in it!!!! 
  	
  	int start = 0, end = nums.length - 1;

  	while (start < end) {
  		if (nums[start] < nums[end]) return nums[start];

  		int mid = (start + end) / 2;
  		if (nums[mid] >= nums[start]) start = mid + 1;
  		else end = mid;
  	}
  	return nums[start];
  }
}