import java.util.Map;
import java.util.HashMap;

class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (nums == null || k <= 0) { return false; }
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				// if exist, meaning that there is duplicate
				// then we chan check if the condition is satisfied
				if ((i - map.get(nums[i])) <= k) { return true; }
			}
			// no matter contains or not, we need to update the latest value
			// because the question is <= k, not exactly k
			map.put(nums[i], i);
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateII c = new ContainsDuplicateII();
		System.out.println(c.containsNearbyDuplicate(new int[] {1,2,3,1}, 3));
	}
}