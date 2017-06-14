// A peak element is an element that is greater than its neighbors.

// Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that num[-1] = num[n] = -∞.

// For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

// Note:
// Your solution should be in logarithmic complexity.


public class Solution {

	// O(n)
  public int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0 || nums.length == 1) return 0;

    int idx = 1;

    while (idx < nums.length) {
    	if (nums[idx] < nums[idx - 1]) return idx - 1;
    	else idx++;
    }
    return idx - 1;
  }

  // O(logn)
  public int findPeakElement(int[] nums) {
  	int left = 0;
  	int right = nums.length - 1;

  	while (left < right) {
  		int mid = left + (right - left) / 2;

  		if (nums[mid] < nums[mid + 1]) {
  			left = mid + 1;
  		} else {
  			right = mid;
  		}
  	}
  	return left;
  }
}