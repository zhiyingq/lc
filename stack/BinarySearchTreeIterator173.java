import java.lang.Math;
class BinarySearchTreeIterator173 {
	private Stack<TreeNode> stack;
	public BinarySearchTreeIterator173(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
        	stack.push(root);
        	root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty()
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode node = stack.pop();
    	TreeNode next = node.right;
    	while (next != null) {
    		stack.push(next);
    		next = next.left;
    	} 
    	return node.val;    
    }

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}