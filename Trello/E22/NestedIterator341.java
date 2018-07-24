/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

/*
The basic idea is:
1. There is a Stack<NestedInteger> to save the NestedInteger s according to the order in the nestedList
2. ALWAYS keep the fact that the top of the stack is an integer -> see method "stackMaintain()"
3. If we call next(), the top integer will be taken, and the remaining stack will be maintained, to make sure that the 2 is satisfied.
4. If we call hasNext(), we will do NOTHING to the stack, just returning the fact whether we still have some integers left in the stack. 

*/
import java.util.NoSuchElementException;
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> nestStack = new Stack<NestedInteger>(); // construct a new stack to save the NestedIterator
   
    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            this.nestStack.push(nestedList.get(i)); // put all the nestedList to the nestStack
        }
        stackMaintain(); // see methond "stackMaintain()"
    }

    @Override
    public Integer next() {
        // in case of people use too many next() without hasNext(), we should set an "Exception" here
        if (this.nestStack.empty()) { throw new NoSuchElementException(); }
        // since the integer is always on top of the stack, we just pop it and take it
        int next = this.nestStack.pop().getInteger();
        // after the top integer is taken, we should always maintain the stack
        stackMaintain();
        return next;
        
    }

    @Override
    public boolean hasNext() { 
        return (!this.nestStack.empty()); 
        // thanks to stackMaintain(), there is always an integer on top of the stack
        // if there is no integer, this means that the stack is already empty
        // thus, we just need to judge whether the stack is empty
    }
    
    private void stackMaintain() { // the method to make the top of the stack an Integer
        
        // If the stack is empty or the peek is already an integer, we don't do anything
        // But as long as it is not empty && the peek is not an integer, we will keep "maintaining" it
        // util: the peek is integer OR the stack is already empty
        while (!this.nestStack.empty() && !this.nestStack.peek().isInteger()) { 
            // while the peek is not integer, pop() it and add the numbers to the stack util there is an int on top of the stack
            // 1. pop the peek first
            List<NestedInteger> subList= nestStack.pop().getList();
            // 2. add all the elements to the stack, according to the inital order
            for (int i = subList.size() - 1; i >= 0; i--) {
                nestStack.push(subList.get(i));
            }
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */