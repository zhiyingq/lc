class SubsetsII090 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> subsetList = new ArrayList<List<Integer>>();
        if (nums.length == 0) return subsetList;
        Arrays.sort(nums);
        subsetHelper(subsetList, new ArrayList<Integer>(), 0, nums);
        return subsetList;
    }

    private void subsetHelper(List<List<Integer>> subsetList, 
    	List<Integer> subset, int start, int[] nums) {
        subsetList.add(new ArrayList<Integer>(subset));	
        if (start >= nums.length) return;
    	for (int i = start; i < nums.length; i++) {
    		if (i > start && nums[i] == nums[i - 1]) continue;
    		subset.add(nums[i]);
    		subsetHelper(subsetList, subset, i+ 1, nums);
    		subset.remove(subset.size() - 1);
    	}
    }
}