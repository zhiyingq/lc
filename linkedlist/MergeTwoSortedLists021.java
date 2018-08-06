class MergeTwoSortedLists021 {
	// 
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode d1 = dummy;
		ListNode node1 = l1; ListNode node2 = l2;
		while (node1 != null && node2 != null) {
			if (node1.val < node2.val) {
				d1.next = node1;
				node1 = node1.next;
			}
			else {
				d1.next = node2;
				node2 = node2.next;
			}
			d1 = d1.next;
		}
		if (node1 != null) { d1.next = node1; }
		if (node2 != null) { d1.next = node2; }
		return dummy.next;
	}

	// Using recursion
	public ListNode mergeTwoListsRecur(ListNode l1, ListNode l2) {
		if (l1 == null) { return l2; }
		if (l2 == null) { return l1; }
		if (l1.val < l2.val) {
			l1.next = mergeTwoListsRecur(l1.next, l2);
			return l1;
		}
		else {
			l2.next = mergeTwoListsRecur(l1, l2.next);
			return l2;
		}
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}