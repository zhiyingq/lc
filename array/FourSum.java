import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 4) { return result; }
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			// 每次都停留在重复项的第一个数上，当这个数计算完后就跳过这一系列重复项
			// 这是因为计算的时候，含有该数的所有组合已经遍历，因此无需再计算
			if (i > 0 && nums[i] == nums[i - 1]) { continue; }
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) { break; }
			int threetarget = target - nums[i];

			// 3-sum
			for (int j = i + 1; j < nums.length - 2; j++) {
				// 同理 当到达3sum的时候，该数后续的2-sum会遍历所有的情况，所以遇到类似的直接跳过即可
				if (j > i + 1 && nums[j] == nums[j - 1]) { continue; }
				if (nums[j] + nums[j + 1] + nums[j + 2] > threetarget) { break; }

				// 2-sum
				int twotarget = threetarget - nums[j];
				int p = j + 1; int q = nums.length - 1;
				while (p < q) {
					if (nums[p] + nums[q] == twotarget) { 
						result.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
						p++; q--;
						while (p < q && nums[p] == nums[p - 1]) { p++; }
						while (p < q && nums[q] == nums[q + 1]) { q--; }
					} 
					else if (nums[p] + nums[q] > twotarget) { q--; }
					else { p++; }
				}
			}
		}
		return result;


	}

	public static void main(String[] args) {
		FourSum s = new FourSum();
		// 
		System.out.println(s.fourSum(new int[] {1, 0, -1, 0, -2, 2}, 0));

	}
}