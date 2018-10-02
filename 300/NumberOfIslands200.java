class NumberOfIslands200 {
	public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        // dfs, count islands
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
        		if (grid[i][j] == '1') {
        			dfs(grid, i, j);
        			count++;
        		}
        	}
        }
        
        // mark back
        for (int i = 0; i < grid.length; i++) {
        	for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '*') {
        			grid[i][j] = '1';
        		}
            }
        }
                
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
    	// check whether i & j are valid coordinates
    	if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
    	// check if we can visit grid[i][j] or is it a land?
    	if (grid[i][j] == '*' || grid[i][j] == '0') return;
    	// change the land to be visited
    	grid[i][j] = '*';
    	dfs(grid, i - 1, j); // up
    	dfs(grid, i + 1, j); // down
    	dfs(grid, i, j - 1); // left
    	dfs(grid, i, j + 1); // right
    }
}