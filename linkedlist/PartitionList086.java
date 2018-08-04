class PartitionList086 {
	/*
	Given a linked list and a value x, partition it such that all nodes less than x come before 
	nodes greater than or equal to x.

	You should preserve the original relative order of the nodes in each of the two partitions.
	*/
	public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0); dummy.next = head;
        ListNode tail = dummy;
        int length = 0;
        while (tail.next != null) { tail = tail.next; length++; }
        // we get the <tail> and the <length>
        ListNode node = dummy;
        for (int count = 0; count < length; count++) {
        	if (node.next.val >= x) {
        		tail.next = node.next;
        		tail = tail.next;
        		node.next = node.next.next;
        		tail.next = null;
        	}
        	node = node.next;
        }
        return dummy.next;
    }

    public ListNode partitionOnePass(ListNode head, int x) {
    	// dummy1 and dummy2 save the larger and smaller nodes
    	ListNode dummy1 = new ListNode(0); // larger
    	ListNode dummy2 = new ListNode(0); // smaller
    	ListNode node1 = dummy1;
    	ListNode node2 = dummy2;
    	while (head != null) {
    		if (head.val >= x) {
    			node1.next = head;
    			node1 = node1.next;
    		}
    		else {
    			node2.next = head;
    			node2 = node2.next;
    		}
    		head = head.next;
    	}
    	node2.next = dummy1.next;
    	node1.next = null;
    	return dummy2.next;
    }

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}