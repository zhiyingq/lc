import java.util.List;
import java.util.ArrayList;

class UniqueBSTsII095 {
	/* BASIC IDEA
	G(n) = F(1, n) + F(2, n) + .. + F(n, n)
	因此可以把G(n)拆分成∑F(i, n)的形式
	那么对于每一个F(i, n), 其都有: F(i, n) 由G(i - 1)作为左子树  G(n - i)作为右子树
	G(n) = ∑G(i - 1) * G(n - i)的形式
	对于每一个root i, 加上其左边部分i - 1, 再加上其右边部分G(n - i) + i, 这里需要一个Private method

	*/
	public List<TreeNode> generateTrees(int n) {
        if (n < 1) { return new ArrayList<TreeNode>(); }
        // 初始化, list用于存放G(1), G(2), ..., G(n)
        List<TreeNode>[] list = new List[n + 1]; 
        list[0] = new ArrayList<TreeNode>(); 
        list[0].add(null);
        for (int i = 1; i <= n; i++) {  // list[i] = List<TreeNode> = G(i)
        	list[i] = new ArrayList<TreeNode>();
        	for (int j = 1; j <= i; j++) { // G(i) = F(1, i) + F(2, i) + .. + F(j, i) + .. + F(i, i)
        		// F(j, i) = root(j) + root.left(G(j - 1)) + root.right(G(i - j) + j);
        		for (TreeNode nodeL : list[j - 1]) {
        			for (TreeNode nodeR : list[i - j]) {
        				TreeNode root = new TreeNode(j);
        				root.left = nodeL;
        				root.right = plusJ(nodeR, j);
        				list[i].add(root);
        			}
        		}
        	}
        }
        return list[n];
    }

    private TreeNode plusJ(TreeNode node, int delta) {
    	if (node == null) { return node; }
    	TreeNode copy = new TreeNode(node.val + delta);
    	copy.left = plusJ(node.left, delta);
    	copy.right = plusJ(node.right, delta);
    	return copy;
    }

    class TreeNode {
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x) { val = x; }
    }	


}