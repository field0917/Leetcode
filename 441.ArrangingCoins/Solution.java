// You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

// Given n, find the total number of full staircase rows that can be formed.

// n is a non-negative integer and fits within the range of a 32-bit signed integer.

// Example 1:

// n = 5

// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤

// Because the 3rd row is incomplete, we return 2.
// Example 2:

// n = 8

// The coins can form the following rows:
// ¤
// ¤ ¤
// ¤ ¤ ¤
// ¤ ¤

// Because the 4th row is incomplete, we return 3.


public class Solution {

	// !!!!THIS WONT WORK, CAUSE N COULD BE Integer.MAX_VALUE, THE SUM WILL EXCEED!!!!

  // public int arrangeCoins(int n) {
  // 	int sum = 0;
  // 	int res = 0;
  //   for (int i = 0; i < n; i++) {
  //   	sum += i;
  //   	if (sum > n) {
  //   		res = i - 1;
  //   		break;
  //   	}
  //   	else if (sum == n) {
  //   		res = i;
  //   		break;
  //   	}
  //   	else continue;
  //   }
  //   return res;
  // }

	// quadratic equation
	public int arrangeCoins(int n) {
		return (int)((Math.sqrt(1 + 8.0 * n) - 1) / 2); // Use 8.0 not 8
	}

	// Binary Search
	public int arrangeCoins(int n) {
		int start = 0;
		int end = n;
		int mid = 0;

		while (start <= end) {
			mid = (start + end) / 2;
			if (0.5 * mid + 0.5 * mid * mid <= n) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return start - 1;
	}



  public static void main(String[] args) {
  	int n = 5;
  	Solution s = new Solution();
  	System.out.println(s.arrangeCoins(n));
  }
}