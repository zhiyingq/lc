class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
        while (root != null) {
        	if (root.left == null) { root = root.right; }
        	else { 
        		TreeNode right = root.right;
        		TreeNode rightmost = root.left;
        		while (rightmost.right != null) { rightmost = rightmost.right; }
        		root.right = root.left;
        		root.left = null;
        		rightmost.right = right;
        		root = root.right;
        	}
        }
    }

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}