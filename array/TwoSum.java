class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] solution = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					solution[0] = i;
					solution[1] = j;
				}
			}
		}
		return solution;
	}

	public static void main(String args[]) {
		TwoSum a = new TwoSum();
		int[] as = a.twoSum(new int[]{2,7,11,15}, 9);
		for (int i:as) {
			System.out.println(i);
		}
	}
}