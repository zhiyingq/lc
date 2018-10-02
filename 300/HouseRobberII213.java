class HouseRobberII213 {
	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
        return Math.max(robPartial(nums, 0, nums.length - 1), 
        	robPartial(nums, 1, nums.length));
    }

    public int robPartial(int[] nums, int start, int end) {
    	int prevrob = 0; // denote the previous or present rob amount
    	int prevnot = 0; // denote the previous or present not rob amount
    	for (int i = start; i < end; i++) {
    		int temp = prevrob;
    		prevrob = prevnot + nums[i]; // now rob = prev not rob + this house
    		prevnot = Math.max(temp, prevnot); // now not rob = the max value of prev rob or prev not rob
    	}
    	return Math.max(prevrob, prevnot);
    }
}