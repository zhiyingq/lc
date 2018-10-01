class Subsets078 {
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        subsetsHelper(list, 0, new ArrayList<Integer>(), nums);
        return list;
    }

    private void subsetsHelper(List<List<Integer>> list, int start, 
    	List<Integer> subset, int[] nums) {
    	// 不管啥，直接加！
    	list.add(new ArrayList<Integer>(subset));

    	for (int i = start; i < nums.length; i++) {
    		subset.add(nums[i]);
    		subsetsHelper(list, i + 1, subset, nums);
    		subset.remove(subset.size() - 1);
    	}
    }
}