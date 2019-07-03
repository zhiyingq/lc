class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        getLeavesHelper(root1, l1);
        getLeavesHelper(root2, l2);
        if (l1.size() != l2.size()) return false;
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i)) return false;
        }
        return true;
        
    }
    
    private void getLeavesHelper(TreeNode node, List<Integer> leaves) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        } else {
            getLeavesHelper(node.left, leaves);
            getLeavesHelper(node.right, leaves);
        }
    }
}