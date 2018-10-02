class BinaryTreeRightSideView199 {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<Integer>();
        // do BFS here, only take the last element of the queue each time
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) { queue.offer(root); }
        while (!queue.isEmpty()) {
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = queue.poll();
        		if (node.left != null) { queue.offer(node.left); }
        		if (node.right != null) { queue.offer(node.right); }
        		if (i == size - 1) { rightSide.add(node.val); }
        	}
        }
        return rightSide;
    }

    class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }
}