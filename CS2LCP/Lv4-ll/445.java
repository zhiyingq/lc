class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode node = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int num = carry; 
            if (!stack1.isEmpty()) num += stack1.pop(); 
            if (!stack2.isEmpty()) num += stack2.pop();
            ListNode newNode = new ListNode(num % 10);
            newNode.next = node;
            node = newNode;
            carry = num / 10;
        }
        return node;
    }
}