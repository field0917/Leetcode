// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

// How many possible unique paths are there?


// Above is a 3 x 7 grid. How many possible unique paths are there?

// Note: m and n will be at most 100.

public class Solution {
  public int uniquePaths(int m, int n) {
  	
  	int[] T = new int[n + 1];
  	for (int i = 0; i <= n; i++) {
  		T[i] = 1;
  	}

  	for (int i = 2; i <= m; i++) {
  		for (int j = 2; j <= n; j++) {
  			if (j == 2) T[j] = T[j] + 1;
  			else T[j] = T[j] + T[j - 1];
  		}
  	}
    
    return T[n];
  }
}