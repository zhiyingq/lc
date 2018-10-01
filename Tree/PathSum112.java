class PathSum112 {
	public boolean hasPathSum(TreeNode root, int sum) {
       return helper(root, sum);
    }
    
    private boolean helper(TreeNode root, int sum) {
        if (root == null) { return false; }
        if ( root.left == null && root.right == null) {
            if (sum == root.val) { return true; }
            return false;
        }
        return helper(root.right, sum - root.val) || helper(root.left, sum - root.val);
    }
}