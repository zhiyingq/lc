import java.util.Arrays;

class NextPermutation031 {
	/*

	*/
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) { return; }
		// find the descend
		int i = nums.length - 2;
		while (nums[i] >= nums[i + 1] && i >= 0) { i--; }
		if (i == -1) { Arrays.sort(nums); return; }
		// get i 
		int j = nums.length - 1;
		while (nums[j] <= nums[i] && j > i) { j--; }
		// get j
		swap(nums, i, j); // swap and keep the sequence 
		reverse(nums, i + 1, nums.length - 1);
		
	}

	private void reverse(int[] nums, int p, int q) {
		while(p < q) {
			swap(nums, p, q);
			p++; q--;
		}
	}

	private void swap(int[] nums, int p, int q) {
		int temp = nums[p];
		nums[p] = nums[q];
		nums[q] = temp;
	}


	public static void main(String[] args) {
		NextPermutation031 n = new NextPermutation031();
		int[] arr = new int[] {2,3,1};
		n.nextPermutation(arr);
		for (int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}
}