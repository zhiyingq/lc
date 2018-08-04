class RemoveDupsSortedList083 {
	// given sorted linked list, delete all dupls 
	public ListNode deleteDuplicates(ListNode head) {
    	ListNode node = head;
        while (node != null) {
       		 while (node.next != null && node.val == node.next.val) {
       			 node.next = node.next.next;
       		 }
       		 node = node.next;
         }
        return head; 
    }

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x;}
	}
}