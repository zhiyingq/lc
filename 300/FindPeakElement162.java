class FindPeakElement162 {
	// a more elegent solution
	public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int low = 0; 
        int high = nums.length - 1;
        while (low < high) {
            // mid is more close to low, since low is always less than high
            // thus mid has a maximum value of nums.length - 2
        	int mid = low + (high - low) / 2;
        	if (nums[mid] > nums[mid + 1]) {
                high = mid;
            }         
        	else {
                low = mid + 1;
            }
        }
        return low;
    }

	public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int low = 0; 
        int high = nums.length - 1;
        while (low < high) {
            // mid is more close to low, since low is always less than high
            // mid can only be possible to be be 0, so we have to deal with it
            // when mid == 0, low must be 0 and high must be 1
        	int mid = low + (high - low) / 2;
        	if (mid == 0) return (nums[low] > nums[high] ? low : high);
            // the peak
        	else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            // on the slope
        	else if (nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            }
            // on the slope or at the base, then any side is ok
        	else {
        		high = mid - 1;
        	}
        }
        return low;
    }
}