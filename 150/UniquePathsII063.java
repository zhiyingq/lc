class UniquePathsII063 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 对于第一行、第一列，凡是有obstacle的，后续格子全设置为0
        // 其他的格子都设置为0
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) return 0;
        // initialize the board
        int m = obstacleGrid.length; 
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
		int[][] board = new int[m][n];
		initializeBoard(board, obstacleGrid);

		// start dp 
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) continue;
				board[i][j] = board[i - 1][j] + board[i][j - 1];
			}
		}
		return board[m - 1][n - 1];

    }

    private void initializeBoard(int[][] board, int[][] obstacleGrid) {
    	for (int i = 0; i < obstacleGrid[0].length; i++) {
    		if (obstacleGrid[0][i] == 1) break;
    		else { board[0][i] = 1; }
    	}

    	for (int i = 0; i < obstacleGrid.length; i++) {
    		if (obstacleGrid[i][0] == 1) break;
    		else { board[i][0] = 1; }
    	}
    }


}