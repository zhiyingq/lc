class LC928 {
	public int minMalwareSpread(int[][] graph, int[] initial) {
		int n = graph.length;
		int minMal = n * n;
		int minNode = -1;

		for (int node : initial) {
			int[][] copygraph = copyGraph(graph, node);
			int countMal = countMalware(graph, initial);
			if (countMal < minMal) {
				minMal = countMal;
				minNode = node;
			}
		}

		return minNode;
        
    }

    private int countMalware(int[][] graph, int[] initial) {
    	int count = 0;
    	boolean[] visited = new boolean[graph.length];
    	for (int node : initial) {
    		if (!visited[node]) {
    			count += dfs(graph, node);
    		}
    	}
    	return count;
    }

    private int dfs(int[][] graph, int node, boolean[] visited) {
    	if (visited[node]) return 0;
    	visited[node] = true;
    	int count = 1;
    	for (int j = node + 1; j < graph.length; j++) {
    		if (!visited[j] && graph[node][j] == 1) {
    			count += dfs(graph, j, visited);
    		}
    	}
    	return count;
    }

    private int[][] copyGraph(int[][] graph, int tabu) {
    	int n = graph.length;
    	int[][] copy = new int[n][n];
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			if (i == tabu || j == tabu) {
    				copy[i][j] = 0;
    			}
    			else {
    				copy[i][j] = graph[i][j];
    			}
    			
    		}
    	}
    	return copy;
    }
}













