/*
Algorithm of Insertion Sort:

1. Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
2. At each iteration, insertion sort removes one element from the input data, 
finds the location it belongs within the sorted list, and inserts it there.
3. It repeats until no input elements remain.
*/
class InsertionSortList147 {

	public ListNode insertionSortList(ListNode head) {
		ListNode dummy = new ListNode(0); // 清新无粘连！ 不需要dummy.next = head;
        ListNode node = head;
        ListNode next;
        while (node != null) {
        	next = node.next;
        	insert(node, dummy);
        	node = next;
        }
        return dummy.next;
    }

    private void insert(ListNode node, ListNode dummy) {
    	ListNode now = dummy.next;
    	ListNode prev = dummy;
    	while (now != null && now.val < node.val) {
    		prev = now;
    		now = now.next;
    	}
    	// 清新无粘连！
    	prev.next = node; 
    	node.next = now;
    }

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}











