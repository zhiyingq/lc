class UniquePaths062 {
	// 考虑每个格子，要到达这个格子，只能从上面或者左边
	// 因此每个格子board[i][j] = board[i - 1][j] + board[i][j - 1];
	// 但是我们知道最上面一列和最左边一列一开始是没有值的，也没办法从其他地方到达
	// 只有一条路径，因此我们把最上、最左初始化为1
	public int (int m, int n) {
        int[][] board[m][n] = new int[m][n];
        for (int col = 0; col < n; col++) { board[0][col] = 1; }
        for (int row = 0; row < m; row++) { board[0][row] = 1; }

        for (int row = 1; row < m; row++) {
        	for (int col = 1; col < n; col++) {
        		board[row][col] = board[row - 1][col] + board[row][col - 1];
        	}
        }

        return board[m - 1][n - 1];
    }

    // 仅使用一个数组长度为列数n，重复m（行数)次, 第一次是初始化值使其全部为1
    // 这是因为每一行只用到了上面的一行（即它本身）和左边的一个数
    // 因此我们只需要一行来不断更新它的值（根据左边的数和前面的数）就可以了
    public int (int m, int n) {
    	int[] line = new int[n];
    	line[0] = 1;
    	for (int i = 0; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			line[j] += line[j - 1];
    		}
    	}
    	return line[n - 1];
    }

}