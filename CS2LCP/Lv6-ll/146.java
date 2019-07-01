class LRUCache {
    // LRU: 
    // 1. we need to implement a linkedlist
    // 2. we also need to map the value <-> node in the linkedlist
    List list;
    Map<Integer, ListNode> map;
    int capacity;
    public LRUCache(int capacity) {
        this.list = new List();
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        ListNode node = map.get(key);
        if (node == null) return -1;
            
        list.moveToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node = map.get(key);
        if (node != null) {
            node.val = value;
            list.moveToHead(node);
        } else {
            node = new ListNode(key, value);
            list.insertToHead(node);
            map.put(key, node);
            if (map.size() > capacity) {
                int last = list.popLast();
                map.remove(last);
            } 
        }
    }
    
    // api needed: insertToHead, moveToHead, popLast
    // 
    class List {
        ListNode root;
        public List() {
            root = new ListNode(0, 0);
            root.prev = root;
            root.next = root;
        }
        
        public void insertToHead(ListNode node) {
            ListNode head = root.next;
            
            head.prev = node;
            root.next = node;
            node.prev = root;
            // System.out.println("node.prev = root;");
            node.next = head;
            // System.out.println("node.next = head;");
           
            // System.out.println("head.prev = node;");
            
        }
        
        public void moveToHead(ListNode node) {
            ListNode prev = node.prev, next = node.next;
            prev.next = next;
            next.prev = prev;
            
            ListNode head = root.next;
            node.next = head;
            node.prev = root;
            head.prev = node;
            root.next = node;
        }
        
        public int popLast() {
            ListNode last = root.prev;
            last.prev.next = root;
            root.prev = last.prev;
            last.prev = null;
            last.next = null;
            return last.key;
        }
        
    }
    
    class ListNode {
        ListNode prev;
        ListNode next;
        int val;
        int key;
        public ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
}