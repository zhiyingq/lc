class LinkedListCycleII142 {
	public ListNode detectCycle(ListNode head) { 
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy;
		ListNode fast = dummy;
		boolean cycle = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) { cycle = true; break; }
		}
		if (!cycle) { return null; }
		fast = dummy;
		while (fast != slow) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}