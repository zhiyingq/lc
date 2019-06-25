class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // setup a dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head; 
        
        ListNode node = dummy;
        while (node != null) {
            while (node.next != null && node.next.val == val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        
        return dummy.next;
    }
}