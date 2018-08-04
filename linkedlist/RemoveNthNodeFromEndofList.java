class RemoveNthNodeFromEndofList {
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        // Two pointer method
        if (head == null || n < 0) { return head; }
        int count = 0; int length = 0;
        ListNode slow = head; ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	count++;
        }
        if (fast == null) { length = count * 2; } // even
        else { length = count * 2 + 1; } // odd
        if (n > length) { return head; }

        if ((length - n) > count) { 
        	for (int i = 0; i < length - n - count - 1; i++) {
        		slow = slow.next;
        	}   	
        }
        else {
        	slow = head;
        	for (int i = 0; i < index - 1; i++) {
        		slow = slow.next;
        	}
        }
        slow.next = slow.next.next;
        return head;
    }
    
    public ListNode removeNthFromEndJump(ListNode head, int n) {
    	// 先走法， 让fast先走n步，最后slow在的地方就是倒数n个数的前面一个
    	Node dummy = new ListNode(-1); dummy.next = head;
    	Node fast = dummy; Node slow = dummy;
    	for (int i = 0; i < n; i++) {
    		fast = fast.next;
    	}
    	while (fast.next != null) {
    		fast = fast.next;
    		slow = slow.next;
    	}
    	slow.next = slow.next.next;
    	return dummy.next;
    }



	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}