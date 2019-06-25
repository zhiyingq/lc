class ProductOfArrayExceptSelf238 {
	public int[] productExceptSelf(int[] nums) {
		// 其主要思想是，用two-pointer
		// 第一遍的时候每个nums[i]记录的是0->i-1的乘积
		// 第二遍的时候每个nums[i]再乘上n-1 -> i+1的乘积
		
		int n = nums.length;
		int[] productArray = new int[n];
		productArray[0] = 1;
		
		int left = 1;
		for (int i = 1; i < n; i++) {
			left *= nums[i - 1];
			productArray[i] = left;
		}

		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			productArray[i] *= right;
			right *= nums[i];
		}

		return productArray;
    }
}