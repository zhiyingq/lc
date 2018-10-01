class MaximumProductSubarray152 {
	// SOLUTION I
	public int maxProduct(int[] nums) {
		// 记录最大值max和最小值min
		// max: 到该点为止可以取到的最大值  
		// min: 到该点为止可以取到的最小值 
		int max = nums[0];
		int min = nums[0];
		int result = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			int temp = max;
			max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
			min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
			if (max > result) {
				result = max;
			}
		}
		return result;

	}



	// SOLUTION II
	public int maxProduct(int[] nums) {
		// get the index of the 0's
        List<Integer> zeroIndex = new ArrayList<Integer>();
        zeroIndex.add(-1);
        for (int i = 0; i < nums.length; i++) { 
        	if (nums[i] == 0) { zeroIndex.add(i); } 
        }
        zeroIndex.add(nums.length);

        int product = Integer.MIN_VALUE;
        for (int i = 0; i < zeroIndex.size() - 1; i++) { 	
        	product = Math.max(product, calculateMax(nums, zeroIndex.get(i), zeroIndex.get(i + 1)));    
        }
        
        if (zeroIndex.size() > 2 && product < 0) return 0;
        return product;
    }

    // calculate the maxProduct in the (start, end) range with no 0s
    // where start and end are not included
    private int calculateMax(int[] nums, int start, int end) {
        // System.out.println("start and end = "+start+" "+end);
        if (end - start < 2) { return Integer.MIN_VALUE; }
        if (end - start == 2) { return nums[start + 1]; }
    	List<Integer> negativeIndex = new ArrayList<Integer>();
    	for (int i = start + 1; i < end; i++) {
    		if (nums[i] < 0) negativeIndex.add(i);
    	}

    	if (negativeIndex.size() % 2 == 0) return calculateProduct(nums, start, end);
        
    	return Math.max(
            Math.max(calculateProduct(nums, start, negativeIndex.get(0)),
    		calculateProduct(nums, negativeIndex.get(0), end)), 
            Math.max(calculateProduct(nums, start, negativeIndex.get(negativeIndex.size() - 1)),
    		calculateProduct(nums, negativeIndex.get(negativeIndex.size() - 1), end))
            );
    }

	// calculate the product in the given range
	// where start and end are not included
	private int calculateProduct(int[] nums, int start, int end) {
        if (end - start < 2) { return Integer.MIN_VALUE; }
		int sum = 1;
		for (int i = start + 1; i < end; i++) {
			sum *= nums[i];
		}
		return sum;
	}
}