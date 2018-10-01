class ValidateBinarySearchTree098 {
	public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    private boolean isValid(TreeNode root, long max, long min) {
    	if (root == null)  return true;
        if (root.val >= max || root.val <= min) { return false; }
    	return isValid(root.left,(long) root.val, min) && isValid(root.right, max, (long) root.val);
    }
	
	class TreeNode {
		int val;
		TreeNode lfet;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}