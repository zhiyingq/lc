class RemoveLinkedListElements203 {
	// Remove all elements from a linked list of integers that have value val.
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode node = dummy;
		while (node != null) {
			while (node.next != null && node.next.val == val) {
				node.next = node.next.next;
			}
			node = node.next;
		}
		return dummy.next;
    }

    class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
    }
}