// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// You are given a target value to search. If found in the array return its index, otherwise return -1.

// You may assume no duplicate exists in the array.

public class Solution {

	// O(n) Find pivot

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;

		int pivotIdx = -1;
		int left = 0;
		int right = nums.length - 1;
		int res = 0;


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

	private int searchIdx(int[] nums, int left, int right, int target) {
		while (left <= right) {
				int mid = (left + right) / 2;
				if (nums[mid] == target) return mid;
				if (nums[mid] < target) left = mid + 1;
				else right = mid - 1;
		}
		return -1;
	}

	// O(logn) Dont find pivot

	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;

		int lo = 0;
		int hi = nums.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (target == nums[mid]) return mid;

			if (nums[lo] <= nums[mid]) {
				if (target >= nums[lo] && target < nums[mid]) hi = mid - 1;
				else lo = mid + 1;
			} else {
				if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
				else hi = mid - 1;
			}
		}
		return -1;
	}

}