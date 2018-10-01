class ConvertSortedArrayToBST108 {
	public TreeNode sortedArrayToBST(int[] nums) {
        return subTree(nums, 0, nums.length - 1);
    }

    private TreeNode subTree(int[] nums, int low, int high) {
    	if (low > high) return null;
    	// if (low == high) return new TreeNode(nums[low]);
    	int mid = low + (high - low) / 2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = subTree(nums, low, mid - 1);
    	root.right = subTree(nums, mid + 1, high);
    	return root;
    }
}