// Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// For example,
// Given n = 3,

// You should return the following matrix:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]

public class Solution {
  public int[][] generateMatrix(int n) {
    int row = 0, col = 0;
    int maxR = n - 1, maxC = n - 1;
    int minR = 0, minC = 0;
    int e = 1;
    int[][] res = new int[n][n];

    while (maxR >= minR && maxC >= minC) {
    	for (; col <= maxC; col++) {
    		res[row][col] = e;
    		e++;
    	}
    	row++;
    	col--;
    	minR++;

    	for (; row <= maxR; row++) {
    		res[row][col] = e;
    		e++;
    	}
    	row--;
    	maxC--;
    	col--;

    	for (; col >= minC; col--) {
    		res[row][col] = e;
    		e++;
    	}
    	col++;
    	maxR--;
    	row--;

    	for (; row >= minR; row--) {
    		res[row][col] = e;
    		e++;
    	}
    	row++;
    	minC++;
    	col++;
    }
    return res;
  }
}