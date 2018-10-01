class SingleNumberII137 {
	public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i : nums) {
        	c = (~a)&b&nums[i] + a&(~b)&(~nums[i]);
        	b = (~a)&(~b)&nums[i] + (~a)&b&(~nums[i]);
        	a = c;
        }
        return b;
    }
}