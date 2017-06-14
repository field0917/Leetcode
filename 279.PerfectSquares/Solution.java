// Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

// For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

public class Solution {
  public int numSquares(int n) {
    int[] dp = new int[n + 1];

    for (int i = 0; i < n + 1; i++) {
    	dp[i] = Integer.MAX_VALUE;
    }

    dp[0] = 0;


    for (int i = 1; i < n + 1; i++) {
    	int j = 1;
    	while (i - j * j >= 0) {
    		dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
    		j++;
    	}
    }
    return dp[n];
  }
}