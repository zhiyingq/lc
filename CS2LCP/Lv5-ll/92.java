class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // just first locate at the m - 1 th node, keep it
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // left - middle - right
        // left is the tail of the left part
        ListNode left = dummy;
        for (int i = 0; i < m - 1; i++)  left = left.next;
        
        // reverse the right part
        ListNode middleTail = left.next;
        ListNode prev = null, curr = left.next, next = null;
        for (int i = 0; i < n - m + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        middleTail.next = curr;
        left.next = prev;
        return dummy.next;
    }
}