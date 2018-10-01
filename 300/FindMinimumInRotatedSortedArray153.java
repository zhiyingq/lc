class FindMinimumInRotatedSortedArray153 {
	public int findMin(int[] nums) {
        int low = 0; int high = nums.length - 1;
        while (low < high) {
            if (nums[low] < nums[high]) return nums[low];
            int mid = low + (high - low) / 2;
            // mid > high, 必有空间向右移动
            if (nums[mid] < nums[high]) { high = mid; }
            else {
                low = mid + 1;
            }
        }        
        return nums[high];
    }
}