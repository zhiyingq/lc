import java.util.Map;
import java.util.HashMap;
class ConstructBTFromPreAndInorder105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
       	return buildHelper(map, preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildHelper(Map<Integer, Integer> map, int[] preorder, int[] inorder, 
    	int p1, int p2, int i1, int i2) { // included [start, end]
    	if (p1 > p2) { return null; }
    	if (p1 == p2) { return new TreeNode(preorder[p1]); }
    	TreeNode root = new TreeNode(preorder[p1]);
    	int j = map.get(preorder[p1]);
    	root.left = buildHelper(map, preorder, inorder, p1 + 1, p1 + j - i1, i1, j - 1);
    	root.right = buildHelper(map, preorder, inorder, p1 + j - i1 + 1, p2, j + 1, i2);
    	return root;
    }
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}