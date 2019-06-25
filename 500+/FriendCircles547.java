class FriendCircles547 {
	public int findCircleNum(int[][] M) {
    	// M exist and M.length >= 1
    	int count = 0;
    	boolean[] visited = new boolean[M.length];
    	for (int i = 0; i < M.length; i++) {
    		if (!visited[i]) {
    			count++;
    			search(M, i, visited);
    		}
    	}
    	return count;
    }

    private void search(int[][] M, int i, boolean[] visited) {
    	if (visited[i]) return;
    	// 可以走回头路(j从0开始)，但是不能访问之前已经碰到过的点
    	// 比如 length = 3, 0 -> 3，而3 -> 1，必须走回头路才能找到更多朋友
    	// 但是不能访问原来的点否则会stackoverflow
        visited[i] = true;
    	for (int j = 0; j < M.length; j++) {
    		if (j == i) continue;
    		if (M[i][j] == 1) {
    			search(M, j, visited);
    		}
    	}
    }
}