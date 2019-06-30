class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer  = dummy;
        while (pointer != null) {
            ListNode node = pointer;
            for (int i = 0; i < k; i++) {
                node = node.next;
                if (node == null) return dummy.next;
            }
            
            // reverse the k nodes
            ListNode prev = null, curr = pointer.next, next = null, tail = curr;
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            tail.next = curr;
            pointer.next = prev;
            pointer = tail;
        }
        return dummy.next;
    }
}