class RemoveDuplicatesFromSortedArrayII080{
	public int removeDuplicates(int[] nums) {
        boolean duplicate = false;
        if (nums.length <= 2) return nums.length;
        int i = 1; int j = 1;
        for (; j < nums.length; j++, i++) {
        	while (j < nums.length && nums[j] == nums[j - 1]) {
        		if (duplicate) { j++; }
        		else { 
        			duplicate = true;
        			nums[i++] = nums[j++];
        		}
        	}
            if (j >= nums.length) break;
            duplicate = false;
        	nums[i] = nums[j];
        }
        return i;
    }

    // 跳转法
    // i: 目前为止(0, i - 1)为已经保存的nums
    // 因此应保证nums[j] != nums[i - 2]
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        int i = 2; int j = 2;
        for (; j < nums.length; j++) {
        	if (nums[j] != nums[i - 2]) { nums[i++] = nums[j]; }
        }
        return i;
    }
}