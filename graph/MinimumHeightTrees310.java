class MinimumHeightTrees310 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 0 || edges == null) { return new ArrayList<Integer>(); }
		
		// initialize the graph
        Set<Integer>[] graph = new HashSet[n];
        for (int i = 0; i < n; i++) { graph[i] = new HashSet<Integer>(); }
    	for (int[] edge : edges) { 
    		graph[edge[0]].add(edge[1]);
    		graph[edge[1]].add(edge[0]);
    	}

    	// initialize the leaves list 
    	Queue<Integer> leaves = new LinkedList<Integer>();
    	for (int i = 0; i < n; i++) { 
    		if (graph[i].size() == 1 || graph[i].size() == 0) { leaves.add(i); }
    	}

    	// 只要剩余>2个leaves，就继续
    	while (n > 2) {
    		int leaves_size = leaves.size();
    		n -= leaves_size;

    		for (int i = 0; i < leaves_size; i++) {
    			// leaf only have ONE neighbor
    			int leaf = leaves.poll();
    			int leafNeighbor = graph[leaf].iterator().next(); 		
    			graph[leafNeighbor].remove(leaf);	
    			if (graph[leafNeighbor].size() == 1) { leaves.add(leafNeighbor); }
    		}
    	}
    	return (List<Integer>) leaves;
    }
}





















