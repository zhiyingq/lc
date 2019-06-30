class MyLinkedList {
    ListNode sentinel;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.sentinel = new ListNode(0);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        this.size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        return getNode(index).val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        insertBetween(sentinel, sentinel.next, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        insertBetween(sentinel.prev, sentinel, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) { return; }
        if (index < 0) { addAtHead(val); return; }
        if (index == size) { addAtTail(val); return; }
        ListNode node = getNode(index);
        insertBetween(node.prev, node, val);
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return; 
        ListNode node = getNode(index);
        ListNode prevNode = node.prev, nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.prev = null;
        node.next = null;
        size--;
    }
    
    private ListNode getNode(int index) {
        ListNode node = sentinel;
        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node;
    }
    
    private void insertBetween(ListNode prevNode, ListNode nextNode, int val) {
        ListNode node = new ListNode(val);
        node.prev = prevNode;
        node.next = nextNode;
        prevNode.next = node;
        nextNode.prev = node;
        size++;
    }
    
    class ListNode {
        int val;
        ListNode prev, next;
        public ListNode(int val) {
            this.val = val;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */