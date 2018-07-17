import java.util.Map;
import java.util.HashMap;

public class LinkedListCycleII142 {
	/*
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) { return null; }
		Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
		while (head != null) {
			if (map.containsKey(head)) { return head; }
			else { map.put(head, 1); }
			head = head.next;
		}
		return null;
	}
	*/

	/*
	Lets say that the start of the circle is s;
	and the slow node has taken k steps util it meets the fast node;
	the length of the circle is r;
	=> 2k - k = nr; k = nr;
	say that the slow node is m far away from the circle start node;
	=> k - s = m; s = k - m = nr - m; s = (n-1)r + (r-m);
	meaning that, if a node starts from the head;
	and another node starts from where the slow node meets the fast node;
	oneday after serveral or one circle, they will meet at the start point;
	*/

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) { return null; }
		// the slow node and the fast node starts at the head
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			// if slow == fast, then we can start from the head
			// first update the slow and the fast
			slow = slow.next;
			fast = fast.next.next;
			// if slow meets with fast 
			// we enter a while-loop
			if (slow == fast) {
				while (head != slow) {
					head = head.next;
					slow = slow.next;
				}
				return slow;
			}
		}
		return null;
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}