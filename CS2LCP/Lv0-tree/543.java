class Solution {
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dHelper(root);
        return diameter;
    }
    
    private int dHelper(TreeNode root) {
        if (root == null) return 0;
        int left = dHelper(root.left);
        int right = dHelper(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}