class CountCompleteTreeNodes222 {
	public int countNodes(TreeNode root) {
        if (root == null) { return 0; }
        int left = countLeft(root.left);
        int right = countRight(root.right);
        if (left == right) { return (1 << (left + 1)) - 1; }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
    
    private int countLeft(TreeNode root) {
        int count = 0;
        while (root != null) { count++; root = root.left; }
        return count;
    }
    
    private int countRight(TreeNode root) {
        int count = 0;
        while (root != null) { count++; root = root.right; }
        return count;
    }

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}