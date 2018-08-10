/*

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

*/
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;
class MinStack155 {

    /** initialize your data structure here. */
    private Node top;

    public MinStack155() {	
    }
    
    public void push(int x) {
    	Node newtop = new Node(x); // create a node
    	newtop.next = top; 
    	if (top != null) { newtop.minSoFar = newtop.value < top.minSoFar ? newtop.value : top.minSoFar; }
    	top = newtop;
    }
    
    public void pop() {
    	if (top == null) { throw new NoSuchElementException(); }
    	top = top.next;	
    }
    
    public int top() {
    	if (top == null) { throw new NoSuchElementException(); }
        return top.value;
    }
    
    public int getMin() {
    	if (top == null) { throw new NoSuchElementException(); }
    	return top.minSoFar;
    }

    class Node {
    	int value;
    	int minSoFar;
    	Node next;
    	public Node(int x) { value = x; minSoFar = x; }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


















