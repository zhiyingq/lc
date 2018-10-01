class NQueens051 {
	private List<List<String>> solutions; 
	public List<List<String>> solveNQueens(int n) {
        // 1.逐行填写
        // 2.逐列填写,判断是否和已有列数、主对角线、斜对角线冲突
        // 3.用一个二维数组来保存已经占据的列数、主对角线和斜对角线
        
        // 初始化
        solutions = new ArrayList<>();
        boolean[][] visited = new boolean[3][2 * n];
        char[][] solution = new char[n][n];
        for (char[] lines :solution) { Arrays.fill(lines, '.'); }
        
        // back-tracking
        solveHelper(visited, solution, n, 0);
        return solutions;
    }

    private void solveHelper(boolean[][] visited, 
    	char[][] solution, int n, int i) {
    	// 如果到达了结尾，说明已经生成符合条件的答案
    	if (i == n) {
    		List<String> oneSolution = new ArrayList<String>();
    		for (char[] lines : solution) {
    			oneSolution.add(new String(lines));
    		}
    		solutions.add(oneSolution);
    	}

    	// 逐行填写，用i来控制行数
    	// 用visited来控制列数及左右主对角线
    	// 本来有一个for循环来控制行数的，现在看上去其实是不用的
    	// 因为我们就是严格按照从第一行到最后一行来做的
    	
    	for (int j = 0; j < n; j++) {
    		// if not valid (is occupied by other queens)
    		if (visited[0][j] || visited[1][n + i - j - 1] || visited[2][i + j])
    			continue;
			// change the value
   			solution[i][j] = 'Q';
   			// update the visited
   			visited[0][j] = true; visited[2][i + j] = true; 
   			visited[1][n + i - j - 1] = true; // 0 - (2n - 2) 
   			solveHelper(visited, solution, n, i + 1);
   			visited[0][j] = false; visited[2][i + j] = false; 
   			visited[1][n + i - j - 1] = false;
   			solution[i][j] = '.';
    	}
    	
    }
}