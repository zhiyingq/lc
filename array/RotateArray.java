class RotateArray {
	public void rotate1(int[] nums, int k) {
		//Brute Force
		int[] copy = new int[nums.length];
		int step = k % nums.length;
		for (int j = step; j < nums.length; j++) {
			copy[j] = nums[j - step];
		}
		for (int j = 0; j < step; j++) {
			copy[j] = nums[nums.length - step + j];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = copy[i];
		}
	}

	public void rotate2(int[] nums, int k) {
		// reverse, reverse, reverse!
		// 原地翻转法
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		

	}

	private void reverse(int[] nums, int low, int high) {
		while(low < high) {
			swap(nums, low, high);
			low++;
			high--;
		}
	}

	private void swap(int[] nums, int a1, int a2) {
		int temp = nums[a1];
		nums[a1] = nums[a2];
		nums[a2] = temp;
	}

	public static void main(String[] args) {
		RotateArray r = new RotateArray();
		r.rotate2(new int[] {1,2,3,4,5,6,7}, 3);

	}
}