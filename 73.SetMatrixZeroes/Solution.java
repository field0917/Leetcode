// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

// Follow up:
// Did you use extra space?
// A straight forward solution using O(mn) space is probably a bad idea.
// A simple improvement uses O(m + n) space, but still not the best solution.
// Could you devise a constant space solution?

public class Solution {
  public void setZeroes(int[][] matrix) {
    boolean col0 = false;
    int m = matrix.length;
    int n = matrix[0].length;

    // up-down
    for (int i = 0; i < m; i++) {
    	if (matrix[i][0] == 0) col0 = true;

    	for (int j = 1; j < n; j++) {  		
    		if (matrix[i][j] == 0) {
    			matrix[i][0] = matrix[0][j] = 0;
    		}
    	}
    }

    // bottom-up
    for (int i = m - 1; i >= 0; i--) {
    	for (int j = n - 1; j >= 1; j--) {
    		if (matrix[0][j] == 0 || matrix[i][0] == 0) {
    			matrix[i][j] = 0;
    		}
    	}
    	if (col0) matrix[i][0] = 0;
    }
  }
}