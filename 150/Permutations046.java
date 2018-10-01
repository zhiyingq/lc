class Permutations046 {
	// Given a collection of distinct integers, return all possible permutations.
	// Method1: 用一个ArrayList来维护剩下的点
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int i : nums) { numsList.add(i); }
        permuteHelper(permutations, numsList, new ArrayList<Integer>(), nums.length);
    	return permutations;
    }

    private void permuteHelper(List<List<Integer>> permutations, 
    	List<Integer> numsList, List<Integer> permut, int length) {
    	if (permut.size() == length) {
    		permutations.add(new ArrayList<Integer>(permut)); return;
    	}
    	for (int i = 0; i < numsList.size(); i++) {
    		permut.add(numsList.get(i));
    		int number = numsList.remove(i);
    		permuteHelper(permutations, numsList, permut, length);
    		numsList.add(i, number);
    		permut.remove(permut.size() - 1);
    	}
    }

    // Method2: 用visited来保存当前已访问的数字
    // 虽然读取更快，但每次一个位置都要考虑n次
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteHelper(permutations, visited, nums, new ArrayList<Integer>());
    	return permutations;
    }

    private void permuteHelper(List<List<Integer>> permutations, 
    	boolean[] visited, int[] nums, List<Integer> permut) {
    	if (permut.size() == nums.length) {
    		permutations.add(new ArrayList<Integer>(permut)); return;
    	}
    	for (int i = 0; i < nums.length; i++) {
            if (visited[i]) { continue; }
    		permut.add(nums[i]);
    		visited[i] = true;
    		permuteHelper(permutations, visited, nums, permut);
    		visited[i] = false;
    		permut.remove(permut.size() - 1);
    	}
    }
}