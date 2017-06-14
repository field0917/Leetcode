// Follow up for "Search in Rotated Sorted Array":
// What if duplicates are allowed?

// Would this affect the run-time complexity? How and why?
// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Write a function to determine if a given target is in the array.

// The array may contain duplicates.

public class Solution {
	//O(n)
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return false;

		int pivotIdx = -1;
		int left = 0;
		int right = nums.length - 1;
		boolean res = false;

		// Find the pivot index
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) continue;
			if (nums[i] < nums[i - 1]) {
				pivotIdx = i - 1;
				break;
			}
		}
		// If there is a pivot, search one of the two parts
		// If not, search the whole array
		if (pivotIdx != -1) {
			if (target < nums[0]) {
				left = pivotIdx + 1;
				right = nums.length - 1;
			} else {
				left = 0;
				right = pivotIdx;
			}
		}
		return searchIdx(nums, left, right, target);
	}

	private boolean searchIdx(int[] nums, int left, int right, int target) {
		while (left <= right) {
				int mid = (left + right) / 2;
				if (nums[mid] == target) return true;
				if (nums[mid] < target) left = mid + 1;
				else right = mid - 1;
		}
		return false;
	}

	// O(logn), worst case O(n)
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return false;

		int lo = 0;
		int hi = nums.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (nums[mid] == target) return true;

			if (nums[lo] < nums[mid]) {
				if (target >= nums[lo] && target < nums[mid]) hi = mid - 1;
				else lo = mid + 1;
			} else if (nums[lo] > nums[mid]) {
				if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
				else hi = mid - 1;
			} else lo++;
		}
		return false;
	}
}