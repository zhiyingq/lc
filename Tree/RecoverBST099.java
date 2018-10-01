import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class RecoverBST099 {
	public void recoverTree(TreeNode root) {
        List<TreeNode> sequence = new ArrayList<TreeNode>();
        // put the in-order traversal order into the arraylist
        putArray(root, sequence);
        List<Integer> scopy = new ArrayList<>();
        for (TreeNode node : sequence) {
        	scopy.add(node.val);
        }
        Collections.sort(scopy);

        // save the wrong nodes, node1 & node2
        TreeNode node1 = null; TreeNode node2 = null; 
        for (int i = 0; i < sequence.size(); i++) {
        	if (sequence.get(i).val != scopy.get(i)) {    
        		if (node1 == null) { node1 = sequence.get(i); }
        		else { node2 = sequence.get(i); break; }
        	}
        }

        // swap the value of the two nodes
        if (node1 != null && node2 != null) {
        	int temp = node1.val;
        	node1.val = node2.val;
        	node2.val = temp;
        }
    }

    private void putArray(TreeNode root, List<TreeNode> sequence) {
    	if (root == null) return;
    	putArray(root.left, sequence);
    	sequence.add(root);
    	putArray(root.right, sequence);
    }

    public void recoverTree(TreeNode root) {
        TreeNode current = root; TreeNode pred = null;
        TreeNode first = null; TreeNode second = null;
        while (current != null) {
            if (current.left == null) { pred = current; current = current.right; }
            else {
                // if it has left  -> find the rightmost node as its predecessor
                TreeNode prev = current.left;
                while (prev.right != null && prev.right != current) { prev = prev.right; }
                // now prev is the predecessor, but it may be visited
                if (prev.right == current) { // it has been visited
                    prev.right = null;
                    pred = current;
                    current = current.right;
                }
                else {
                    prev.right = current; // the link is used to 1. check whether current has been visited 2. retrack current
                    current = current.left; 
                    // 2 means that, when the last node is visited, it has no left child, it can go right the current
                }
            }
            if (pred != null && current != null && pred.val >= current.val) { 
                if (first == null) { first = pred; } // first == null, update   first != null, just update second
                second = current;
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        
        
    }

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}