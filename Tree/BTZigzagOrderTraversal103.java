import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
class BTZigzagOrderTraversal103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		/*
		创建两个queue用来轮流pop和add某一层的node
		当一个queue pop完毕后，说明这一层的node全部都被遍历过了
		用一个reverse来记录是否是颠倒顺序的加入，用Linkedlist实现的话，永远加入O（0）的位置用的就是O（1）时间
		*/
        List<List<Integer>> zigzag = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root != null) queue1.add(root);
        boolean reverse = false;
        while (queue1.peek() != null || queue2.peek() != null) {
        	Queue<TreeNode> pollQueue = queue1.peek() != null ? queue1 : queue2;
        	Queue<TreeNode> addQueue = queue1.peek() == null ? queue1 : queue2;
            List<Integer> thislevel = new LinkedList<Integer>();
        	while (pollQueue.peek() != null) {       		
        		TreeNode node = pollQueue.poll();
        		if (!reverse) { thislevel.add(node.val); }
        		else { thislevel.add(0, node.val); }
        		if (node.left != null) addQueue.add(node.left);
        		if (node.right != null) addQueue.add(node.right);
            }
            zigzag.add(thislevel); 
        	reverse = !reverse;
        }
        return zigzag;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> zigzag = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        boolean reverse = false;
        // 这题比较tricky的地方在于，每次都要记录下queue的size，“每一次”指的就是每一层
        // 然后只在size允许的范围内进行pop，直到为0为止
        while (queue.size() > 0) {
        	int size = queue.size();
        	List<Integer> thislevel = new LinkedList<Integer>();
        	for (int i = 0; i < size; i++) {
        		TreeNode node = queue.poll();
        		if (!reverse) { thislevel.add(node.val); }
        		else { thislevel.add(0, node.val); }
        		if (node.left != null) queue.add(node.left);
        		if (node.right != null) queue.add(node.right);
        	}
        	zigzag.add(thislevel);
        	reverse = !reverse;
        }
        return zigzag;
    }

    public List<List<Integer>> zigzagLevelOrderRecur(TreeNode root) {
    	List<List<Integer>> zigzagList = new ArrayList<>();
    	// why arraylist? - get(n) faster!
    	zigzagHelper(root, zigzagList, 1);
    	return zigzagList;
    }

    private void zigzagHelper(TreeNode root, List<List<Integer>> zigzagList, int level) {
    	if (root == null) { return; }
    	if (level > zigzagList.size()) {
    		zigzagList.add(new LinkedList());
    	}
    	if (level % 2 != 0) { zigzagList.get(level - 1).add(root.val); }
    	else { zigzagList.get(level - 1).add(0, root.val); }
    	zigzagHelper(root.left, zigzagList, level + 1);
    	zigzagHelper(root.right, zigzagList, level + 1);
    }
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode (int x) { val = x; }
	}
}