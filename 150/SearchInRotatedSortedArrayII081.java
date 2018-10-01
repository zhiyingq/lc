class SearchInRotatedSortedArrayII081 {
	public boolean search(int[] nums, int target) {
        // 分情况讨论Pivot在左边还是在右边
        return searchHelper(nums, target, 0, nums.length - 1);

    }

    private boolean searchHelper(int[] nums, int target, int low, int high) {
    	if (low > high) return false;
    	int mid = low + (high - low) / 2;
    	if (nums[mid] == target || nums[low] == target || nums[high] == target) return true;
    	// 两边都有可能存在解
    	if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
    		return searchHelper(nums, target, low + 1, mid - 1) || searchHelper(nums, target, mid + 1, high - 1);
    	}

    	// 不规则的在右边，左边是按照顺序排列的
    	if (nums[low] <= nums[mid]) {
    		if (target > nums[low] && target < nums[mid]) {
    			return searchHelper(nums, target, low + 1, mid - 1);
    		}
    		return searchHelper(nums, target, mid + 1, high - 1);
    	}
    	// 不规则的在左边，右边是按照顺序排列的
    	else {
    		if (target > nums[mid] && target < nums[high]) {
    			return searchHelper(nums, target, mid + 1, high - 1);
    		}
    		return searchHelper(nums, target, low + 1, mid - 1);
    	}
    }
}