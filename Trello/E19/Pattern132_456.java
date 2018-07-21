import java.util.Map;
import java.util.TreeMap;
class Pattern132_456 {
	public boolean find132pattern(int[] nums) {
		if (nums == null || nums.length < 3) { return false; }
		int[] diff = new int[nums.length - 1];
		for (int i = 0; i < diff.length; i++) { diff[i] = nums[i + 1] - nums[i]; }
		// The basic idea is, for each number, check the largest positive sum until it (including itself)
		// and check the largest negative sum after it (not included)
		// if the largest positive sum + largest negative sum > 0, then exist, else not
		int maxPositive = 0; 
		for (int i = 0; i < diff.length; i++) {;
			maxPositive = (maxPositive > 0 ? maxPositive : 0) + diff[i];
			if (if132(diff, i + 1, maxPositive)) { return true; }
		}
		return false;
	}

	// given an array, return whether it has a negtive sum after start index
	// which is a little bit smaller than maxP 
	private boolean if132(int[] nums, int start, int maxP) {
		int sum = 0; int negative = Integer.MIN_VALUE; 
		for (int i = start; i < nums.length; i++) {
			sum += nums[i];
			if (sum < 0 && sum + maxP > 0) { return true; }
		}
		return false;
	}

	public static void main(String[] args) {
		Pattern132_456 p = new Pattern132_456();
		System.out.println(p.if132(new int[] {3, -2}, 1, 3));
		System.out.println(p.find132pattern(new int[] {-2, 1, -1}));
	}
}