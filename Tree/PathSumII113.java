class PathSumII113 {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> list = new LinkedList<>();
        List<Integer> thislevel = new ArrayList<>();
        helper(root, sum, list, thislevel);
        return list;
    }

    
    private void helper(TreeNode root, int sum, List<List<Integer>> list,  List<Integer> thislevel) {
    	if (root == null) return;
        thislevel.add(root.val); // System.out.println(thislevel.toString() + " sum = "+sum);
    	if (root.left == null && root.right == null && root.val == sum) {
            List<Integer> copy = new LinkedList<>();
            for (int i : thislevel) { copy.add(i); }
            list.add(copy);
            thislevel.remove(thislevel.size() - 1);
    		return;
    	}
    	helper(root.left, sum - root.val, list, thislevel);
        helper(root.right, sum - root.val, list, thislevel);
    	thislevel.remove(thislevel.size() - 1);
    }
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}