class SearchInRotatedSortedArray033 {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) { return -1; }
		if (nums.length == 1 && nums[0] == target) { return 0; }
		int low = 0; int high = nums.length - 1; 
		while(low < high) {
			int mid = (low + high) / 2;
			if (target == nums[mid]) { return mid; }
			if (target == nums[high]) { return high; }
			if (target == nums[low]) { return low; }
			if (nums[low] > nums[mid]) {
				// pivot is at the left side
				// then judge the target
				if (target > nums[mid] && target < nums[high]) {
					// meaning that target is located at [mid,high]
					low = mid + 1;
					continue;
				}
				else {
					high = mid - 1;
					continue;
				}
			}
			else {
				// pivot is at the right side
				if (target < nums[mid] && target > nums[low]) {
					high = mid - 1; continue;
				}
				else {
					low = mid + 1; continue;
				}

			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchInRotatedSortedArray033 s = new SearchInRotatedSortedArray033();
		System.out.println(s.search(new int[] {4,5,6,7,0,1,2}, 3));
	}
}