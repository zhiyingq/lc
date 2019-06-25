class TopKFrequentElements347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // put all the distinct numbers onto the map, and count the frequency
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // put the pairs/entries onto a priorityqueue
        // get the map entries
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        // we have to iterate the entries in the entrySet
        // the only way to visit the entries is through iterators
        Iterator<Map.Entry<Integer, Integer>> entryIter = entrySet.iterator();
        // implement a priorityqueue with maximum element number of k
        // the priorityqueue will sort the entries through the value, not the key
        // but also this should be a max-heap
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(k,
        	(entry1, entry2) -> (entry1.getValue() - entry2.getValue()));
        while (entryIter.hasNext()) {
        	pq.offer(entryIter.next());
        	if (pq.size() > k) {
        		pq.poll();
        	}
        }

        List<Integer> topK = new ArrayList<Integer>();
        while (!pq.isEmpty()) {
        	topK.add(pq.poll().getKey());
        }

        return topK;

    }

    // bucket sort
    public List<Integer> topKFrequent(int[] nums, int k) {
        // k >= 1, nums.length >= 1
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // put all the distinct numbers onto the map, and count the frequency
        for (int num : nums) {
        	map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // use bucket sort
        // since we want the most frequent numbers, we can implement a List<Integer>[] to save the integers
        // why list[]? because several keys may have a same frequency
        List<Integer>[] bucket = new ArrayList[nums.length + 1]; // bucket[n]: frequency = n
        for (int key : map.keySet()) {
            int freq = map.get(key);
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(key);
        }
        
        List<Integer> topK = new ArrayList<Integer>();
        for (int i = nums.length; i > 0 && topK.size() < k; i--) {
            if (bucket[i] != null) {
                topK.addAll(bucket[i]);
            }
        }

        return topK;
    }
}