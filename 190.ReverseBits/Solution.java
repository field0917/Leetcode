// Reverse bits of a given 32 bits unsigned integer.

// For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
// return 964176192 (represented in binary as 00111001011110000010100101000000).

// Follow up:
// If this function is called many times, how would you optimize it?

public class Solution {
	// you need treat n as an unsigned value

	// Solution 1:
  public int reverseBits(int n) {
  	final int BIT_LENGTH = 32;
    int m = 1;
    int res = 0;
    for (int i = 0; i < BIT_LENGTH; i++) {
    	if ((n & m) != 0) {
    		res += 1 << BIT_LENGTH - i - 1;
    	}
    	m = m << 1;
    }
    return res;
  }

  // Solution 2:
  public int reverseBits(int n) {
  	int res = 0;
  	for (int i = 0; i < 32; i++) {
  		res <<= 1;
  		if ((n & 1) == 1) res += 1;
  		n >>= 1;
  	}
  	return res;
  }

	public static void main(String[] args) {
		int n = 3;
		Solution s = new Solution();
		System.out.println(s.reverseBits(n));
	}
}