import java.util.List;
import java.util.ArrayList;

class BinaryTreeLevelOrderTraversal102 {
	/*
	主要思想是: 
	1. 用DFS遍历
	2. * 用另一个变量height来控制层数，使得相应的node加入相应的list
	3. * 用tree.get(height)来调用之前已经存过的list，这是之前没有想到的。一直不知道怎么调用之前已经创建的list，
	其实原来还可以用这个方法！
	4. 其他，关于控制null，height之类的，自己推算一遍。
	*/
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> tree = new ArrayList<List<Integer>>();
		if (root == null) { return tree; }
		add(tree, root, 0);
		return tree;
	}
 
	private void add(List<List<Integer>> tree, TreeNode node, int height) {
		if (node == null) { return; }
		if (height > tree.size() - 1) { 
			List<Integer> level = new ArrayList<Integer>();
			tree.add(level);
		}
		tree.get(height).add(node.val); 
		height++;
		add(tree, node.left, height);
		add(tree, node.right, height);
	}

	private TreeNode getNode(int x) {
		return new TreeNode(x);
	}


	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) { val = x;}
	}

	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal102 b = new BinaryTreeLevelOrderTraversal102();
		TreeNode root = b.getNode(3);
		root.left = b.getNode(9);
		root.right = b.getNode(20);
		TreeNode right = root.right;
		right.left = b.getNode(15); right.right = b.getNode(7);
		System.out.println(b.levelOrder(root));
	}
}