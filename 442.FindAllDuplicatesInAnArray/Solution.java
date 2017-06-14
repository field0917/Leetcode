// Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

// Find all the elements that appear twice in this array.

// Could you do it without extra space and in O(n) runtime?

// Example:
// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [2,3]


public class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    if (nums == null || nums.length == 0) return new LinkedList<Integer>();

    List<Integer> list = new LinkedList<>();

    for (int num : nums) {
    	int idx = Math.abs(num) - 1;
    	if (nums[idx] < 0) list.add(idx + 1);
    	else nums[idx] *= -1;
    }
    return list;
  }
}