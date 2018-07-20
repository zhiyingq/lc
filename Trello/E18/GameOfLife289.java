import java.lang.IllegalArgumentException; 
class GameOfLife289 {
	public void gameOfLife(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0) { return; }
		int[][] updateboard = new int[board.length][board[0].length];
		for (int i = 0; i < updateboard.length; i++) {
			for (int j = 0; j < updateboard[0].length; j++) {
				updateboard[i][j] = update(board, i, j);
			}
		}
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = updateboard[i][j];
			}
		}
	}

	private int update(int[][] board, int row, int col) {
		// 9 cases
		if (!isValid(board, row, col)) { throw new IllegalArgumentException(); }
		int ones = 0;
		if (isValid(board, row - 1, col)) { if (board[row - 1][col] == 1) { ones++; } }
		if (isValid(board, row + 1, col)) { if (board[row + 1][col] == 1) { ones++; } }
		if (isValid(board, row - 1, col + 1)) { if (board[row - 1][col + 1] == 1) { ones++; } }
		if (isValid(board, row - 1, col - 1)) { if (board[row - 1][col - 1] == 1) { ones++; } }
		if (isValid(board, row + 1, col + 1)) { if (board[row + 1][col + 1] == 1) { ones++; } }
		if (isValid(board, row + 1, col - 1)) { if (board[row + 1][col - 1] == 1) { ones++; } }
		if (isValid(board, row, col + 1)) { if (board[row][col + 1] == 1) { ones++; } }
		if (isValid(board, row, col - 1)) { if (board[row][col - 1] == 1) { ones++; } }
		
		// Any live cell with fewer than two live neighbors dies, as if caused by under-population.
		// Any live cell with more than three live neighbors dies, as if by over-population.
		// Any live cell with two or three live neighbors lives on to the next generation.
		if (board[row][col] == 1) { if (ones < 2 || ones > 3) { return 0; } else { return 1; } }
		// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction
		if (ones == 3) { return 1; }
		return 0;	
	}

	private boolean isValid(int[][] board, int row, int col) {
		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) { return false; }
		return true; 
	}

	






}