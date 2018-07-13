class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// copy the elements in nums2 to nums1
		for (int i = m; i < m + n; i++) {
			nums1[i] = nums2[i - m];
			int j = i;
			while (j > 0 && nums1[j] < nums1[j - 1]) {
				swap(nums1, j, j - 1);
				j--;
			}
		}
	}

	private void swap(int[] nums, int a1, int a2) {
		int temp = nums[a1];
		nums[a1] = nums[a2];
		nums[a2] = temp;
	}

	


}