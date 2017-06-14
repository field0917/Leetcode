// Given a positive integer num, write a function which returns True if num is a perfect square else False.

// Note: Do not use any built-in library function such as sqrt.

// Example 1:

// Input: 16
// Returns: True
// Example 2:

// Input: 14
// Returns: False

public class Solution {
	// 1 + 3 + 5 + 7 + .... sum are square numbers O(sqrt(n))
	public boolean isPerfectSquare(int num) {
		int sub = 1;
		while (num > 0) {
			num -= sub;
			sub += 2;
		}
		return num == 0;
	}

	// Binary search O(log(n))
	public boolean isPerfectSquare(int num) {
		int low = 1, high = num;
		long mid = (low + high) / 2;

		while (low <= high) {
			if (mid * mid == num) return true;
			else if (mid * mid < num) low = (int)(mid + 1);
			else high = (int)(mid - 1);
		}
		return false;
	}
}