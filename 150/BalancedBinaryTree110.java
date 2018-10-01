class BalancedBinaryTree110 {
	public boolean isBalanced(TreeNode root) {
		return getHeight(root) != -1;
    }
    
    // 返回子树的高度，如果该树不是平衡树，返回-1
    // 如果为null,返回0
    private int getHeight(TreeNode root) {
        if (root == null)  return 0;
        // 左右子树不平衡的话，该数本身就不平衡，返回-1；
        int left = getHeight(root.left);
        if (left == -1) { return -1; }
        int right = getHeight(root.right);
        if (right == -1) { return -1; }
        
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
        if (!isBalanced(root.left) || !isBalanced(root.right)) return false;
		return Math.abs(depth(root.left) - depth(root.right)) <= 1;
    }

    private int depth(TreeNode root) {
    	if (root == null) return 0;
    	return Math.max(depth(root.left), depth(root.right)) + 1;
    }

}