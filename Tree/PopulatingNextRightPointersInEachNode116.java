class PopulatingNextRightPointersInEachNode116 {
	public void connect(TreeLinkNode root) {
        TreeNode vert = root;
        while (vert != null) {
        	TreeNode hori = vert;
        	while (hori != null) {
        		if (hori.left != null) {
        			hori.left.next = hori.right;
        			if (hori.next != null) { hori.right.next = hori.next.left; }
        			hori = hori.next;
        		}
        		
        	}
        	vert = vert.left;
        }
    }
}