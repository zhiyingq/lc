import java.util.Map;
import java.util.HashMap;
import java.lang.IllegalArgumentException;
import java.util.Arrays;

class MajorityElement {
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (nums.length == 1) return nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
				if (map.get(nums[i]) > nums.length/2) {
					return nums[i];
				}
			}
			else {
				map.put(nums[i], 1);
			}
		}
		throw new IllegalArgumentException();

	}

	// method2
	// 由于超过了n/2个元素，那么返回nums.length/2处的元素即可
	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];

	}

	public static void main(String[] args) {
		MajorityElement m = new MajorityElement();
		System.out.println(m.majorityElement(new int[] {1,1,3,1,1,1,1,3,3,3,2}));
	}
	

}