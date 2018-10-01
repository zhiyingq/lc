class BinaryTreePostorderTraversal145 {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderHelper(root, list);
        return list;
    }

    private void postorderHelper(TreeNode root, List<Integer> list) {
    	if (root == null) return;
    	postorderHelper(root.left, list);
    	postorderHelper(root.right, list);
    	list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>(); 
        TreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                stack.push(node);
                list.add(0, node.val);
                node = node.right;
            }
            node = stack.pop();
            node = node.left;
        }
        return list;
    }
}












