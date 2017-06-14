// Let's play the minesweeper game (Wikipedia, online game)!

// You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

// Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

// If a mine ('M') is revealed, then the game is over - change it to 'X'.
// If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
// If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
// Return the board when no more squares will be revealed.
// Example 1:
// Input: 

// [['E', 'E', 'E', 'E', 'E'],
//  ['E', 'E', 'M', 'E', 'E'],
//  ['E', 'E', 'E', 'E', 'E'],
//  ['E', 'E', 'E', 'E', 'E']]

// Click : [3,0]

// Output: 

// [['B', '1', 'E', '1', 'B'],
//  ['B', '1', 'M', '1', 'B'],
//  ['B', '1', '1', '1', 'B'],
//  ['B', 'B', 'B', 'B', 'B']]

// Explanation:

// Example 2:
// Input: 

// [['B', '1', 'E', '1', 'B'],
//  ['B', '1', 'M', '1', 'B'],
//  ['B', '1', '1', '1', 'B'],
//  ['B', 'B', 'B', 'B', 'B']]

// Click : [1,2]

// Output: 

// [['B', '1', 'E', '1', 'B'],
//  ['B', '1', 'X', '1', 'B'],
//  ['B', '1', '1', '1', 'B'],
//  ['B', 'B', 'B', 'B', 'B']]

// Explanation:

// Note:
// The range of the input matrix's height and width is [1,50].
// The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
// The input board won't be a stage when game is over (some mines have been revealed).
// For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.


public class Solution {
  public char[][] updateBoard(char[][] board, int[] click) {
    
    int row = click[0], col = click[1];
    // If click is 'M', change it to 'X', game over!
    if (board[row][col] == 'M') {
    	board[row][col] = 'X';
    	return board;
    }

    // If click is 'E'
    // 1. No adjacent mines, change to 'B', alse change its adjacent cells
    // 2. 1--8 adjacent mines, change to '1' -- '8'
    if (board[row][col] == 'E') {
    	int numM = checkAdjacentCells(board, row, col);
    	if (numM == 0) board[row][col] = 'B';
    	else board[row][col] = (char)('0' + numM);
    }
    
    // If click is 'B', make all its adjacent reveal
    if (board[row][col] == 'B') {
    	for (int i = row - 1; i <= row + 1; i++) {
	  		for (int j = col - 1; j <= col + 1; j++) {
	  			if (i == row && j == col) continue;
	  			if (isValid(board, i, j) && board[i][j] == 'E') updateBoard(board, new int[]{i, j});
	  		}
  		}
    }
    return board;
  }
  private int checkAdjacentCells(char[][] board, int row, int col) {
  	int numM = 0;
  	for (int i = row - 1; i <= row + 1; i++) {
  		for (int j = col - 1; j <= col + 1; j++) {
  			if (i == row && j == col) continue;
  			if (isValid(board, i, j) && board[i][j] == 'M') numM++;
  		}
  	}
  	return numM;
  }

  private boolean isValid(char[][] board, int row, int col) {
  	return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
  }
}