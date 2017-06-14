// Given an unsorted array of integers, find the length of longest increasing subsequence.

// For example,
// Given [10, 9, 2, 5, 3, 7, 101, 18],
// The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

// Your algorithm should run in O(n2) complexity.

// Follow up: Could you improve it to O(n log n) time complexity?



public class Solution {

	// O(n^2)
  public int lengthOfLIS(int[] nums) {
  	if (nums == null || nums.length == 0) return 0;
  	if (nums.length == 1) return 1;

    int[] T = new int[nums.length];

    for (int i = 0; i < nums.length; i++) T[i] = 1;

    for (int i = 1; i < nums.length; i++) {
    	for (int j = 0; j < i; j++) {
    		if (nums[j] < nums[i]) {
    			if (T[j] + 1 > T[i]) T[i]++; // eg: 10,9,3,2,5
    		}
    	}
    }
    int longest = 0;
    for (int i = 0; i < nums.length; i++) {
    	if (T[i] > longest) longest = T[i];
    }

    return longest;
  }

  // O(nlgn) use dynamic programming + binary search
  // Sol1
  public int lengthOfLIS(int[] nums) {
  	int[] dp = new int[nums.length];
  	int len = 0;

  	for (int num : nums) {
  		int pos = Arrays.binarySearch(dp, 0, len, num);
  		if (pos < 0) pos = ~pos;
  		dp[pos] = num;
  		if (pos == len) len++;
  	}
  	return len;
  }

  // Sol2
  //Each time we only do one of the two:
  // (1) if x is larger than all tails, append it, increase the size by 1
  // (2) if tails[i-1] < x <= tails[i], update tails[i]
  public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;

    for (int x : nums) {
      int i = 0, j = size;
      while (i != j) {
        int m = (i + j) / 2;
        if (tails[m] < x)
            i = m + 1;
        else
            j = m;
      }
      tails[i] = x;
      if (i == size) size++;
    }
    return size;
}
}