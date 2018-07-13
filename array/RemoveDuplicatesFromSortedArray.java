class RemoveDuplicatesFromSortedArray {
	/*
	Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

	Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

	*/
	public int removeDuplicates(int[] nums) {
		// start from the second [1] element
		// because we don't need to consider whether the first element duplicates
		if (nums.length == 0) { return 0; }
		int j = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray r = new RemoveDuplicatesFromSortedArray();
		int arr = r.removeDuplicates(new int[] {});
		System.out.println(arr);
	}
}