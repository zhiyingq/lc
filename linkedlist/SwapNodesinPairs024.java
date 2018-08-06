class SwapNodesinPairs024 {
	// Given a linked list, swap every two adjacent nodes and return its head.
	// Recursion
	public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode temp = head.next;
        head.next = swapPairs(temp.next);
        temp.next = head;
        return head;
    }

    public ListNode swapPairsConSpace(ListNode head) {
    	ListNode dummy = new ListNode(0); dummy.next = head;
    	ListNode node = dummy;
    	while (node.next != null && node.next.next != null) {
    		ListNode temp = node.next.next;
    		node.next.next = temp.next;
    		temp.next = node.next;
            node.next = temp;
    		node = node.next.next;
    	}
    	return dummy.next;
    }

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}