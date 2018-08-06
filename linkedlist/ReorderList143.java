class ReorderList143 {
	// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
	// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
	// You may not modify the values in the list's nodes, only nodes itself may be changed.
	public void reorderList(ListNode head) {
		ListNode dummy = new ListNode(0); 
		dummy.next = head;
		ListNode slow = dummy; ListNode fast = dummy;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		// get the ListNode that needs to be reversed
		ListNode node1 = slow.next;
		node1 = reverse(node1);
		slow.next = null;
		while (head != null && node1 != null) {
			ListNode temp1 = head.next;
			ListNode temp2 = node1.next;
			head.next = node1;
			node1.next = temp1;
			head = temp1;
			node1 = temp2;
		}

	}

	private ListNode reverse1(ListNode head) {
		if (head == null || head.next == null) { return head; }
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode node = dummy.next.next;
		ListNode first = dummy.next;
		while (node != null) {
			ListNode temp = node.next;
			node.next = dummy.next;
			first.next = temp;
			dummy.next = node;
			node = temp;
		}
		return dummy.next;

	}

	private ListNode reverse2(ListNode head) {
		ListNode prev = null;
		Listnode node = head;
		while (node != null) {
			ListNode next = node.next;
			node.next = prev;
			node = next;
			prev = node;
		}
		return prev;
	}


	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}