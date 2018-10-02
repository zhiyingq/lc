class HouseRobber198 {
	public int rob(int[] nums) {
		int rob = 0;
		int not = 0;

		for (int i = 0; i < nums.length; i++) {
			// rob & not 都是之前的值
			int prevRob = rob;
			rob = not + nums[i]; // now rob = prev not rob + now
			// now not rob: prev_rob OR prev_not_rob, which the larger one
			not = Math.max(prevRob, not);
		}
		return Math.max(rob, not);
	}

	public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        // dp problem
        // for each house, the robber can only reach house + 2 and house + 3
        // because he has no reason to go to house + 4 directly from this house without stealing house + 2
        // nums.length >= 3
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        for (int i = 3; i < dp.length; i++) {
        	dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 3] + nums[i]);
        }
        return Math.max(dp[dp.length - 1], dp[dp.length - 2]);

    }
}