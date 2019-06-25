class SlidingWindowMaximum239 {
	 public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[] {};
        // implement a treemap to save the entry <nums[i], i>
        TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();
        	
        // the maxWindow to save the largest in sliding window with width k
        int[] maxWindow = new int[nums.length - k + 1];
        
        
        for (int i = 0; i < nums.length; i++) {
        	// for i < k, just put the entries to the tree because there are not enough entries
        	tree.put(nums[i], i);

        	// if i >= k - 1, meaning that there are k elements in the window
        	// however, there may be some duplicates
        	if (i >= k - 1) {
        		// get the last (largest) key of the tree and put it into the max array
        		maxWindow[i - k + 1] = tree.lastKey();
        		// since there are enough entries, we need to remove the oldest one
        		// however, there may exist duplicates
        		// thus we need to check whether the index matches
        		// if matches, just remove it safely
        		// if not match, meaning that the number is covered by some later numbers
        		if (tree.get(nums[i - k + 1]) == i - k + 1) { tree.remove(nums[i - k + 1]); }
        	}
        }

        return maxWindow;
    }
}