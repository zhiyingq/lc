class PermutationII047 {
	/*
	idea: 1.排序
	2. 若有1 + x个连续的1，那么对于第一个1而言，后面所有可能的排列都已经遍历了
	因此，后面的1已经没有必要再取了，对于第二个1也是同样。将这一性质运用到所有值相等的元素上
	*/
	public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> permutations = new ArrayList<>();
    	Arrays.sort(nums);
    	permutateHelper(permutations, new ArrayList<Integer>(), new boolean[nums.length], nums);
    	return permutations;
    }

    private void permutateHelper(List<List<Integer>> permutations, 
    	List<Integer> permutate, boolean[] visited, int[] nums) {
    	if (permutate.size() == nums.length && nums.length > 0) {
    		permutations.add(new ArrayList<Integer>(permutate));
    	}
    	for (int i = 0; i < nums.length; i++) {
    		// 这里要注意就是!visited[i - 1],表明i - 1被跨过而直接访问了i
    		// 本来我们应该是严格按照从前往后的顺序，现在先访问后面的显然是不对滴。
    		// 即一个数字如果和前面的数字相同，必须是从前往后访问的，否则就会出现重复
    		if ((i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) || visited[i]) continue;
    		permutate.add(nums[i]);
    		visited[i] = true;
    		permutateHelper(permutations, permutate, visited, nums);
    		visited[i] = false;
    		permutate.remove(permutate.size() - 1);
    	}

    }
}