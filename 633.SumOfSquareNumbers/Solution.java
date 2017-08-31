// Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

// Example 1:
// Input: 5
// Output: True
// Explanation: 1 * 1 + 2 * 2 = 5
// Example 2:
// Input: 3
// Output: False


public class Solution {
    public boolean judgeSquareSum(int c) {
        if (c < 0) return false;

        int left = 0, right = (int)Math.sqrt(c);

        while (left <= right) {
            int res = left * left + right * right;
            if (res == c) return true;
            if (res < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int c = 3;
        System.out.println(s.judgeSquareSum(c));
    }
}