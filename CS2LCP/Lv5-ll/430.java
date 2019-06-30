class Solution {
    public Node flatten(Node head) {
        flattenAndGetTail(head);
        return head;
    }
    
    private Node flattenAndGetTail(Node head) {
        if (head == null) return null;
        if (head.child == null) {
            if (head.next == null) return head;
            return flattenAndGetTail(head.next);
        } else {
            // flatten the child node
            Node tail = flattenAndGetTail(head.child);
            Node next = head.next;
            // link the node, child and next
            head.next = head.child;
            head.child.prev = head;
            head.child = null;
            tail.next = next;
            if (next == null) return tail;
            next.prev = tail;
            return flattenAndGetTail(next);
        }
    }
}