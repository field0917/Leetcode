// Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

// For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

// Note: You may assume that n is not less than 2 and not larger than 58.

//-------------- EXPLANATION ---------------//
// If an optimal product contains a factor f >= 4, 
// then you can replace it with factors 2 and f-2 without losing optimality, 
// as 2*(f-2) = 2f-4 >= f. So you never need a factor greater than or equal to 4, 
// meaning you only need factors 1, 2 and 3 (and 1 is of course wasteful and 
// you'd only use it for n=2 and n=3, where it's needed).
// For the rest I agree, 3*3 is simply better than 2*2*2, 
// so you'd never use 2 more than twice.

// Math:
public class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;
        return product;
    }
}

// Dinamic Programming
public class Solution {
    public int integerBreak(int n) {
        if (n > 3) n++;
        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }
        return dp[n];
    }
}