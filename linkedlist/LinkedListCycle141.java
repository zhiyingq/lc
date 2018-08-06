class LinkedListCycle141 {
	// Given a linked list, determine if it has a cycle in it.

	// Follow up:
	// Can you solve it without using extra space?
	public boolean hasCycle(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy; 
		ListNode fast = dummy;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) { return true; }
		}
		return false;
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}