class KthLargestElementInAnArray215 {
	// use priorityqueue O(nlogk) time and O(k) space
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        // put the elements into the pq, while keep the max size of pq to be k
        for (int num : nums) {
        	pq.offer(num);
        	if (pq.size() > k) {
        		pq.poll();
        	}
        }
        return pq.peek();
    }

    // use quick - select
    public int findKthLargest(int[] nums, int k) {
        // k - the index
        k = nums.length - k;
    	int low = 0, high = nums.length - 1;
    	while (high > low) {
    		int j = partition(nums, low, high);
    		if (j > k) { high = j - 1; }
    		else if (j < k) { low = j + 1; }
    		else {
    			return nums[j];
    		}
    	}
    	return nums[high];
	}

	// partition the nums array in the range from low -> high
	// the first element is the pivot
	// return the index of the pivot after partition
	private int partition(int[] nums, int low, int high) {
		if (low == high) return nums[low];
		int i = low, j = high + 1;
		while (true) {
			// nums[i] is the first number that >= nums[low]
			// but we need to consider if it will exceed the boundary
			while (less(nums[++i], nums[low])) {
				if (i == high) break;
			}

			// nums[j] is the first number that <= nums[low]
			// in fact we don't need to consider the boundary
			// because if j == low it will automatically jump out of the loop
			while (less(nums[low], nums[--j])) {
				if (j == low) break;
			}

			if (i >= j) break;
			swap(nums, i, j);
		}
		// now index[j] is the pivot number
		swap(nums, j, low);
		return j;
	}

	private boolean less(int a, int b) {
		return a < b;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}



















