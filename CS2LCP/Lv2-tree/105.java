class Solution {
    // preorder: [root, left, right]
    // inorder: [left, root, right]
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return buildHelper(preorder, inorder, 0, n - 1, 0, n - 1);
    }
    
    private TreeNode buildHelper(int[] preorder, int[] inorder, int p1, int p2, int i1, int i2) {
        if (p1 > p2) return null;
        TreeNode root = new TreeNode(preorder[p1]);
        if (p1 == p2) return root;
        int pos = map.get(preorder[p1]);
        root.left = buildHelper(preorder, inorder, p1 + 1, p1 + pos - i1, i1, pos - 1);
        root.right = buildHelper(preorder, inorder, p1 + pos - i1 + 1, p2, pos + 1, i2);
        return root;
    }
}