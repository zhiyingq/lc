class isGraphBipartite785 {
	private int[] colors;
	public boolean isBipartite(int[][] graph) {
        // 上色问题，上过色的不用再上色，对某一个node上色后再对邻居上色
        // 如果发现collision则跳过
        // 未上色: 0, 红色: 1, 黑色: -1
        colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
        	if (colors[i] == 0) {
        		if (hasCollision(graph, i)) return false;
        	}
        }
        return true;
    }

    private boolean hasCollision(int[][] graph, int i) {
    	if (colors[i] == 0) { colors[i] = 1; } // 这是对于单独的点以及初始点设置的
    	for (int j : graph[i]) {
    		if (colors[j] == colors[i]) return true;
    		if (colors[j] == 0) {
    			colors[j] = -colors[i];
    			if (hasCollision(graph, j)) return true;
    		}		
    	}
    	return false;
    }
}