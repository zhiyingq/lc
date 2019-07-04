class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        // preorder: [root, left, right]
        // postorder: [left, right, root]
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return buildHelper(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }
    
    private TreeNode buildHelper(int[] pre, int[] post, int p1, int p2, int q1, int q2) {
        if (p1 > p2) return null;
        TreeNode root = new TreeNode(pre[p1]);
        if (p1 == p2) return root;
        int leftRoot = pre[p1 + 1];
        int pos = map.get(leftRoot);
        // left len = pos - q1 + 1
        root.left = buildHelper(pre, post, p1 + 1, p1 + pos - q1 + 1, q1, pos);
        root.right = buildHelper(pre, post, p1 + pos - q1 + 2, p2, pos + 1, q2 - 1);
        return root;
    }
}