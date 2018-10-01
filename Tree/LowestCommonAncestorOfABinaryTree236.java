class LowestCommonAncestorOfABinaryTree236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Every node returns whether its left child is an ancestor of one node
        // or its right child is an ancestor of one node

        // if left child / right child is null, then return null
        // if one of them is an ancestor, return it
        // if both of them is an ancestor return the node itself

    }

    private TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
    	if (root == null) return null;
    	if (root == p || root == q) { return root; }
    	// 在root没有的情况下
    	TreeNode left = ancestorHelper(root.left, p, q); //左边有没有？
    	TreeNode right = ancestorHelper(root.right, p, q); //右边有没有?
    	if (left == null) { 
    		if (right != null) { return right; }
    		return null;
    	}
    	if (right != null) return root;
    	return left;

    }
}