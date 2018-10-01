class BinaryTreeLevelOrderTraversal107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> list = new LinkedList<>();
    	Queue<TreeNode> queue = new LinkedList<>();
    	if (root != null) queue.add(root);
    	while (queue.size() > 0) {
    		int size = queue.size();
    		List<Integer> thislevel = new LinkedList<>();
    		for (int i = 0; i < size; i++) {
    			TreeNode node = queue.poll();
    			thislevel.add(node.val);
    			if (node.left != null) queue.add(node.left);
    			if (node.right != null) queue.add(node.right);
    		}
    		list.add(0, thislevel);
    	}
    	return list;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> list = new LinkedList<>();
    	helper(list, root, 1);
    	return list;
    }

    private void helper(List<List<Integer>> list, TreeNode root, int level) {
    	if (root == null) { return; }
    	if (level > list.size()) { list.add(0, new LinkedList<Integer>()); }
    	list.get(list.size() - level).add(root.val);

    	helper(list, root.left, level + 1);
    	helper(list, root.right, level + 1);
    }


	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}