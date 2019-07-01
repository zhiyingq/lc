class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 1. get the length
        // 2. n = k % length
        // 3. find the length - n th element
        // 4. cut the link, make the length - n + 1 element the head
        if (head == null) return null;
        
        int len = 0;
        ListNode node = head, tail = null; 
        while (node != null) {
            if (node.next == null) tail = node;
            node = node.next;
            len++;
        }
        
        int n = k % len;
        ListNode dummy = new ListNode(0);
        dummy.next = head;  
        node = dummy;
        
        for (int i = 0; i < len - n; i++) node = node.next;
        ListNode next = node.next;
        if (next == null) return dummy.next;
        
        node.next = null;
        tail.next = dummy.next;
        dummy.next = next;
        return dummy.next;
        
    }   
}