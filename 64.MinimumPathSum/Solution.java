// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

public class Solution {
  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

    for (int i = 0; i < grid.length; i++) {
    	for (int j = 0; j < grid[0].length; j++) {
    		if (i == 0 && j == 0) continue;
    		if (i == 0) {
    			grid[i][j] += grid[i][j - 1];
    			continue;
    		}
    		if (j == 0) {
    			grid[i][j] += grid[i - 1][j];
    			continue;
    		}
    		grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
    	}
    }
    return grid[grid.length - 1][grid[0].length - 1];
  }
}