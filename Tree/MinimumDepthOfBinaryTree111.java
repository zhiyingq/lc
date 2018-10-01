class MinimumDepthOfBinaryTree111 {
	public int minDepth(TreeNode root) {
        return minheight(root, 0);
    }

    private int minheight(TreeNode root, int level) {
    	// level: the previous level, not including the current
    	if (root == null) return level;
        if (root.left == null && root.right == null) { return level + 1; }
        if (root.left == null) return minheight(root.right, level + 1);
        if (root.right == null) return minheight(root.left, level + 1);
        return Math.min(minheight(root.right, level + 1), minheight(root.left, level + 1));
    }
}