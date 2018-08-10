import java.util.Map;
import java.util.HashMap;
class CopyListwithRandomPointer138 {
	public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode copy = dummy;
        Map<RandomListNode, Integer> map = new HashMap<RandomListNode, Integer>();
        RandomListNode origin = head; int count = 0;
        while (origin != null) {
        	map.put(origin, count); // put the node into the map
        	copy.next = new RandomListNode(origin.label); // copy the node to the new linkedlist
       		copy = copy.next;
       		origin = origin.next;
       		count++;
        }
        RandomListNode[] nodes = new RandomListNode[count];
        copy = dummy;
        for (int i = 0; i < count; i++) {
        	nodes[i] = copy.next;
        	copy = copy.next;
        }
        origin = head;
        copy = dummy.next;
        for (int i = 0; i < count; i++) {
        	if (origin.random == null) { copy.random = null; }
        	else {
        		int index = map.get(origin.random);
        		// System.out.println(i + "th: random = "+origin.random.label+" index = "+index);
        		copy.random = nodes[index];
        		// System.out.println("copy.random: "+copy.random.label);
        	}
        	copy = copy.next;
        	origin = origin.next;
        }
        return dummy.next;

    }

    public RandomListNode copyRandomListMap(RandomListNode head) {
    	Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode origin = head;
        while (origin != null) {
        	map.put(origin, new RandomListNode(origin.label));
        	origin = origin.next;
        }
        origin = head;
        while (origin != null) {
        	map.get(origin).next = map.get(origin.next);
        	map.get(origin).random = map.get(origin.random);
        	origin = origin.next;
        }
        return map.get(head);

    }

    class RandomListNode {
    	int label;
    	RandomListNode next, random;
    	RandomListNode(int x) { this.label = x; }
    }

    public void Test() {
    	RandomListNode node1 = new RandomListNode(1);
    	RandomListNode node2 = new RandomListNode(2);
    	RandomListNode node3 = new RandomListNode(3);
    	RandomListNode node4 = new RandomListNode(4);
    	node1.next = node2; node1.random = node4;
    	node2.next = node3; node2.random = node2;
    	node3.next = node4; node3.random = null;
    	node4.next = null; node4.random = node1;
    	print(node1);
    	RandomListNode copy = copyRandomListMap(node1);
    	print(copy);
    	

    }
 
    private void print(RandomListNode node) {
    	while (node != null) {
    		System.out.print(node.label+" next: "+
    			(node.next == null ? "null":node.next.label)+" random: "+
    			(node.random == null ? "null":node.random.label));
    		System.out.println();
    		node = node.next;
    	}
    }

    public static void main(String[] args) {
    	CopyListwithRandomPointer138 c = new CopyListwithRandomPointer138();
    	c.Test();
    }
}












