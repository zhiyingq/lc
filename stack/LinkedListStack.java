import java.lang.IllegalAccessException;
public class LinkedListStack<E> {
	private Node<E> first;
	// first -> ... -> bottom
	// every time we add something, we add to the first
	// every time we pop something, we pop the first as well
	public boolean isEmpty() { return first == null; }

	public void push(E item) {
		Node<E> newfirst = new Node<E>(item);
		newfirst.next = first;
		first = newfirst;
	}

	public E pop() throws IllegalAccessException {
		if (first == null) { throw new IllegalAccessException(); }
		E item = first.item;
		first = first.next;
		return item;
	}
	
	public E peek() throws IllegalAccessException {
		if (first == null) { throw new IllegalAccessException(); }
		return first.item;
	}

	class Node<E> {
		private E item;
		private Node<E> next;
		public Node(E item) {
			this.item = item;
		}
	}

	public static void main(String[] args) {

	}
}