import java.util.Map;
import java.util.HashMap;
class ConstructBTFromInAndPostorderTraversal106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < inorder.length; i++) {
    		map.put(inorder[i], i);
    	}
    	return buildHelper(inorder, postorder, map, 0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode buildHelper(int[] inorder, int[] postorder, Map<Integer, Integer> map, 
    	int i1, int i2, int p1, int p2) {
    	if (p1 > p2) return;
    	TreeNode root = new TreeNode(postorder[p2]);
    	int j = map.get(postorder[p2]);
    	root.left = buildHelper(inorder, postorder, map,
    		i1, j - 1, p1, p1 + j - i1 - 1);
    	root.right = buildHelper(inorder, postorder, map, 
    		j + 1, i2, p2 - i2 + j, p2 - 1);
    	return root;
    }

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}