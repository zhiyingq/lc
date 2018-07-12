class SearchInsertPosition {
	/*
	Given a sorted array and a target value, return the index if the target is found. 
	If not, return the index where it would be if it were inserted in order.
	You may assume no duplicates in the array.
	*/
	public int searchInsert(int[] nums, int target) {
		int low = 0; int high = nums.length - 1;
		return binarySearch(nums, target, low, high);
	}

	private int binarySearch(int[] nums, int target, int low, int high) {
		if (low > high) { return low; }
		int mid = (low + high) / 2;
		if (nums[mid] == target) { return mid; }
		else if (nums[mid] < target) { low = mid + 1; }
		else { high = mid - 1; }
		return binarySearch(nums, target, low, high);
	}

	public static void main(String[] args) {
		SearchInsertPostion s = new SearchInsertPostion();
		int a = s.searchInsert(new int[] {1,3,5,6}, 7);
		System.out.println(a);
	}

}