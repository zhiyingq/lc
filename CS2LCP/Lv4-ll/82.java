class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode node = dummy;
        
        while (node != null) {
            if (node.next != null && node.next.next != null && node.next.val == node.next.next.val) {
                int target = node.next.val;
                while (node.next != null && node.next.val == target) node.next = node.next.next;
            } else { 
                node = node.next; 
            }
        }
        
        return dummy.next;
    }
}