import java.util.Stack;
class KthSmallestElementinBST230 {
	/*
	basic idea: inorder-traversal
	中序遍历可以保证找到的node是按照从小到大的顺序来的，所以只要等我们count到那个数就可以了
	*/
	public int kthSmallest(TreeNode root, int k) {
        // in-order traversal
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        while (!stack.empty() || root != null) {
        	while (root != null) {
        		// 先push后pop
        		stack.push(root);
        		root = root.left;
        	}
        	TreeNode node = stack.pop();
        	if (++count == k) { return node.val; }
        	root = node.right;
        }
        return -1;
    }
	
    

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) { val = x;}
	}
}