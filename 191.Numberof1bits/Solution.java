// Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

// For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

public class Solution {
  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    int and = 1;
    int res = 0;
    for(int i = 0; i < 32; i++) {
    	if((n & and) == and) {	
    		res += 1;
    	}
    	and <<<= 1;
    }
    return res;
  }
//   public static int hammingWeight(int n) {
// 	int ones = 0;
//     	while(n!=0) {
//     		ones = ones + (n & 1);
//     		n = n>>>1; // We need to use bit shifting unsigned operation >>> (while >> depends on sign extension)
//     	}
//     	return ones;
// }

  public static void main(String[] args) {
  	int n = 5;
  	Solution s = new Solution();
  	System.out.println(s.hammingWeight(n));
  }
}