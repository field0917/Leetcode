// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
// For example,

// Consider the following matrix:

// [
//   [1,   3,  5,  7],
//   [10, 11, 16, 20],
//   [23, 30, 34, 50]
// ]
// Given target = 3, return true.

public class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
  	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
    int upR = 0, btmR = matrix.length - 1;
    int lC = 0, rC = matrix[0].length - 1;

    while (upR < btmR) {
    	int midR = (upR + btmR) / 2;
    	if (matrix[midR][rC] == target) return true;
    	if (matrix[midR][rC] < target) upR = midR + 1;
    	else btmR = midR;
    }

    while (lC <= rC) {
    	int midC = (lC + rC) / 2;
    	if (matrix[upR][midC] == target) return true;
    	if (matrix[upR][midC] < target) lC = midC + 1;
    	else rC = midC - 1;
    }
    return false;
  }

  // Treat it like an array
  public boolean searchMatrix(int[][] matrix, int target) {
  	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

  	int m = matrix.length, n = matrix[0].length;
  	int l = 0, r = m * n - 1;

  	while (l <= r) {
  		int mid = (l + r) / 2;
  		if (matrix[mid / n][mid % n] == target) return true;
  		if (matrix[mid / n][mid % n] < target) l = mid + 1;
  		else r = mid - 1;
  	}
  	return false;
  }
}