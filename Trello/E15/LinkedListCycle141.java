/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
import java.util.Map;
import java.util.HashMap; 
public class LinkedListCycle141 {
	/*
    public boolean hasCycle(ListNode head) {
    	if (head == null) { return false; } 
    	ListNode tail = head;
    	Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
    	map.put(tail, 1);
    	while (tail.next != null) {
    		tail = tail.next;
    		if (map.containsKey(tail)) { return true; }
    		else { map.put(tail, 1); }
    	}  
    	return false; 
    }
    */

    public boolean hasCycle(ListNode head) {
    	// two pointers
    	// Use a faster one to chase the slower one
    	// faster speed: 2, slower speed: 1
    	// if fast == slow => circle here
    	if (head == null || head.next == null) { return false; }
    	ListNode slow = head;
    	ListNode fast = head.next;
    	while(fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    		if (fast == slow) { return true; }
    	}
    	return false;
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