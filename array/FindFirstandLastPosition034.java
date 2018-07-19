class FindFirstandLastPosition034 {
	public int[] searchRange(int[] nums, int target) {
		int[] range = new int[] {-1, -1};
		if (nums == null || nums.length == 0) { return range; }
		boolean firsttime = true;
		binarysearch(nums, 0, nums.length - 1, target, firsttime, range);
		return range;

	}

	private void binarysearch(int[] nums, int low, int high, int target, boolean firsttime, int[] range) {
		if (low > high) { return; }
		int mid = (low + high) / 2;
		if (nums[mid] == target) {
			if (firsttime) { range[0] = mid; range[1] = mid; firsttime = false; }
			else { 
				range[0] = (mid < range[0] ? mid : range[0]);
				range[1] = (mid > range[1] ? mid : range[1]);
			}
			binarysearch(nums, low, mid - 1, target, firsttime, range);
			binarysearch(nums, mid + 1, high, target, firsttime, range);
		}
		else if (nums[mid] > target) {
			binarysearch(nums, low, mid - 1, target, firsttime, range);
		}
		else {
			binarysearch(nums, mid + 1, high, target, firsttime, range);
		}
	}

	public static void main(String[] args) {
		FindFirstandLastPosition034 f = new FindFirstandLastPosition034();
		int[] range = f.searchRange(new int[] {5}, 5);
		System.out.println(range[0]+" "+range[1]);
	}
}