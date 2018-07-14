import java.util.Map;
import java.util.HashMap;

class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length == 0) { return false; }
		// construct a map to save the numbers and the corresponding index
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			// if the number has existed, check whether the absolute difference is less or equal than k
			if (map.containsKey(nums[i])) {
				if ((i - map.get(nums[i])) <= k) return true;
			}
			map.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateII c = new ContainsDuplicateII();
		System.out.println(c.containsNearbyDuplicate(new int[] {1,2,3,1,2,3,1}, 2));
	}
}