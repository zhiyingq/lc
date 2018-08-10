class ReverseLinkedList206 {
	public ListNode reverseListIter(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode node = head;
		while (node != null) {
			ListNode next = node.next;
			node.next = dummy.next;
			dummy.next = node;
			node = next;
		}
		return dummy.next;  
    }

    public ListNode reverseListRecur(ListNode head) {
    	if (head == null || head.next == null) { return head; }
    	ListNode next = head.next;
    	ListNode newhead = reverseListRecur(next);
    	head.next = null;
    	next.next = head;
    	return newhead;
    }

    private ListNode reverse(ListNode head, ListNode newhead) {

    }

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}