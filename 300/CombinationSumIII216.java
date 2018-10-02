class CombinationSumIII216 {
	private List<List<Integer>> combinations;
	public List<List<Integer>> combinationSum3(int k, int n) {
        combinations = new ArrayList<List<Integer>>();
        if (n > 9 * k) return combinations;
        getCombs(k, n, 1, new ArrayList<Integer>());
        return combinations;

    }

    private void getCombs(int nums, int target, int start, List<Integer> comb) {
    	if (target < 0 || nums < 0) return;
    	if (nums == 0 && target == 0) {	
    		this.combinations.add(new ArrayList<Integer>(comb));
    		return;
    	}

    	for (int i = start; i <= 9; i++) {
            if (target < start) break;
    		comb.add(i);
    		getCombs(nums - 1, target - i, i + 1, comb);
    		comb.remove(comb.size() - 1);
    	}
    }
}