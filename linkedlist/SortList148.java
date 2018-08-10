class SortList148 {
	// Sort a linked list in O(n log n) time using constant space complexity.
	public ListNode sortList(ListNode head) {
        // divide and conquor
        // 1. find the mid, divide the linkedlist
        if (head == null || head.next == null) { return head; }
        ListNode slow = head; ListNode fast = head.next; // to make slow stop at middle
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null; // split the linkedlist
        ListNode left = sortList(head);
        ListNode right = sortList(next);
        return merge(left, right);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
    	ListNode dummy = new ListNode(0);
    	ListNode node = dummy;
    	ListNode node1 = head1;
    	ListNode node2 = head2;
    	while (node1 != null && node2 != null) {
    		if (node1.val < node2.val) {
    			node.next = node1;
    			node1 = node1.next;
    		}
    		else {
    			node.next = node2;
    			node2 = node2.next;
    		}
    		node = node.next;
    	}
    	if (node1 == null) { node.next = node2; }
    	if (node2 == null) { node.next == node1; }
    	return dummy.next;
    }

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}