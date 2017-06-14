// You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

// Example:

// [[0,1,0,0],
//  [1,1,1,0],
//  [0,1,0,0],
//  [1,1,0,0]]

// Answer: 16
// Explanation: The perimeter is the 16 yellow stripes in the image below:

public class Solution {
  // public int islandPerimeter(int[][] grid) {
  // 	if (grid.length == 0) return 0;
  //   int perimeter = 0;
  //   int lenX = grid[0].length;
  //   int lenY = grid.length;

  //   for (int x = 0; x < lenX; x++) {
  //   	for (int y = 0; y < lenY; y++) {
  //   		int subPerimeter = 0;
  //   		if (grid[y][x] == 1) {
    			
  // 				if (x == 0) subPerimeter++;
  // 				if (x == lenX - 1) subPerimeter++;
  // 				if (y == 0) subPerimeter++;
  // 				if (y == lenY - 1) subPerimeter++;

  // 				if (x - 1 >= 0 && grid[y][x-1] == 0) subPerimeter++;
  // 				if (x + 1 < lenX && grid[y][x+1] == 0) subPerimeter++;
  // 				if (y - 1 >= 0 && grid[y-1][x] == 0) subPerimeter++;
  // 				if (y + 1 < lenY && grid[y+1][x] == 0) subPerimeter++;
  			
  // 				perimeter += subPerimeter;
  //   		}
    		
  //   	}
  //   }
  //   return perimeter;
  // }

  public int islandPerimeter(int[][] grid) {
  	int island = 0, neighbours = 0;

  	for (int i = 0; i < grid.length; i++) {
  		for (int j = 0; j < grid[0].length; j++) {
  			if (grid[i][j] == 1) {
  				island++;
  				if (i + 1 < grid.length && grid[i+1][j] == 1) neighbours++;
  				if (j + 1 < grid[0].length && grid[i][j+1] == 1) neighbours++; 
  			}
  		}
  	}
    return island * 4  - neighbours * 2;
  }

	public static void main(String[] args) {
		int[][] grid = new int[1][2];
		System.out.println(grid[0].length);
	}
}