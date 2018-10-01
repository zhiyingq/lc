import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
class SymmetricTree101 {
	public boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root != null) queue.add(root);
		while (queue.size() != 0) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
                if (i < size / 2) { stack.add(node); }
                else if (size != 1) {
                    if (node == null && stack.peek() == null) { stack.pop(); }
                    else if (node != null && stack.peek() != null && node.val == stack.peek().val) { stack.pop(); }
                    else { return false; }
                }
				if (node != null) { queue.add(node.left); queue.add(node.right); }
			}
		}
		return true;
    }

    // Mirror Method
    // 判断一棵树是否是对称结构 只需要判断 *右子树是否是左子树的镜像结构
    // 此时直接“新建”一颗和原来一模一样的树，然后判断他们是否是镜像的结构
    // 如果是镜像结构，说明右子树是左子树的镜像，左子树是右子树的镜像 -》 左=右

    public boolean isSymmetricRecur(TreeNode root) {
    	return isMirror(root, root);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
    	if (node1 == null && node2 == null) return true;
    	if (node1 != null && node2 != null && node1.val == node2.val) {
    		return isMirror(node1.right, node2.left) && isMirror(node1.left, node2.right);
    	}
    	return false;
    }

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}