// Given an integer (signed 32 bits), write a function to check whether it is a power of 4.

// Example:
// Given num = 16, return true. Given num = 5, return false.

// Follow up: Could you solve it without loops/recursion?

public class Solution {
	// Recursion
	public boolean isPowerOfFour(int num) { // 4 ^ n
    if (num == 0) return false;
    if (num == 1) return true;
		if (num % 4 != 0) return false;
		else return isPowerOfFour(num / 4);
	}

	// No recursion
	public boolean isPowerOfFour(int num) { // 4 ^ n
    return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) == num);
	}
	// n & (n - 1) == 0 is to make sure num is power of 2
	// (num & 0x55555555) == num is to make sure num is power of 4 
	// since in binary version, '1' always locates at the odd position
}