// Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

// Example 1:
// Input:

// "bbbab"
// Output:
// 4
// One possible longest palindromic subsequence is "bbbb".
// Example 2:
// Input:

// "cbbd"
// Output:
// 2
// One possible longest palindromic subsequence is "bb".


public class Solution {

    // Iteration
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }

    // Recursion
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        return helper(s, 0, len - 1, new int[len][len]);
    }

    private int helper(String s, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        if (i > j) return 0;
        if (i == j) return 1;
        
        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = helper(s, i + 1, j - 1, dp) + 2;
        } else {
            dp[i][j] = Math.max(helper(s, i + 1, j, dp), helper(s, i, j - 1, dp));
        }
        
        return dp[i][j];
    }
}