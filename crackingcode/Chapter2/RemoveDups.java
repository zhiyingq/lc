import java.util.Set;
import java.util.HashSet;
class RemoveDups {
	// write code to remove duplicates from an unsorted linked list
	public void removeDups(Node head) {
		if (head == null || head.next == null) { return; }
		Node node = head; 
		Set<Integer> set = new HashSet<Integer>();
		while (node != null && node.next != null) {
			set.add(node.val);
			while (set.contains(node.next.val)) {
				node.next = node.next.next;
				if (node.next == null) break;
			}
			node = node.next;
		}
	}

	public void removeDupsNoSpace(Node head) {
		Node node = head;
		// check every node and the following node
		// 比如check head的时候，凡是所有和head的值相等的node，将会一律被跳过
		// 因此最后时间是O(n2)
		while (node != null) {
			Node follow = node;
			while (follow.next != null) {
				if (follow.next.val == node.val) {
					follow.next = follow.next.next;
				}
				else {
					follow = follow.next;
				}
			}
			node = node.next;
		}
	}

	private void print(Node node) {
		while (node != null) {
			System.out.print(node.val + " -> ");
			node = node.next;
		}
		System.out.println();
	}

	private void test() {
		Node head = new Node(1);
		Node node = head; 
		node.next = new Node(2); node = node.next;
		node.next = new Node(1); node = node.next;
		node.next = new Node(2); node = node.next;
		node.next = new Node(2); node = node.next;
		node.next = new Node(2); node = node.next;
		node.next = new Node(1); node = node.next;
		node.next = new Node(1); node = node.next;
		node.next = new Node(1); node = node.next;
		node.next = new Node(4); node = node.next;
		node.next = new Node(1); node = node.next;
		this.print(head);
		removeDupsNoSpace(head);
		this.print(head);
	}

	class Node {
		Node next = null;
		int val;
		public Node(int n) { this.val = n; }
		public Node(Node next, int n) {
			this.next = next;
			this.val = n;
		}
	}

	public static void main(String[] args) {
		RemoveDups r = new RemoveDups();
		r.test();


		
		

	}
}