class SortColors075 {
	// Coungting Sort
	public void sortColors(int[] nums) {
        if (nums.length == 0) return;
        int reds = 0; int whites = 0; int blues = 0;
        for (int i : nums) {
        	if (i == 0) { reds++; }
        	else if (i == 1) { whites++; }
        	else { blues++; }
        }

        for (int i = 0; i < reds; i++) { nums[i] = 0; }
        for (int i = reds; i < reds + whites; i++) { nums[i] = 1; }
        for (int i = reds + whites; i < reds + whites + blues; i++) { nums[i] = 2; }     
    }

	// One-Pass solution
	// j: index of last 0 + 1
	// k: index of first 2 - 1
	public void sortColors(int[] nums) {
		int j = 0; int k = nums.length - 1;
		for (int i = 0; i <= k; i++) {
			// 换回来的肯定是0或1，如果是0，不用换，如果是1，也不用换
			if (nums[i] == 0) {
				swap(nums, i, j++);
			}
			// 换回来的可能是0、1、2，因此需要再check一次
			else if (nums[i] == 2) {
				swap(nums, i--, k--);
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
        
        
}