class MoveZeroes {
	/*
	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) return;
		int countZero = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 0) {
				countZero++;
				for (int j = i; j < nums.length - countZero; j++) {
					swap(nums, j, j + 1);
				}
			}

		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	*/

	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0) return;
		int nonzeropos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[nonzeropos] = nums[i];
				nonzeropos++;
			}
		}

		for (int i = nonzeropos; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

	public static void main(String[] args) {
		MoveZeroes m = new MoveZeroes();
		int[] a = new int[] {0,1,0,3,12};
		m.moveZeroes(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
}