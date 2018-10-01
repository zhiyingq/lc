class NQueensII052 {
	private int count = 0;
	public int totalNQueens(int n) {
        // construct a board
        char[][] board = new char[n][n];
        for (char[] row : board) { Arrays.fill(row, '.'); }
        countHelper(board, new boolean[3][2 * n], 0);
    	return this.count;     
    }

    private void countHelper(char[][] board, boolean[][] visited, int row) {
    	int n = board.length;
    	if (row == n) { this.count++; }
    	for (int col = 0; col < n; col++) {
    		// if this column is valid
    		if (visited[0][col] || visited[1][row - col + n - 1] || visited[2][row + col])
    			continue;
    		// put the queens to the (row, col) and do next step
    		setBoard(board, visited, row, col, true);
    		countHelper(board, visited, row + 1);
    		setBoard(board, visited, row, col, false);
    	}
    } 

    private void setBoard(char[][] board, boolean[][] visited, int row, 
    	int col, boolean value) {
    	if (value) { board[row][col] = 'Q'; }
    	else { board[row][col] = '.'; }
    	visited[0][col] = value; // the column "col"
    	visited[1][row - col + board.length - 1] = value; // the left-right diagonal
    	visited[2][row + col] = value; // the right-left diagonal;
    }
}