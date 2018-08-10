import java.lang.StringBuffer;
class ConstructStringFromBinaryTree606 {
	public String tree2str(TreeNode t) {
        StringBuffer sb = new StringBuffer();
        tostr(t, sb);
        return sb.toString();

    }

    private void tostr(TreeNode t, StringBuffer sb) {
    	if (t == null) { return; }
    	sb.append(t.val);
    	if (t.left != null) {
    		sb.append('(');
    		tostr(t.left);
    		sb.append(')');
    	}
    	if (t.right != null) {
    		if (t.left == null) { sb.append('('); sb.append(')'); }
    		sb.append('(');
    		tostr(t.right);
    		sb.append(')');
    	}
    	
    }
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}