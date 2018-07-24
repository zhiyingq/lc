import java.util.Iterator;
import java.util.NoSuchElementException;
class PeekingIterator284 implements Iterator<Integer> {
	// The basic idea is, before you call next() or peek() or hasNext()
	// we have already recorded the number: end, peak
	private Iterator<Integer> myIterator; // my own iterator
	private int peek = 0;	// to record the current element, we can imagine that the index ranges from 0 - n-1
	private boolean end = false;	// to record whether the index has reached "n", or beyond the end of the iterator
	public PeekingIterator284(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.myIterator = iterator;
	    this.changePeek();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (!end) { return this.peek; }
        throw new NoSuchElementException();
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		int next = this.peek();
		changePeek();
		return next;
	}

	// move the current peek to the next one, if exists
	// update the peek and end
	private void changePeek() {
		if (this.myIterator.hasNext()) { 
	    	this.peek = this.myIterator.next(); 
	    }
	    else {
	    	this.end = true;
	    }
	}

	@Override
	// Returns true if the iteration has more elements. 
	// (In other words, returns true if next() would return an element rather than throwing an exception.)
	public boolean hasNext() {
	    return !end;
	}

	public static void main(String[] args) {

	}
}