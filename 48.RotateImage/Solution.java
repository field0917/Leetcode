// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// Follow up:
// Could you do this in-place?



public class Solution {
	// Come up this solution by myself!!!!
  public void rotate(int[][] matrix) {
    if (matrix == null) return;
    int n = matrix.length;

    for (int col = 0; col < n/2; col++) {
    	for (int row = col; row < n - col - 1; row++) {
	    	int count = 4;

	    	int newR = col, newC = n - row - 1;
	    	int temp1 = matrix[row][col];
	    	int temp2 = matrix[newR][newC];
	    	
	    	while (count > 0) {
	    		matrix[newR][newC] = temp1;
	    		temp1 = temp2;
	    		count--;
	    		row = newR; col = newC;
	    		newR = col; newC = n - row - 1;
	    		temp2 = matrix[newR][newC];
	    	}
	    }
    }   
  }

  // Common method to rotate image
  /*
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	*/

  public void rotate (int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for( int j = i; j < matrix.length; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
      }
    }
    for (int i = 0 ; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length / 2; j++) {
        int temp = 0;
        temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix.length - 1 - j];
        matrix[i][matrix.length - 1 - j] = temp;
      }
    }
  }

	/*
	 * anticlockwise rotate
	 * first reverse left to right, then swap the symmetry
	 * 1 2 3     3 2 1     3 6 9
	 * 4 5 6  => 6 5 4  => 2 5 8
	 * 7 8 9     9 8 7     1 4 7
	*/




}