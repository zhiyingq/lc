import java.util.Queue;
import java.util.LinkedList;
class ImplementStackUsingQueues225 {
	private Queue<Integer> queue = new LinkedList<Integer>();
	int size = 0;
	
	public ImplementStackUsingQueues225() {}
	// 每次把x前面的元素放到x后面去
	// 保证x在queue前部
	public void push(int x) {
		queue.add(x);
		for (int i = 0; i < size; i++) {
    		queue.add(queue.poll());
    	}
        size++;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
    	// pop and save the numbers into the tail
    	return queue.poll();
    	
    }
    
    /** Get the top element. */
    public int top() {
        return queue.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0;
    }
}