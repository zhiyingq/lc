import java.lang.Math;

class MaximumSubarray {
	/*
	public int maxSubArray(int[] nums) {
		if (nums.length == 1) { return nums[0]; }
		if (nums.length == 0) { return 0; }
		// 首先把这道题转换成BestTimeStock问题
		// 那么只要找到gap最大的那一组数即可
		// 但是在这个问题中,gap不一定是要非负，所以后面进行一下调整
		int[] differ = new int[nums.length + 1];
		for(int i = 1; i < differ.length; i++) {
			differ[i] = differ[i - 1] + nums[i - 1];
		}
		return maxGap(differ);
	}

	private int maxGap(int[] nums) {
		// 首先认为gap是负无穷大，minvalue是正无穷大
		int maxgap = Integer.MIN_VALUE;
		int minvalue = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			// 这里gap先算成nums[i]减去之前已知的minvalue
			// 和BestTimeStock不同的是，我可以不用在意之前的minvalue是否大于nums[i]还是小于
			// 因此gap完全可以是负数
			int gap = nums[i] - minvalue;
			// 然后如果nums[i]更小的话，完全可以再更新minvalue值
			minvalue = Math.min(nums[i], minvalue);
			// 然后得到maxgap
			maxgap = Math.max(gap, maxgap);
		}
		return maxgap;
	}
	*/

	// The Kadane Algorithm
	// dynamic programming
	// check the max subarray ending at ith element
	// just need to check the max subarray ending at i-1 th element
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0) { return 0; }
		// 先设置目前最大值nums的第一个数
		int maxCurrentSum = nums[0];
		int maxGlobalSum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			// 目前的最大值 = 现在的数 + max(0, maxCurrentSum);
			maxCurrentSum = nums[i] + (maxCurrentSum > 0 ? maxCurrentSum : 0);
			// 将结果保存至maxGlobalSum中
			maxGlobalSum = Math.max(maxGlobalSum, maxCurrentSum);
			// System.out.println(i+"th iteration: ");
			// System.out.println("maxCurrentSum: "+maxCurrentSum);
			// System.out.println("maxGlobalSum: "+maxGlobalSum);			
		}

		return maxGlobalSum;
	}

	public static void main(String[] args) {
		MaximumSubarray m = new MaximumSubarray();
		m.maxSubArray(new int[] {-2,3,1,4,-5,2,3,-4});

	}







}