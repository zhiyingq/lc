class IntersectionofTwoLinkedLists160 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // intuition:
        // 考虑两个single linked list的总长度
        // 如果两个指针都走A和B，那么总长度一定相等
        // 假设他们含有共同的片段
        // 由于single linked list的特性，一旦重合了就不可能分叉了，因为分叉需要两个next
        // 由此，总长度相等，重复部分相等，那么第一次相等的时候 = 重复部分开始的时候
        // 而如果没有重合 那么走完总长也不会重合，就判断最后一个数是否相等即可
        if (headA == null || headB == null) { return null; }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        boolean termA = false; boolean termB = false;
        while (nodeA != null && nodeB != null && nodeA != nodeB) {
        	if (nodeA.next == null) { 
        		if (termA) return null; 
        		nodeA = headB; 
        		termA = true; 
        		}
        	else {
        		nodeA = nodeA.next;
        	}
        	if (nodeB.next == null) { 
        		if (termB) return null;
        		nodeB = headA; 
        		termB = true; 
        		}
        	else {
        		nodeB = nodeB.next;
        	}
        }
        return nodeA;
    }
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; next = null; }
	}
}