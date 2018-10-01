class Triangle120 {
	/*
	Bottom-Up Method!
	*/
	public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) { return 0; }
        // 考虑到后面minPaths[j + 1]可能会outOfBound, 这里设置长度+1
		int[] minPaths = new int[triangle.size() + 1];

		for (int level = triangle.size() - 1; level >=0; level--) {
			for (int j = 0; j <= level; j++) {
                minPaths[j] = Math.min(minPaths[j], minPaths[j + 1]) + triangle.get(level).get(j);
			}
		}

		return minPaths[0];
    }

}