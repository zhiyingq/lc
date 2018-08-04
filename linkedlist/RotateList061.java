class RotateList061 {
	public ListNode rotateRight(ListNode head, int k) {
        // 1. get length
        // 2. rotate
        if (head == null || head.next == null) { return head; }
        ListNode tail = head; int length = 1;
        while (tail.next != null) {
        	tail = tail.next;
        	length++;
        }
        // tail -> the end node of the whole list
        int indexOfRotate = k % length;
        if (indexOfRotate == 0) { return head; }
        ListNode node = head;
        for (int i = 0; i < length - indexOfRotate - 1; i++) {
        	node = node.next;
        }
        ListNode newhead = node.next;
        node.next = null; 
        tail.next = head;
        return newhead;
    }
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x;}
	}
}