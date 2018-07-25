class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(countDepth(root.left) - countDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int countDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(countDepth(root.left), countDepth(root.right));
    }
}