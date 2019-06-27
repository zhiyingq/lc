class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = dummy.next;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            ListNode temp = next.next;
            prev.next = next;
            next.next = curr;
            curr.next = temp;
            prev = curr;
            curr = temp;
        }
        return dummy.next;
    }
}