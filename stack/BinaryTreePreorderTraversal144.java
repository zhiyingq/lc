import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
class BinaryTreePreorderTraversal144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		preorderRecur(root, list);
        return list;
    }

    private void preorderRecur(TreeNode root, List<Integer> list) {
    	// visit root, then left, then right
    	if (root == null) return;
        list.add(root.val); 
    	preorderRecur(root.left, list);
    	preorderRecur(root.right, list);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode node = root;
    	while (node != null || !stack.empty()) {
    		while (node != null) {
    			stack.push(node);
    			list.add(node.val);
    			node = node.left;
    		}
    		node = stack.pop();
    		node = node.right;
    	}
    	return list;
    }

    // Morris 
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	TreeNode node = root;
    	while (node != null) {
    		// if the node does not have left child, then just go through
    		list.add(node.val);
    		if (node.left == null) {  node = node.right; }
    		else if (node.right == null) { node = node.left; }
    		else {
    			// put the right child to the lowest node in the left child
    			TreeNode latest = node.left;
    			while (latest.left != null || latest.right != null) {
    				if (latest.right != null) { latest = latest.right; }
    				else {
    					latest = latest.left;
    				}
    			}
    			TreeNode right = node.right;
    			latest.left = right;
    			node.right = null;
    			node = node.left;
    		}
    	}
    	return list;
    }	

	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}










