// Given an integer, write a function to determine if it is a power of two.

public class Solution {
	// Recursion
  // public boolean isPowerOfTwo(int n) {
  // 	if(n <= 0) return false;
  // 	if(n == 1) return true;
  // 	if(n % 2 != 0) return false;
  //   return isPowerOfTwo(n / 2);
  // }

  // Iteration
  public boolean isPowerOfTwo(int n) {
  	if(n <= 0) return false;
  	while(n / 2 > 0) {
  		if(n % 2 == 0) n = n / 2;
  		else return false;
  	}
  	return true;
  }

  public static void main(String[] args) {
  	int n = 44;
  	Solution s = new Solution();
  	System.out.println(s.isPowerOfTwo(n));
  }
}