class RemoveDupsSortedListII082 {
	// Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
	public ListNode deleteDuplicates(ListNode head) {
    	ListNode dummy = new ListNode(0);
 		dummy.next = head;
 		ListNode node = dummy;
 		while (node != null) {
 			boolean duplicate = false;
 			while (node.next != null && node.next.next != null && node.next.val == node.next.next.val) {
 				// if node.next.next == null -> node.next is the last element
                node.next = node.next.next;
 				duplicate = true;
 			}
 			if (duplicate) { node.next = node.next.next; }
 			else { node = node.next; }
 		}
 		return dummy.next;
    }

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}