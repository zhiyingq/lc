class ConvertSortedListToBinarySearchTree109 {
	/* 本题是一道LinkedList题目，想到LinkedList就要首先想到
	 * 1. recursion 2. two-pointer
	 * 这道题直接用recursion不太好做，考虑recursion + two-pointer
	 * 考虑BST树的性质，[-10, -3, 0, 5, 9]，把中间的点作为根节点，左边的都比它小，右边的都更大
	 * 那么我们就可以先找到中间的点作为根节点，然后再递归左子树和右子树，这样也可保证它是平衡的
	 * 因为左右子树的node不会差超过1
	 */
	public TreeNode sortedListToBST(ListNode head) {
		return sortHelper(head, null);
    }

    private TreeNode sortHelper(ListNode head, ListNode tail) {
    	if (head == tail) return null;
    	ListNode slow = head;
    	ListNode fast = head;
    	// 定位slow和fast, fast最后可能为tail
    	// 如果LinkedList有奇数个元素，slow最终会停留在正中间
    	// 如果有偶数个元素，则会停留在中间靠右
    	// [head, node2, node3, ..., tail) tail是不包含的
    	while(fast != tail && fast.next != tail) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	TreeNode root = new TreeNode(slow.val);
    	root.left = sortHelper(head, slow);
    	root.right = sortHelper(slow.next, tail);
    	return root;
    }
}

























