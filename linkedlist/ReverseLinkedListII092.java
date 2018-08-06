class ReverseLinkedListII092 {
	// Reverse a linked list from position m to n. Do it in one-pass.
	// Note: 1 ≤ m ≤ n ≤ length of list.
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// find the nodes
		ListNode dummy = new ListNode(0); 
		dummy.next = head;
		ListNode slow = dummy; ListNode fast = dummy;
		ListNode temp1 = dummy;; ListNode temp2 = dummy;
		for (int i = 0; i < n - m; i++) {
			fast = fast.next;
		}
		for (int i = 0; i < m; i++) {
			fast = fast.next;
			slow = slow.next;
			if (i == m - 2) { temp1 = slow; }
		}
		temp2 = fast.next;
     	// 
     	for (int i = 0; i < n - m + 1; i++) {
     		ListNode temp = slow.next;
     		slow.next = temp2;
     		temp1.next = slow;
     		temp2 = slow;
     		slow = temp;
     	}
    	return dummy.next;  
    }

    public ListNode reverseBetweenOnePass(ListNode head, int m, int n) {
    	// find the nodes
		ListNode dummy = new ListNode(0); 
		dummy.next = head;
		ListNode static_tail = dummy; ListNode static_prev = dummy; 
		ListNode next = dummy;
		// find the node1 and node2
		for (int i = 0; i < m; i++) {
			static_tail = static_tail.next;
			if (i == m - 2) { static_prev = static_tail; }
		}
		next = static_tail.next;
		for (int i = 0; i < n - m; i++) {
			ListNode theNext = next.next;
			next.next = static_prev.next;
			static_tail.next = theNext;
			static_prev.next = next;
			next = theNext;
		}
		return dummy.next;




    
    }

    // reverse the whole linkedlist
    private ListNode reverse(ListNode head) {
    	if (head == null || head.next == null) { return head; }
    	ListNode newhead = reverse(head.next);
    	ListNode tail = newhead;
    	while (tail.next != null) { tail = tail.next; }
    	tail.next = head;
    	head.next = null;
    	return newhead;
    }
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}




}