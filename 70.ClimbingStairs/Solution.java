// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

public class Solution {
  public int climbStairs(int n) {
    int num1 = 1;
    int num2 = 2;
    int num3 = 0;
    if(n == 1) return num1;
    if(n == 2) return num2;
    for(int i = 3; i <= n; i++) {
    	num3 = num1 + num2;
      num1 = num2;
      num2 = num3;
    }
    return num3;
  }

  public static void main(String[] args) {
  	int n = 5;
  	Solution s = new Solution();
  	System.out.println(s.climbStairs(n));
  }
}