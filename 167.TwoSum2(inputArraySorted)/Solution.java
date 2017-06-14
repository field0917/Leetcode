// Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

// The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

// You may assume that each input would have exactly one solution.

// Input: numbers={2, 7, 11, 15}, target=9
// Output: index1=1, index2=2

public class Solution {
	// O(n ^ 2)
  // public int[] twoSum(int[] numbers, int target) {
  //   for (int i = 0; i < numbers.length; i++) {
  //   	for (int j = i + 1; j < numbers.length; j++) {
  //   		if (numbers[i] + numbers[j] == target) return new int[]{i + 1, j + 1};
  //   	}
  //   }
  //   return null;
  // }

  // O(n)
  public int[] twoSum(int[] numbers, int target) {
    int[] res = new int[2];

    int left = 0, right = numbers.length - 1;

    while (left < right) {
    	int value = numbers[left] + numbers[right]
    	if (value == target) {
    		res[0] = left + 1;
    		res[1] = right + 1;
    		break;
    	}
   		else if (value < target) left++;
    	else right--;
    }
    return res;
  }
}