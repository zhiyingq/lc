class Combinations077 {
	public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	combineHelper(n, k, new boolean[n + 1], 1, list, new ArrayList<Integer>());
    	return list;
    }

    private void combineHelper(int n, int k, boolean[] visited,
    	int start, List<List<Integer>> list, List<Integer> comb) {
    	if (comb.size() == k) {
    		list.add(new ArrayList<Integer>(comb));
    	}

    	for (int i = start; i <= n; i++) {
    		if (visited[i]) continue;
    		comb.add(i);
    		visited[i] = true;
    		combineHelper(n, k, visited, start + 1, list, comb);
    		visited[i] = false;
    		comb.remove(comb.size() - 1);
    	}

    }
}