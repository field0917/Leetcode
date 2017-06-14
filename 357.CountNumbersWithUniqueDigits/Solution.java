// Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

// Example:
// Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])



public class Solution {
  public int countNumbersWithUniqueDigits(int n) {
  	if (n == 0) return 1;
  	//if (n == 1) return 10;
    int uniqueDigits = 9;
    int availableNum = 9;
    int uniqueNumberCount = 10;

   	for (int i = 0; i < n - 1; i++) {
   		if (availableNum == 0) break;
   		uniqueDigits = uniqueDigits * availableNum;
   		uniqueNumberCount += uniqueDigits;
   		availableNum--;
   	}
   	return uniqueNumberCount;
  }
}