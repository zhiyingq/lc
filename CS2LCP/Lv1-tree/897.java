class Solution {
    TreeNode dummy = new TreeNode(0);
    public TreeNode increasingBST(TreeNode root) {
        TreeNode node = dummy;
        inorder(root);
        return node.right;
        
    }
    
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        dummy.right = root;
        dummy = dummy.right;
        root.left = null;
        inorder(root.right);
    }
}