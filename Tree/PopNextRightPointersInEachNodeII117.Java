class PopNextRightPointersInEachNodeII117 {
	public void connect(TreeLinkNode root) {
		TreeLinkNode dummyhead = new TreeLinkNode(0);
		TreeLinkNode current = null;
		while (root != null) {
			current = dummyhead;
			while (root != null) {
				if (root.left != null) { current.next = root.left; current = current.next; }
				if (root.right != null) { current.next = root.right; current = current.next; }
				root = root.next;
			}
			root = dummyhead.next;
			dummyhead.next = null;
		}
        
    }

}














