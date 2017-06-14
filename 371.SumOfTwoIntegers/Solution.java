// Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

// Example:
// Given a = 1 and b = 2, return 3.

public class Solution {
	// Recursive
  public int getSum(int a, int b) {
    int xor = a ^ b;
    int carry = (a & b) << 1;
    if (carry != 0) 
    	return getSum(xor, carry);
    else return xor;
  }

  // Iterative
  public int getSum(int a, int b) {
  	int carry = 0;
    while (b != 0) {
    	carry = a & b;
    	a = a ^ b;	
    	b = carry << 1;
    }
    return a;
  }

  public static void main(String[] args) {
  	int a = 1;
  	int b = 2;
  	Solution s = new Solution();
  	System.out.println(s.getSum(a, b));
  }
}