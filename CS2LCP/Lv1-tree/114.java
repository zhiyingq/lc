class Solution {
    TreeNode node = new TreeNode(0);
    public void flatten(TreeNode root) {
        node.right = root;
        TreeNode dummy = node;
        flattenHelper(root);
        dummy.right = null;
    }
    
    private void flattenHelper(TreeNode root) {
        if (root == null) return;
        node.right = root;
        node = root;
        TreeNode right = root.right;
        flattenHelper(root.left);
        root.left = null;
        flattenHelper(right);
    }
}