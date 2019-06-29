class Solution {
    public ListNode sortList(ListNode head) {
        // merge sort, find the middle point, sort left & right, then merge
        if (head == null || head.next == null) return head;
        // System.out.println(head.val);
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
         

        ListNode right = sortList(slow.next);
        slow.next = null;
        ListNode left = sortList(head);
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while (node != null) {
            if (right == null) { node.next = left; break; }
            if (left == null) { node.next = right; break; }
            if (left.val <= right.val) {
                node.next = left;
                left = left.next;
            } else {
                node.next = right;
                right = right.next;
            }
            node = node.next;
        }
        
        return dummy.next;
    }
}