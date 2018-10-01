class CombinationSumII040 {
	// 一想到重复=> 就要想到排序！！
	// 本题就是暴力搜索剪枝
	// 如果考虑重复的，比如1,3,2,2,4,3,1
	// 先进行【排序】排成 1，1，2，2，3，3，4
	// 然后如果【后面】的和【前面】的有重复，则跳过，因为后面所有的组合已经在前面考虑过了
	// 假设我们考虑1后面有 x个1， 那么：
	// 1后面0个1: 已经考虑过, 1后面1个1: 已经考虑过，..., 1后面x个1：也已经考虑过
	// 也就是所有含有1的情况都已经被考虑过了。因此后面的1就不需要考虑啦！
	private List<List<Integer>> combines;
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        combines = new ArrayList<List<Integer>>();
        List<Integer> comb = new ArrayList<Integer>();
        Arrays.sort(candidates);
        combinationHelper(candidates, 0, target, comb);
        return combines;
    }

    private void combinationHelper(int[] candidates, int start, int target, List<Integer> comb) {
    	if (target == 0) { 
            combines.add(new ArrayList<Integer>(comb)); return; 
        }
    	if (target < 0) return;

    	for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) continue;
    		comb.add(candidates[i]);
    		combinationHelper(candidates, i + 1, target - candidates[i], comb);
    		comb.remove(comb.size() - 1);
    	}
    }
}