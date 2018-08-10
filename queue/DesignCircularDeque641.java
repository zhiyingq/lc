class DesignCircularDeque641 {
	/** Initialize your data structure here. Set the size of the deque to be k. */
    Node dummy;
    int size;
    int limit;
    public DesignCircularDeque641(int k) {
    	dummy = new Node(-1);
    	dummy.next = dummy; dummy.prev = dummy;
        size = 0; limit = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
    	if (size >= limit) { return false; }
    	Node node = new Node(value);
    	node.next = dummy.next;
    	node.prev = dummy;
    	dummy.next.prev = node;
    	dummy.next = node;
    	size++;
    	return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size >= limit) { return false; }
        Node node = new Node(value);
        node.next = dummy;
        node.prev = dummy.prev;
        dummy.prev.next = node;
        dummy.prev = node;
        size++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size <= 0) { return false; }
        dummy.next.next.prev = dummy;
        dummy.next = dummy.next.next;
        size--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
    	if (size <= 0) { return false; }   	
    	dummy.prev = dummy.prev.prev;
    	dummy.prev.next = dummy;
    	size--;
    	return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return dummy.next.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return dummy.prev.val;
        
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == limit;
    }

    class Node {
    	int val;
    	Node next;
    	Node prev;
    	Node(int x) { val = x; }
    }
}









