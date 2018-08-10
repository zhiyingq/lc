import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
class BinaryTreeInorderTraversal094 {
	public List<Integer> inorderTraversalRecur(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        return list;
    }

    public List<Integer> inorderTraversalIter(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            // push the left nodes onto the stack
            while (node != null) { 
                stack.push(node); 
                node = node.left;
            }
            // get the node popped from stack (itself)
            node = stack.pop();
            list.add(node.val);
            // put the right child onto the stack
            node = node.right;
        }
        return list;
    }

    public List<Integer> inorderMorrisTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	TreeNode node = root;
    	while (node != null) {
    		if (node.left == null) {
    			list.add(node.val);
    			node = node.right;
    		}
    		else {
    			// find the most right in it's left child
    			TreeNode mostright = node.left;
    			while (mostright.right != null) {
    				mostright = mostright.right;
    			}
    			// put node after mostright and change node
    			mostright.right = node;
    			TreeNode leftchild = node.left;
    			node.left = null;
    			node = leftchild;
    		}
    	}
    	return list;

    }

    private void inorder(TreeNode node, List<Integer> list) {
    	if (node == null) { return; }
    	inorder(node.left);
    	list.add(node.val);
    	inorder(node.right);
    }



	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x ) { val = x; }
	}
}