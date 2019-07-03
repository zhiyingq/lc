class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        // in-order-traversal: left, root, right
        List<Integer> inorder = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            TreeNode popped = stack.pop();
            inorder.add(popped.val);
            node = popped.right;
        }
        return inorder;
    }
}