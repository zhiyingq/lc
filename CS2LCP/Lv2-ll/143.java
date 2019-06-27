class Solution {
    public void reorderList(ListNode head) {
        // find the middle point, cut the link, reverse and re-connect
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // cut the link
        ListNode head2 = slow.next;
        slow.next = null;
        
        // Now we have head and head2
        head2 = reverse(head2);
        
        // re-connect the heads
        while (head != null && head2 != null) {
            ListNode temp = head.next;
            ListNode temp2 = head2.next;
            head.next = head2;
            head2.next = temp;
            head = temp;
            head2 = temp2;
        }
        
        dummy.next = null;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;   
        }
        return prev;
    }
}