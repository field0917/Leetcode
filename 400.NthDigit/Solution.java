// Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...

// Note:
// n is positive and will fit within the range of a 32-bit signed integer (n < 231).

// Example 1:

// Input:
// 3

// Output:
// 3
// Example 2:

// Input:
// 11

// Output:
// 0

// Explanation:
// The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.


public class Solution {
  public int findNthDigit(int n) {
  	if (n < 10) return n;

    int numDigit = 1;
    //int e = 0;
    int base = 1;
    int res = 0;
    int target = 0;
    long count = 9;

    // while ((n - 9 * Math.pow(10, e) * numDigit) > 0) {
    // 	n = (int)(n - 9 * Math.pow(10, e) * numDigit);
    // 	numDigit++; // how many digits does target number have
    // 	e++;
    // }

    while (n > count * numDigit) {
    	n -= count * numDigit;
    	numDigit++;
    	count *= 10;
    	base *= 10;
    }

    //base *= Math.pow(10, numDigit - 1);

    // if (n % numDigit == 0) {
    // 	target = base + n / numDigit - 1;
    // 	res = target % 10;
    // } else {
    // 	target = base + n / numDigit;
    // 	int redundant = n % numDigit;
    // 	for (int i = 0; i < redundant; i++) {
    // 		target /= 10;
    // 	}
    // 	res = target % 10;
    // }
    target = base + (n - 1) / numDigit;
    String s = Integer.toString(target);

    return Character.getNumericValue(s.charAt((n - 1) % numDigit));
  }

  public static void main(String[] args) {
  	int n = 15;
  	Solution s = new Solution();
  	System.out.println(s.findNthDigit(n));
  }
}