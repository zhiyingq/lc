public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // we know that the total distance should be the same
        // if there is an intersection, headA will be equal to headB
        // else, they will finally reach null
        ListNode nodeA = headA, nodeB = headB;
        while (headA != headB) {
            headA = headA == null ? nodeB : headA.next;
            headB = headB == null ? nodeA : headB.next;
        }
        return headA;
    }
}