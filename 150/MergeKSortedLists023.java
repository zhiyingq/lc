import java.util.PriorityQueue;
class MergeKSortedLists023 {
	public ListNode mergeKLists(ListNode[] lists) {
		// 新建一个minheap存放所有的node
        if (lists.length == 0) { return null; }
        PriorityQueue<ListNode> minheap = new PriorityQueue<ListNode>(lists.length,
        	(node1, node2) -> node1.val - node2.val);
        // 将lists中的node全部放入minheap
        for (ListNode node : lists) { if (node != null) minheap.add(node); }
        ListNode dummy = new ListNode(0);
    	ListNode pointer = dummy;
        while(minheap.size() > 0) {
        	ListNode minNode = minheap.poll();
        	pointer.next = minNode;
        	pointer = pointer.next;
        	if (minNode.next != null) { minheap.add(minNode.next); }
        }
        return dummy.next;      
    }

    class ListNode {
    	public int val;
    	public ListNode next;
    }

    public static void main(String[] args) {

    }
}