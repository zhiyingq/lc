public class Solution {
    // 2s - s = nc => s = nc;
    // suppose the starting point to the meeting point has distance l (length, not #nodes)
    // s + (c - l) = x + c, where s - l = x
    // x = (n - 1)*c + (c - l)
    // which means that, if we start from s and start from the head, go c - l steps + (n - 1) cycles, they will meet at x
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        if (fast == null || fast.next == null) return null;
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}