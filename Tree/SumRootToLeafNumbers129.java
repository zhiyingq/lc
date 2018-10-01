class SumRootToLeafNumbers129 {
	 public int sumNumbers(TreeNode root) {
        return sumHelper(root, 0);
    }

    private int sumHelper(TreeNode root, int num) {
    	if (root == null) return 0;
        num = num * 10 + root.val;
    	if (root.left == null && root.right == null) { return num;	}
    	return sumHelper(root.left, num) + sumHelper(root.right, num);
    }
}