class JumpGame055 {
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0) { return false; }
		if (nums.length == 1) { return true; }
		// from the last 2 element, go backward
		// check util it can reach the last element OR until the array has been traversed
		// if yes, then repeat
		int jumppoint = nums.length - 1; 
		while (jumppoint > 0) {
			jumppoint = cloestJump(nums, jumppoint);
			// if we find that in some case jumppoint == 0, it means that we can jump
			if (jumppoint == 0) { return true; }
		}
		return false;
	}

	private int cloestJump(int[] nums, int end) { // return the cloest index that can jump to end
		// this function can only be applied to nums.length >= 2
		// end: the index that we wanna reach
		// end ranges from (1, nums.length - 1)
		int i = 1;
		while (nums[end - i] < i) { 
			i++; 
			if (i > end) { break; }
		}	
		return end - i; 
		// if cannot jump to the end, it will return -1
		// if can, it will return the certain index (0<=index<=nums.length - 2)
	}

	public static void main(String[] args) {
		JumpGame055 j = new JumpGame055();
		System.out.println(j.canJump(new int[]{3,2,1,0,4}));

	}
}