import java.lang.IllegalArgumentException;
class MissingNumber {
	public int missingNumber(int[] nums) {
		// linear time	
		int[] order = new int[nums.length];
		for (int i = 0; i < order.length; i++) {
			order[i] = -1;
		}
		for (int i : nums) {
			order[i] = i;
		}
		for (int i = 0; i < order.length; i++) {
			if (order[i] == -1) {
				return i;
			}
		}
		throw new IllegalArgumentException();

	}
}