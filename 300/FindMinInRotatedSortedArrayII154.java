class FindMinInRotatedSortedArrayII154 {
	public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
        	if (nums[low] < nums[high]) return nums[low];
        	int mid = low + (high - low) / 2;
        	if (nums[mid] < nums[high]) {
        		high = mid;
        	}
        	else if (nums[mid] > nums[high]) {
        		low = mid + 1;
        	}
        	else {
        		high--;
        	}
        }
        return nums[low];
    }
}