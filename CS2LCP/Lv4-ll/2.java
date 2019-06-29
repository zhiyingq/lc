class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int num = carry;
            if (l1 != null) { num += l1.val; l1 = l1.next; }
            if (l2 != null) { num += l2.val; l2 = l2.next; }
            node.next = new ListNode(num % 10);
            node = node.next;
            carry = num / 10;
        }
        return dummy.next;   
    }
}