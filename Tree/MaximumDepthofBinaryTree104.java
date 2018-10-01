
class MaximumDepthofBinaryTree104 {
	public int maxDepth(TreeNode root) {
        return depthHelper(root, 0);
    }

    private int depthHelper(TreeNode node, int level) {
    	if (node == null) { return level; }
    	int leftdepth = depthHelper(node.left, level + 1);
    	int rightdepth = depthHelper(node.right, level + 1);
    	return leftdepth > rightdepth ? leftdepth : rightdepth;
    }

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) { val = x; }
	}	
}