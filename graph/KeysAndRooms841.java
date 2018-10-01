class KeysAndRooms841 {
	private List<List<Integer>> myRooms;
	private boolean[] visited;
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    	// just to check whether the components are connected or not
    	myRooms = rooms;
    	visited = new boolean[myRooms.size()];
    	int count = 0;
    	// doing dfs to each room and check how many components
    	for (int i = 0; i < myRooms.size(); i++) {
    		if (!visited[i]) { 
    			dfs(i); 
    			count++; 
    			if (count > 1) return false;
    		}
    	}
    	return count == 1;
    }

    private void dfs(int i) {
    	visited[i] = true;
    	for (int j : myRooms.get(i)) {
    		if (!visited[j]) { 
    			dfs(j); 
    		}
    	}
    }
}