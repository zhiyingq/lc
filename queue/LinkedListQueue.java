import java.util.NoSuchElementException;
public class LinkedListQueue<E> {
	private Node<E> first;
	private Node<E> last;
	// first -> ... -> last
	// every time put in something, we put it in last
	// every time we pop something, we pop first
	public boolean isEmpty() {
		return first == null;
	}

	public void enqueue(E item) {
		Node<E> newlast = new Node<E>(item);
		if (last != null) { last.next = newlast; }
		last = newlast;
		if (first == null) { first = last; }
	}

	public E dequeue() throws NoSuchElementException {
		if (first == null) { throw new NoSuchElementException(); }
		E item = first.item;
		first = first.next;
		if (first == null) { last = null; }
		return item;
	}

	public E peek() throws NoSuchElementException {
		if (first == null) { throw new NoSuchElementException(); }
		return first.item;
	}

	private class Node<E> {
		private E item;
		private Node<E> next;
		public Node(E item) {
			this.item = item;
		}
	}
}