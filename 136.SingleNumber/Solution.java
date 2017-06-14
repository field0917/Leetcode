// Given an array of integers, every element appears twice except for one. Find that single one.
public class Solution {
	public int singleNumber(int[] nums) {
		int res = 0;
		for (int num : nums) {
			res = res ^ num;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = {2, 3, 4, 2, 4};
		System.out.println("The single number is " + s.singleNumber(nums));
	}
}