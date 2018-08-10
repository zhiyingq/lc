class ImplementQueueUsingStacks232 {
	/** Initialize your data structure here. */
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
    public ImplementQueueUsingStacks232() {
        
    }
    
    /** Push element x to the back of queue. */
    // 每次放入前，把stack1的元素放到stack2 
    // 放入x, 再把stack2的元素放回stack1
    // 保证x在stack底部 
    public void push(int x) {
        while (!stack1.empty()) { stack2.push(stack1.pop()); }
        stack1.push(x);
        while (!stack2.empty()) { stack1.push(stack2.pop()); }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack1.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
    }
}