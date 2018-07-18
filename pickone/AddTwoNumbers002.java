import java.util.ArrayList;

class AddTwoNumbers002 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode sum = head;
		int decimal = 0;
		// as long as there are some digits to add, continue;
		// take notice! if all the digits are used up, but the decimal == 1,
		// the while loop should not terminate
		while (l1 != null || l2 != null || decimal == 1) {
			int num1 = 0;
			if (l1 != null) { num1 = l1.val; }
			int num2 = 0;						// if ends, just use the initial value 0
			if (l2 != null) { num2 = l2.val; } // prevent that l1 ends or l2 ends

			if (num1 + num2 + decimal < 10) {  // less than 10, just add
				sum.val = num1 + num2 + decimal;
				decimal = 0; }					// reset the decimal
			else { 
				sum.val = num1 + num2 + decimal - 10; // larger than 10, - 10
				decimal = 1;					// reset the decimal
			}
			if (l1 != null) { l1 = l1.next; }	// prevent error
			if (l2 != null) { l2 = l2.next; }
			if (l1 != null || l2 != null || decimal == 1) { 	// the same as while-loop
				sum.next = new ListNode(0);	// as long as not terminate, we should add a next node
				sum = sum.next;				// else, we don't need add a next node
			}
		}
		return head;
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		AddTwoNumbers002 a = new AddTwoNumbers002();

	}







}