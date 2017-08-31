// Initially on a notepad only one character 'A' is present. You can perform two operations on this notepad for each step:

// Copy All: You can copy all the characters present on the notepad (partial copy is not allowed).
// Paste: You can paste the characters which are copied last time.
// Given a number n. You have to get exactly n 'A' on the notepad by performing the minimum number of steps permitted. Output the minimum number of steps to get n 'A'.

// Example 1:
// Input: 3
// Output: 3
// Explanation:
// Intitally, we have one character 'A'.
// In step 1, we use Copy All operation.
// In step 2, we use Paste operation to get 'AA'.
// In step 3, we use Paste operation to get 'AAA'.
// Note:
// The n will be in the range [1, 1000].


class Solution {
    // DP + recursion, my solution
    public int minSteps(int n) {
        if (n == 1) return 0;
        if (isPrime(n)) return n;

        // int a = (int)Math.sqrt(n);
        // while(n % a != 0) a--;
        // int b = n / a;

        int a = n / 2;
        while (n % a != 0) a--;
        int b = n / a;

        //if (a == b) return minSteps(a) * 2;
        return minSteps(a) + b;

    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // DP
    public int minSteps(int n) {
        int[] dp = new int[n+1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = i/2; j > 1; j--) {
                if (i % j == 0) {
                    dp[i] = dp[j] + (i/j);
                    break;
                }
                
            }
        }
        return dp[n];
    }

    // Iteration
// Eg.   n=18
// 18/2 = 9 Copy 9 'A's 2 times (2)
// 9/3=3 Copy 3 'A's 3 times (3)
// 3/3=1 Copy 1'A's 3 times (3)
// Answer: 2+3+3= 8
    public int minSteps(int n) {
        int s = 0;
        for (int d = 2; d <= n; d++) {
            while (n % d == 0) {
                s += d;
                n /= d;
            }
        }
        return s;
    }

    
    public static void main(String[] args) {
        int n = 9;
        Solution s = new Solution();
        System.out.println(s.minSteps(n));
    }
}