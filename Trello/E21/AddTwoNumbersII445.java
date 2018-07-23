import java.util.Stack;
class AddTwoNumbersII445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// basic idea: use two stacks to save l1 and l2, calculate the result
		// and save it in a new stack, then clear the stack and save it to a linked list
		// l1 and l2 are non-empty
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();
		while (l1 != null) { s1.push(l1.val); l1 = l1.next; }
		while (l2 != null) { s2.push(l2.val); l2 = l2.next; }
		int decimal = 0;
		while (s1.size() > 0 || s2.size() > 0 || decimal != 0) {
			int int1 = s1.size() > 0 ? s1.pop() : 0;
			int int2 = s2.size() > 0 ? s2.pop() : 0;
			int sum = int1 + int2 + decimal;
			s3.push(sum % 10);
			decimal = sum / 10;
		}
		ListNode head = new ListNode(0); // the head Node
		ListNode first = head; // to get the reference for head
		while (s3.size() > 0) { 
			head.next = new ListNode(s3.pop()); 
			head = head.next; 
		}
		return first.next;
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		AddTwoNumbersII445 a = new AddTwoNumbersII445();

	}
}