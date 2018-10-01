class CloneGraph133 {
	private Map<UndirectedGraphNode, UndirectedGraphNode> map;
	// visited可以不用的，只要看是否存在就可以了
    // private Map<UndirectedGraphNode, Boolean> visited;
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
		map = new HashMap<>();
		dfs(node);    	
		return map.get(node);
    }

    private void dfs(UndirectedGraphNode node) {
    	if (map.containsKey(node)) return; // if visited, return
    	map.put(node, new UndirectedGraphNode(node.label));
    	for (UndirectedGraphNode neighbor : node.neighbors) {
    		dfs(neighbor);
    		map.get(node).neighbors.add(map.get(neighbor));
    	}
    }
}