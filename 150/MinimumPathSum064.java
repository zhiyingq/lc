class MinimumPathSum064{
	public int minPathSum(int[][] grid) {
        // 1. 每个格子都只能由上面和左边的格子走到，因为Non-negative不能走回头路
        // 2. 每个格子代表“目前为止到它的最短路径”
        if (grid.length == 0 || grid[0].length == 0) return 0;
        for (int i = 1; i < grid[0].length; i++) {
        	grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < grid.length; i++) {
        	grid[i][0] += grid[i - 1][0];
        }

        for (int i = 1; i < grid.length; i++) {
        	for (int j = 1; j < grid[0].length; j++) {
        		grid[i][j] += (grid[i - 1][j] < grid[i][j - 1] ? grid[i - 1][j] : grid[i][j - 1]);
        	}
        }

        return grid[grid.length - 1][grid[0].length - 1];

    }
}